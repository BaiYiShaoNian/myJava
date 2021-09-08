package com.tools;

import com.java.base.constant.NameAgeConstants;
import jodd.io.findfile.FindFile;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Create by huangxuanfeng on 2020/6/2 下午5:21
 * 日期和时间相关操作
 */
public class DateAndTimeTools {

    private static String getCurrentDay(String format) {
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern(format)));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        System.out.println(sdf.format(new Date(1597732669525L)));
        String s = "2020-08-18 14:22:19.778";
        System.out.println(s.substring(0, 10).replaceAll("-", ""));
        System.out.println(new Date());

        System.out.println(LocalDate.now());
        LocalDate startDate =
                LocalDate.parse("2019-12-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(startDate.plusDays(1));
        startDate =
                LocalDate.parse("20191201", DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(startDate.plusDays(-3).format(DateTimeFormatter.ofPattern("yyyyMMdd")));

        return null;
    }

    private static void getSortMap() {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);
        System.out.println(unsortMap);

        List<String> list = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(list);
        if (list.size() > 5) {
            list.subList(0, 5);
        }
        System.out.println(list.subList(0, 5));

        Map<String, Integer> result1 = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        System.out.println(result1);

        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
        System.out.println(result2);
    }

    public static void getCopy() {
        List<String> list = Arrays.asList("huang", "x");
        List<String> list1 = new ArrayList<>(3);
        //BeanUtils.copyProperties(list, list1);
        System.out.println(list1);
        //Collections.copy(list1, list);
        System.out.println(list1);
    }

    public static void getReString() {
        String regexp = "/(\\S[^/]*)=(\\S[^/]*)";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher("/user/p_type=user/p_d=device");
        String hivePartition = "";
        int flag = 0;
        while (matcher.find()) {
            if (flag == 1) {
                hivePartition += ",";
            }
            System.out.println(matcher.group() + " " + matcher.group(0));
            System.out.println(matcher.group(1) + " " + matcher.group(2));
            hivePartition += MessageFormat.format(" {0}=''{1}''",matcher.group(1), matcher.group(2));
            flag = 1;
        }
        System.out.println(hivePartition);
        //String val = "p_date=2019-08-01/p_date_type=month";
        //val = "p_type=user/p_date=2020-03-23";
        //Pattern pattern = Pattern.compile(".*?p_date=([0-9-]+).*");
        //Matcher matcher = pattern.matcher(val);
        //while (matcher.find()) {
        //    System.out.println(matcher.group(1));
        //}
        //val = "p_type=user/p_date=20200323";
        //pattern = Pattern.compile(".*?p_date=([0-9-]+).*");
        //matcher = pattern.matcher(val);
        //while (matcher.find()) {
        //    System.out.println(matcher.group(1));
        //}
        //val = "p_date=2019-08-01/p_date_type=month";
        //pattern = Pattern.compile(".*?p_date=([0-9-]+).*");
        //matcher = pattern.matcher(val);
        //while (matcher.find()) {
        //    System.out.println(matcher.group(1));
        //}
    }

    public static void getDelMap() {
        Map<String, String> map = new HashMap<>();
        map.put("huang", "123");
        map.put("xuan", "456");
        map.put("feng", "789");
        for (String key: map.keySet()) {
            System.out.println(key + " " + map.get(key));
            map.remove(key);
        }
        map.put("123", "abc");
        System.out.println(map.keySet());
    }

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        //calendar.setTime(date);
        calendar.set(2020, Calendar.MARCH, 1);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        String day = simpleDateFormat.format(calendar.getTime());
        System.out.println(day);

        String groupId = "pre_925";
        String groupIdNofix = groupId.replaceAll("(.*?)_([\\d]+)(.*)", "$2");
        System.out.println(groupIdNofix);
        List<String> list2 = new ArrayList<>();
        list2.add("2");
        System.out.println(CollectionUtils.isNotEmpty(list2));
        list2.clear();
        System.out.println(CollectionUtils.isNotEmpty(list2));
        System.exit(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HH");
        System.out.println(sdf.format(new Date()));
        getReString();
        getDelMap();
        System.exit(0);
        Integer aa = 100000;
        int bb = 100000;
        System.out.println(aa.equals(bb));
        System.out.println(aa == bb);
        boolean a = true;
        System.out.println(a);
        a = a || false;
        System.out.println(a);
        a = false;
        System.out.println(a);
        a |= false;
        System.out.println(a);
        a |= true;
        System.out.println(a);
        getCopy();
        String s = null;
        System.out.println("".equals(s));
        s = "";
        System.out.println("".equals(s));

        getSortMap();
        getCurrentDay("yyyyMMdd");
        System.exit(0);
        if (NameAgeConstants.Name.name.values()[0].getKey().equals("huang")) {
            System.out.println(NameAgeConstants.Name.name.values()[0].getValue());
        }
        System.out.println(NameAgeConstants.Name.name.valueOf("HU"));
        //NameAgeConstants.Name.name.values().
        s = "3.4";
        System.out.println(NumberUtils.isCreatable(s));

        Map<String, Integer> map = new HashMap<>();
        map.put("huang", 123);
        map.put("xuan", 90);
        map.put("feng", 234);
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        System.out.println(list);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println(list);
        System.out.println(list.subList(0, 2));

        Map<String, Object> map1 = new HashMap<>();
        map1.put("huang", 1234);
        map1.put("huhang", "xuanfeng");
        System.out.println(map1);

        String ip = "123.31.31.90";
        String ip2 = ip.replaceAll("\\.", "_");
        System.out.println(ip2);

        System.out.println(getCodisExpireTimeInDays(7));

        list2 = new ArrayList<>();
        System.out.println(list2 instanceof List);
        System.out.println(list2.getClass().getSimpleName());
        System.out.println(list2 instanceof ArrayList);


    }

    public static Long getCodisExpireTimeInDays(int days) {
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_YEAR, days);
        return tomorrow.getTimeInMillis();
    }
}
