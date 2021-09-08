package com.keep.me;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.keep.commons.utils.device.DeviceIdUtils;
import com.keep.me.tools.Abc;
import com.keep.me.tools.User2;
import com.keep.spring.boot.mongo.secure.crypt.CryptVault;
import com.keep.user.account.model.User;
import com.keep.user.account.rpc.service.UserRpcService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.tools.ant.taskdefs.Exit;
import org.bson.BasicBSONDecoder;
import org.bson.BasicBSONEncoder;
import org.bson.BasicBSONObject;

import javax.annotation.Resource;
import java.text.MessageFormat;
//import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

public class Hello {

    public static void main(String[] args) {
        List<String> list2 = new ArrayList<>();
        list2.add(null);
        list2.add("123");


        String s2 = "345#-1#567# # ";
        System.out.println(s2.split("#")[0]);
        System.out.println(s2.split("#")[1]);
        System.out.println(s2.split("#")[2]);
        System.out.println(s2.split("#")[3]);
        System.out.println(s2.split("#")[4]);
        System.out.println(Arrays.asList(s2.split("#")));

        Map<String, String> map5 = new HashMap<>();
        String a2 = "huang", b = null, c = "";
        map5.put("xuan", a2 + "#" + b + "#" + c);
        System.out.println("map2: " + map5);
        System.out.println(map5.get("xuan").split("#")[1].equals("null"));

        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(tomorrow.getTimeInMillis());

        System.out.println(Integer.valueOf("-90123".split("\\.")[0]));
        System.out.println(Math.ceil(123.90123));
        System.out.println(Math.ceil(123.10123));
        System.out.println(Math.ceil(-90.0981));

        Integer a0 = 128221231, b0 = 1292222;
        System.out.println(a0 >= b0);

        System.out.println(Integer.valueOf("12813213") > Integer.valueOf("12989090"));

        System.exit(0);

        DateTimeFormatter MINUTES_DTF = DateTimeFormatter.ofPattern("mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        String m = localDateTime.format(MINUTES_DTF);
        System.out.println(m);

        List<String> list = new ArrayList<>();
        list.add("huang"); list.add("xuan"); list.add("feng");
        System.out.println(list);
        int flag = -1;
        //list.forEach(x -> {
        //    if (x.equals("huang")) {
        //        //flag = 1;
        //    }
        //});

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

        //list1.forEach(x -> {
        //    sb.append("'" + x + "'");
        //});
        System.out.println(sb.toString());

        System.out.println(RandomStringUtils.randomAlphabetic(10));

        //List<String> list2 = collectLocalDates("2019-02-25", "2019-03-02");
        //list2.forEach(x -> System.out.println(x));
        //
        //List<Map<String, Object>> columnList = new ArrayList<>(), dataList = new ArrayList<>();
        //
        //collectLocalDates("2019-02-25", "2019-03-02").forEach(x -> {
        //    Map<String, Object> map = new HashMap<>();
        //    map.put("p_date", x);
        //    dataList.add(map);
        //});
        //dataList.forEach(x -> System.out.println(x));
        //dataList.forEach(x -> {
        //    x.put("paobu", 123);
        //});
        //dataList.forEach(x -> System.out.println(x));

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

        User2 user2 = new User2();
        System.out.println(user2);
        System.out.println(user2.getName());
        System.out.println(user2.getStatus());

        System.out.println("test 哈哈哈");

        boolean a = true;
        System.out.println("a: " + a);
        System.out.println(String.valueOf(a).equals("true"));

        String aa = "huang(xuan)feng(1,2,3)";
        System.out.println(aa.replaceAll("[()]", ""));

        Integer ah = 10;
        Long bh = 10L;
        String ch = "hun";
        Double dh = 10d;
        Boolean eh = true;
        System.out.println("类型类名");
        System.out.println("int: " + ah.getClass().getSimpleName());
        System.out.println("long: " + bh.getClass().getSimpleName());
        System.out.println("string: " + ch.getClass().getSimpleName());
        System.out.println("double: " + dh.getClass().getSimpleName());
        System.out.println("boolean: " + eh.getClass().getSimpleName());

        String ss = "[courseOfficial_true; courseDifficulty_4]";
        List<String> ssList = Lists.newArrayList(ss
                .replaceAll("[\\[\\]]", "")
                .split("[;；,]"));
        System.out.println(ssList);
        for (String line: ssList) {
            System.out.println(line.trim());
        }

        ss = "123";
        System.out.println(NumberUtils.isCreatable(ss));
        ss = "huang23";
        System.out.println(NumberUtils.isCreatable(ss));

        ss = "";
        List<String> list3 = Lists.newArrayList(ss.split(","));
        System.out.println(list3 + "#" + list3.size() + "#" + list3.get(0));
        list3.add("h");
        System.out.println(list3 + "#" + list3.size() + "#" + list3.get(0));

        ss = "";
        list3 = Lists.newArrayList();
        System.out.println(list3 + "#" + list3.size());

        ss = "属性(isTrue)未在marmot中登记<br/>属性(number)未在marmot中登记<br/>属性(appPlatform)未在marmot中登记<br/>属性(ip)未在marmot中登记<br/>属性(number3)未在marmot中登记<br/>属性(sessionId)未在marmot中登记<br/>属性(idList)未在marmot中登记<br/>属性(number2)未在marmot中登记<br/>属性(isTrue)值为false,不在marmot登记枚举值true中<br/>属性(number)值为5,不在marmot登记区间(1,5)内<br/>属性(number3)值为xuan,存在marmot登记排除值xuan中<br/>属性(sessionId)值为1596701859,不在marmot登记枚举值123中<br/>属性(idList)值为[huang; xuan; feng],不在marmot登记枚举值huang,feng中<br/>属性(number2)值为0,存在marmot登记排除值0中";
        List<String> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        for (String line: ss.split("<br/>")) {
            if (line.contains("未在marmot中登记")) {
                l1.add(line);
            }
            if (line.contains("登记区间") || line.contains("登记枚举") || line.contains("登记排除")) {
                l2.add(line);
            }
        }
        l1 = new ArrayList<>(); l2 = new ArrayList<>();
        System.out.println(Joiner.on("<br/>").join(l1));
        System.out.println(Joiner.on("<br/>").join(l2));

        String s = "kpbcbqzfwouxcimbwpcjckbzsjvtgwyjf06d1f7b";
        //System.out.println("解密： " + DeviceIdUtils.unwrap(s));
        s = "c702966b6da76e80111111111111111145bb15be";
        //System.out.println("解密： " + DeviceIdUtils.unwrap(s));
        s = "kpblbdaefkmcxjlbfmckpzvggkwnadund06c596a";
        //System.out.println("解密： " + DeviceIdUtils.unwrap(s));
        //s = "";
        //System.out.println("解密： " + DeviceIdUtils.unwrap(s));
        //s = null;
        //System.out.println("解密： " + DeviceIdUtils.unwrap(s));
        //s = "c702966b6da76e80111111111111111145bb15be";
        //System.out.println("解密： " + DeviceIdUtils.unwrap(s));
        //ss = DeviceIdUtils.unwrap(s);
        //s = "kpggslxyrglowhqgnobgnewwseyywqfvfd9efda1";
        //try {
        //    ss = DeviceIdUtils.unwrap(s);
        //} catch (Exception e) {
        //    System.out.println(s + " 解密失败");
        //}
        //System.out.println("解密： " + ss);
        //System.out.println(DeviceIdUtils.unwrap("00000000000000000000000000000000eeeeeeb1"));

        //User user = new User();
        //user.setId("124213");
        //boolean isMember = user.getMemberStatus() == 1 && user.getGmtExpire().after(new Date());

        User2 user21 = new User2();
        Map<String, User2> map2 = new HashMap<>();
        user21.setName("huang"); user21.setStatus(1);
        map2.put("1", user21);
        user21 = new User2(); user21.setName("xuan"); user21.setStatus(2);
        map2.put("2", user21);
        user21 = new User2(); user21.setName("feng"); user21.setStatus(3);
        map2.put("3", user21);
        System.out.println(map2.values());
        System.out.println(new ArrayList<User2>(map2.values()));

        Integer aaa = 100, bbb = 100;
        System.out.println(aaa == bbb);
        aaa = 1000; bbb = 1000;
        System.out.println(aaa == bbb);
        System.out.println(aaa.equals(bbb));
        System.out.println(aaa.equals(1000));

        int size = 1000000;

        //BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size);
        //bloomFilter.put(100);
        //bloomFilter.put(80123);
        //bloomFilter.put(891);
        //System.out.println(bloomFilter.mightContain(891));
        //System.out.println(bloomFilter.mightContain(892));

        s2 = null;
        System.out.println("null".equalsIgnoreCase(s2));


        // tEoivl6O/APh4BBT1ttThOTnwpRIV77eF8eUMm8r3Yw=
        String mobile = "180.2";
        // 加密 mobile 字段
        String code = "tEoivl6O/APh4BBT1ttThOTnwpRIV77eF8eUMm8r3Yw=";

        CryptVault cryptVault = new CryptVault();
        cryptVault.with256BitAesCbcPkcs5PaddingAnd128BitSaltKey(1, Base64.getDecoder().decode(code));
        byte[] serializedMobile = new BasicBSONEncoder().encode(new BasicBSONObject("", mobile));
        byte[] result = cryptVault.encrypt(1, serializedMobile);

        System.out.println("start0 " + new String(serializedMobile));
        try {
            System.out.println("start1 " + result);
            s = new String(Base64.getEncoder().encode(result));
            System.out.println("start2 " + s);
            result = Base64.getDecoder().decode(s.getBytes());
        } catch (Exception e) {}
        byte[] decoded = cryptVault.decrypt(result);
        System.out.println(new BasicBSONDecoder().readObject(decoded).get(""));

        decoded = cryptVault.decrypt(result);
        System.out.println(new BasicBSONDecoder().readObject(decoded));

        mobile = "gTzYOAG6mGArQ8lLmMN4bTCAtXs96veVG17ZrQ1vGjkIEhKqp2aC9XPEXl4cBQofqg==";
        byte[] byteMobile = Base64.getDecoder().decode(mobile.getBytes());
        decoded = cryptVault.decrypt(byteMobile);
        System.out.println("hh " + new BasicBSONDecoder().readObject(decoded));

        String regex = "(.*?)binary\" : \"(.*?)\",(.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("{ \"$binary\" : \"gaA4MorwwYmho7S5O7L8fykevRV1h3tnoyXwU0Ne/RxHXfZ3VbwhzS1gqTWoAevDqw==\", \"$type\" : \"00\" }");
        if (matcher.find()) {
            System.out.println(matcher.group(2));
            System.out.println(matcher.start() + " " + matcher.end());
        }
        matcher = pattern.matcher("binary\" : \",hun ");
        System.out.println(matcher.find());

        String date = "20200921";
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")).equals(date));
    }

    //public static List<String> collectLocalDates(String timeStart, String timeEnd){
    //    return collectLocalDates(LocalDate.parse(timeStart), LocalDate.parse(timeEnd));
    //}

    /**
     * 收集起始时间到结束时间之间所有的时间并以字符串集合方式返回
     * @param start
     * @param end
     * @return
     */
    //public static List<String> collectLocalDates(LocalDate start, LocalDate end) {
    //    // 用起始时间作为流的源头，按照每次加一天的方式创建一个无限流
    //    return Stream.iterate(start, localDate -> localDate.plusDays(1))
    //            // 截断无限流，长度为起始时间和结束时间的差+1个
    //            .limit(ChronoUnit.DAYS.between(start, end) + 1)
    //            // 由于最后要的是字符串，所以map转换一下
    //            .map(LocalDate::toString)
    //            // 把流收集为List
    //            .collect(Collectors.toList());
    //}
}
