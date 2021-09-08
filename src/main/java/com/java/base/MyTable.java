package com.java.base;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.java.base.dto.City;
import com.java.base.dto.Table;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.joda.time.format.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Create by huangxuanfeng on 2021/5/7 下午2:06
 *
 * @author huangxuanfeng
 */
public class MyTable {

    public static void main(String[] args) throws ParseException {
        Table table = new Table();
        System.out.println(table.getName());
        System.out.println(table.getCnt());
        System.out.println(table.getCnt2());

        Map<String, Table> map = new HashMap<>();
        table.setName("keep_ods");
        map.put("123", table);
        for (Map.Entry<String, Table> entry: map.entrySet()) {
            entry.getValue().setCnt(123);
            entry.getValue().setCnt2(12313);
            System.out.println(ReflectionToStringBuilder.toString(entry.getValue()));
        }
        System.out.println(map);

        Gson gson = new Gson();
        City city = new City();
        System.out.println(gson.toJson(city));
        System.out.println("gson: " + gson.toJson(city).toString());

        String ab = "1,2,3,4";
        System.out.println(Lists.newArrayList(ab).size());
        System.out.println(Lists.newArrayList(ab.split(",")).size());
        System.out.println(Lists.newArrayList("".split(",")));
        System.out.println(Lists.newArrayList(ab.split(",")).contains("2"));
        System.out.println(Lists.newArrayList(ab.split(",")).contains("4"));
        System.out.println(Lists.newArrayList(ab.split(",")).contains("5"));

        System.out.println(gson.toJson(map));

        List<Table> tableList = new ArrayList<>();
        Table table1 = new Table();
        table1.setCnt(123);
        tableList.add(table1);

        //tableList.add(new Table());

        table1 = new Table();
        table1.setCnt(234);
        tableList.add(table1);

        MyTable.getPages(tableList);
        System.out.println(Joiner.on(",").join(tableList.stream().map(Table::getCnt).collect(Collectors.toList())));

        Map<String, List<String>> onlineEventPropertiesMap = new HashMap<>();
        System.out.println(gson.toJson(onlineEventPropertiesMap));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.of(2021, 1, 1);
        System.out.println(localDate.format(dtf));
        System.out.println(localDate.with(WeekFields.of(Locale.US).dayOfWeek(), 1L));


        String startDate = "2021-01-30", endDate = "2021-02-20";
        LocalDate localDate2 = null;
        String index = startDate;
        while (index.compareTo(endDate) <= 0) {
            System.out.println(index);
            localDate = LocalDate.parse(index);
            index = localDate.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.parse(startDate));

        List<String> list2 = new ArrayList<>();
        list2.add("huang"); list2.add("xuan");
        MyTable.getPages(list2);

        String aa = "true";
        String bb = "false";
        System.out.println(aa.getClass().getSimpleName());
        System.out.println(bb.getClass().getSimpleName());
        aa = "123";
        bb = "True";
        System.out.println(aa.getClass().getSimpleName());
        System.out.println(bb.getClass().getSimpleName());

        list2 = new ArrayList<>();
        System.out.println(list2);
        System.out.println(Joiner.on(",").join(list2));

        System.out.println(addDays("2021-03-01", 2));
        System.out.println(addDays("2021-03-01", -2));

    }

    public static String addDays(String curDate, int days) {
        DateTimeFormatter Y_M_D_DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate localDate = LocalDate.parse(curDate, Y_M_D_DTF);
        return localDate.plusDays(days).format(Y_M_D_DTF);
    }

    public static void getPages(List list) {
        System.out.println("size : " + list.size());
    }
}
