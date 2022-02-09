package com.keep.me;

import com.keep.me.tools.Abc;
import com.keep.me.tools.SportsInfo;
import com.keep.me.tools.User;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import sun.jvm.hotspot.debugger.RandomAccessFileDataSource;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hello {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("huang"); list.add("xuan"); list.add("feng");
        System.out.println(list);
        int flag = -1;
        list.forEach(x -> {
            if (x.equals("huang")) {
                //flag = 1;
            }
        });

        Abc abc = new Abc();
        abc.setName("huang");

        String applyUser = "huangxuanfeng|";
        String content = "#### 埋点系统权限申请" +
                "\n**<font color=\"warning\">「{0} 申请埋点系统权限」</font>**";
        content = MessageFormat.format(content, applyUser);
        System.out.println(content);

        List<String> list1 = new ArrayList<>();
        list1.add("huang");
        list1.add("xuan");
        list1.add("feng");
        //list1.forEach(x -> {
        //    x = "\"" + x + "\"";
        //});

        System.out.println(list1);
        System.out.println(StringUtils.join(list1, ","));

        StringBuilder sb = new StringBuilder();

        list1.forEach(x -> {
            sb.append("'" + x + "'");
        });
        System.out.println(sb.toString());

        System.out.println(RandomStringUtils.randomAlphabetic(10));

        List<String> list2 = collectLocalDates("2019-02-25", "2019-03-02");
        list2.forEach(x -> System.out.println(x));

        List<Map<String, Object>> columnList = new ArrayList<>(), dataList = new ArrayList<>();

        collectLocalDates("2019-02-25", "2019-03-02").forEach(x -> {
            Map<String, Object> map = new HashMap<>();
            map.put("p_date", x);
            dataList.add(map);
        });
        dataList.forEach(x -> System.out.println(x));
        dataList.forEach(x -> {
            x.put("paobu", 123);
        });
        dataList.forEach(x -> System.out.println(x));

        Map<String, Object> map = new HashMap<>();
        map.put("keepvalue", 123);
        map.put("keepValue", 123123);
        map.put("abc", "huas");
        System.out.println("比较一下");
        System.out.println(map);
        map.remove("keepValue");
        System.out.println(map);

        System.out.println(RandomUtils.nextLong(1000, 2000));
        System.out.println(RandomStringUtils.randomNumeric(5));

        StringBuilder sb2 = new StringBuilder();
        sb2.append("huang"); sb2.append(",");
        sb2.append("xuan"); sb2.append(",");
        int start = sb2.length(), end = 0;
        sb2.append("feng"); sb2.append(","); end = sb2.length();
        System.out.println("now: " + sb2);
        System.out.println(start + " " + end);
        sb2.delete(start, end); start = sb2.length();
        sb2.append("hahah"); sb2.append(","); end = sb2.length();
        System.out.println("now2: " + sb2);
        System.out.println(start + " " + end);
        sb2.deleteCharAt(end-1);
        System.out.println(sb2);

        System.out.println(map);
        System.out.println(map.get("ab"));

        String tmp = "huang[xuan]feng";
        System.out.println(tmp);
        System.out.println(tmp.replaceAll("[\\[\\]]", "-"));

        User user = new User();
        System.out.println(user);
        System.out.println(user.getName());
        System.out.println(user.getStatus());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(1598345167L * 1000);
        System.out.println(sdf.format(date));

        SportsInfo sportsInfo = new SportsInfo();
        System.out.println("start....");
        System.out.println(sportsInfo.getCyclingData().getCalorie() + " " + sportsInfo.getCyclingData().getDuration());
        System.out.println(sportsInfo.getHikingData().getCalorie() + " " + sportsInfo.getHikingData().getDuration());

        String num = "234.90";
        System.out.println(Double.valueOf(num).longValue());
        System.out.println();

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
        System.out.println(sdf2.format(new Date()));

        double num2 = 1233.0;
        double num3 = num2/7;
        System.out.println(num3);

        List<String> event = Arrays.asList("huang", "xuan");
        System.out.println(event);

        List<String> tmp2 = new ArrayList<>();
        tmp2.add("shef");

//        event = tmp2;
//        event = tmp2.stream().collect(Collectors.toList());
        event = new ArrayList<>(tmp2);
        System.out.println(tmp2);
        System.out.println(event);
        tmp2.add("se2e2e");
        System.out.println(tmp2);
        System.out.println(event);

        String table = "10";
        System.out.println("1: " + table);
        Hello hello = new Hello();
        hello.test(table);
        System.out.println("4: " + table);

        String calc = "2 * index_3 - index_4 * index_10";
        Pattern pattern = Pattern.compile("index_([0-9]+)");
        Matcher matcher = pattern.matcher(calc);
        while (matcher.find()) {
            System.out.println("h: " + matcher.group(1));
        }

        date = new Date(0, 1, 0);
        System.out.println(date);
        org.apache.commons.lang.RandomStringUtils.randomNumeric(5);

        Set<Integer> set = new HashSet<>();
        Integer a = null;
        set.add(a);
        a = 123;
        set.add(a);
        System.out.println("a: " + a);

        List<Abc> list3 = new ArrayList<>();
        System.out.println(CollectionUtils.isNotEmpty(list3));
    }

    private void test(String table) {
        System.out.println("2: " + table);
        table = "200";
        System.out.println("3: " + table);
    }

    public static List<String> collectLocalDates(String timeStart, String timeEnd){
        return collectLocalDates(LocalDate.parse(timeStart), LocalDate.parse(timeEnd));
    }

    /**
     * 收集起始时间到结束时间之间所有的时间并以字符串集合方式返回
     * @param start
     * @param end
     * @return
     */
    public static List<String> collectLocalDates(LocalDate start, LocalDate end) {
        // 用起始时间作为流的源头，按照每次加一天的方式创建一个无限流
        return Stream.iterate(start, localDate -> localDate.plusDays(1))
                // 截断无限流，长度为起始时间和结束时间的差+1个
                .limit(ChronoUnit.DAYS.between(start, end) + 1)
                // 由于最后要的是字符串，所以map转换一下
                .map(LocalDate::toString)
                // 把流收集为List
                .collect(Collectors.toList());
    }
}
