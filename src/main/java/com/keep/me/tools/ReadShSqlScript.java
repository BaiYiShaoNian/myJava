package com.keep.me.tools;

/**
 * Create by huangxuanfeng on 2019/12/13 上午10:21
 */
import lombok.Data;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class ReadShSqlScript {
    private static Log logger = LogFactory.getLog(ReadShSqlScript.class);
    private static final String SEPARATE_COMMA = ",";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 存储血缘关系
     */
    private Map<String, String> parseMap = new HashMap<>();  // 获取解析得到的依赖
    private Map<String, String> upMap = new HashMap<>();  // 存储上游依赖
    private Map<String, String> downMap = new HashMap<>();  // 存储下游依赖
    private List<String> bussinessList = new ArrayList<>();  // 存储需要解析血缘关系的业务线

    /**
     * 遍历文件目录，找到sh脚本+SQL脚本
     * @param path
     */
    private void viewPath(String path) {
        File file = new File(path);
        //System.out.println(file);
        //System.out.println(file.toString().endsWith(".sql"));
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            if (fs == null) {
                return;
            }
            for (File f : fs) {
                viewPath(f.toString());
            }
        }
        if (file.toString().endsWith(".sql")) {
            //for(String str: bussinessList) {
            //    //System.out.println(file.toString());
            //    //System.out.println(str + " " + file.toString().contains(str));
            //    if(file.toString().contains(str)) {
            //        parseSQL(file);
            //    }
            //}
            System.out.println("开始解析文件路径： " + file.toString());
            //logger.info("开始解析文件路径: " + file.toString());
            try {
                parseSQL(file);
            } catch (Exception e) {
                System.out.println(file + " 解析不正确");
            }
            //parseSQL(file);
        }
    }

    /**
     * 目前仅仅对SQL脚本解析出脚本里的SQL语句
     * @param file
     */
    private void parseSQL(File file) {
        String hql = "";

        try {
            hql = FileUtils.readFileToString(file, "UTF-8")
                    .toLowerCase()
                    .replaceAll("\\*", "1");
            String[] hqls = hql.split(";", -1);
            for(String hqlTmp : hqls) {
                // 解析上游依赖血缘关系
                parseBloodUp(hqlTmp);
            }
        } catch (IOException e) {
            logger.error("can't parse sql");
        }
    }

    /**
     * 解析上游依赖血缘关系
     * @param hql
     */
    private void parseBloodUp(String hql) {
        // 参数替换
        String pattern = "\\$\\{.*?\\}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(hql);
        hql = m.replaceAll("20180818")
            .replaceAll("\n", " ")
            .replaceAll(" {1,}", " ");

        //System.out.println("HQL如下： " + hql);

        if (hql.contains("insert") || hql.contains("INSERT") ||
                hql.contains("create") || hql.contains("CREATE")) {
            HiveLineageInfo hiveLineageInfo = new HiveLineageInfo();
            try {
                hiveLineageInfo.getLineageInfo(hql);
                String input = hiveLineageInfo.getInputTableList().toString()
                        .replaceAll("[\\[\\] ]", "");
                String output = hiveLineageInfo.getOutputTableList().toString()
                        .replaceAll("[\\[\\] ]", "");
                if (input.length()>2 && output.length()>2) {
                    upMap.put(output, input);  // key为目标表，value为源表
                }
            } catch (Exception e) {
                logger.error("parse lineage error");
            }
        }
    }

    /**
     * 解析下游依赖血缘关系
     */
    private void parseBloodDown() {
        Map<String, String> tmpMap = new HashMap<>();
        for (Map.Entry entry: upMap.entrySet()) {
            String destTable = entry.getKey().toString();
            String[] srcTables = entry.getValue().toString().split(SEPARATE_COMMA);
            for (String srcTable: srcTables) {
                if (tmpMap.containsKey(srcTable)) {
                    tmpMap.put(srcTable, tmpMap.get(srcTable) + ", " + destTable);
                } else {
                    tmpMap.put(srcTable, destTable);
                }
            }
        }
        for (Map.Entry<String, String> entry: tmpMap.entrySet()) {
            downMap.put(entry.getKey(), entry.getValue());
        }
    }

    private void getAvaliablePath() {
        String bussiness = "";
        try {
            //File file = new File("/Users/huangxuanfeng/Documents/parse_bussiness_name.txt");
            File file  = new File("/disk/m/airflow/hdfs/warehouse_jar/blood_dependency/parse_bussiness_name.txt");
            bussiness = FileUtils.readFileToString(file, "UTF-8")
                    .replace("\n", "#");
        } catch (Exception e) {

        }
        //System.out.println(bussiness);
        for (String str: bussiness.split("#")) {
            bussinessList.add(str);
        }

    }

    /**
     * 解析hive表上下游血缘关系
     */
    public void parseBlood(String path) {
        //getAvaliablePath();

        viewPath(path);

        parseBloodDown();

        parseMap = upMap;
        for(Map.Entry<String, String> entry: downMap.entrySet()) {
            String key = entry.getKey(), value = entry.getValue();
            if (parseMap.containsKey(key)) {
                parseMap.put(key, parseMap.get(key) + "#" + value);
            } else {
                parseMap.put(key, "#" + value);
            }
        }
    }

    /**
     * 更新数据到MySQL：hive表名，上游依赖，下游一级依赖，下游所有依赖，更新时间
     * @param map
     * @param cur_time
     */
    public void scheduleService(Map<String, String> map, String cur_time) {
        Map<String, String> map_all_dep = new HashMap<>();  // hive表下游所有依赖
        for (Map.Entry entry: map.entrySet()) {
            Set<String> set_tmp = new HashSet<>();
            String str_k = entry.getKey().toString().trim();
            String[] str_v = entry.getValue().toString().split("#");

            //set_tmp = get_table_all_dep(map, str_v, "-1");
            //
            //StringBuffer sb = new StringBuffer();
            //for(String table: set_tmp) {
            //    sb.append(",");
            //    sb.append(table.trim());
            //}
            //map_all_dep.put(str_k, sb.toString().replaceFirst(",", ""));
        }
        getPrint(map, map, cur_time);
    }

    /**
     * 方法：获取hive表下游所有依赖
     * @param map
     * @return
     */
    public Set<String> get_table_all_dep(Map<String, String> map, String[] str_v, String originKey) {

        Set<String> set_result = new HashSet<>();
        if(str_v.length > 1) {
            String[] table_downs = str_v[1].split(",");
            for(String table_tmp: table_downs) {

                if (table_tmp.trim().equals(originKey)) continue;
                System.out.println("originKey: " + originKey + " " + table_tmp.trim());
                set_result.add(table_tmp.trim());
                if (map.containsKey(table_tmp.trim())) {
                    System.out.println(map.get(table_tmp.trim()) + "  测试");
                    str_v = map.get(table_tmp.trim()).split("#");
                    set_result.addAll(get_table_all_dep(map, str_v, table_tmp.trim()));
                }
            }
        }
        return set_result;
    }

    public void getPrint(Map<String, String> map, Map<String, String> map_all_dep, String cur_time) {
        for (Map.Entry entry : map.entrySet()) {
            String str_k = entry.getKey().toString().trim();
            String[] str_v = entry.getValue().toString().split("#");
            String down_depend = str_v.length == 2 ? str_v[1].trim() : "";
            String result = "%s %s %s %s %s";
            System.out.println(String.format(result, str_k, str_v[0].trim(), down_depend, map_all_dep.get(str_k), cur_time));
            // 先删除str_k对应一行数据
            //String sql = "delete from table_graph where hive_table='%s'";
            //jdbcTemplate.execute(String.format(sql, str_k));
            //sql = "insert into table_graph values('%s', '%s', '%s', '%s', '%s')";
            //jdbcTemplate.execute(String.format(sql, str_k, str_v[0].trim(), down_depend, map_all_dep.get(str_k), cur_time));
        }
    }

    public static void main(String[] args) {
        String path = "/Users/huangxuanfeng/git/keep-data-warehouse-new/dev";
        //path = "/Users/huangxuanfeng/Documents/warehouse_data/lineage/2.sql";
        ReadShSqlScript read = new ReadShSqlScript();
        read.parseBlood(path);
        for(Map.Entry entry: read.getParseMap().entrySet()) {
            System.out.println("目标表：" + entry.getKey()
                    + "源表：" + entry.getValue());
        }

        read.scheduleService(read.getParseMap(), dateFormat.format(new Date()));

    }
}

