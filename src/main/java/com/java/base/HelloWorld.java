package com.java.base;

import com.java.base.dto.User;
import com.keep.ads.commons.utils.IPZone;
import com.keep.ads.commons.utils.QQWry;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Create by huangxuanfeng on 2020/4/25 下午10:53
 */
public class HelloWorld {

    /**
     * @see com.tools.LogTools
     * @see MyEnum
     * {@link MyEnum}
     * {@link com.tools.FileTools}
     * @param args
     */
    public static void main(String[] args) {
        // abc_def, abc_def_gh, abc_def_gh_ijk
        //final String REGEX_EVENT_NAME_STR = "(?=[a-z]+\\_)[a-z\\_]+[a-z]+";
        final String REGEX_EVENT_NAME_STR = "([a-z]+\\_)+[a-z]+";
        String name = "app_lanuch";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));
        name = "abc_def_gh";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));
        name = "abc_def_gh_ijk";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));
        name = "abc_def_gh_$jk";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));
        name = "abc_$def_gh_ijk";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));
        name = "abc__def_gh_ijk";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));
        name = "a_k";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));
        name = "_applanuch";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));
        name = "app_";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));
        name = "App_Lnacu";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));
        name = "app$fsef_f";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));
        name = "seffe";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));
        name = "seffe_ad_";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));
        name = "_sfe_sfe_se";
        System.out.println(name + " " + name.matches(REGEX_EVENT_NAME_STR));

        name = "轩黄峰";
        System.out.println(name + " " + name.matches("(?=[黄]+[轩]+).+"));
        name = "黄轩黄轩峰";
        System.out.println(name + " " + name.matches("(?=[黄轩]+).+"));
        name = "黄轩峰";
        System.out.println(name + " " + name.matches("(?=[黄轩]+).+"));

        Pattern ptn = Pattern.compile(
                "(?<=[\u4e00-\u9fa5])(?=[A-Za-z])|(?<=[A-Za-z])(?=[\u4e00-\u9fa5])",
                Pattern.UNICODE_CASE);
        String[] words = ptn.split("McCulloch与Pitts将神经系统");
        for(String word: words) {
            System.out.print(word + "\t");
        }
        System.out.println();

        boolean ab = false;
        System.out.println(ab ? 1 : 0);

        List<User> userList = new ArrayList<>(), userList1 = new ArrayList<>();
        User user2 = new User.Builder()
                .age(10)
                .username("huang")
                .build();
        userList.add(user2);
        user2 = new User.Builder()
                .age(30)
                .username("huang")
                .build();
        userList.add(user2);
        user2 = new User.Builder()
                .age(-90)
                .username("huang")
                .build();
        userList.add(user2);

        System.out.println(userList);

        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o2.getAge(), o1.getAge());
            }
        });
        System.out.println(userList);


        String hiveSqlDemo = "select end_time,geopoints from keep_dw.dwd_rt_run_geopoints " +
                "where (p_date='{0}' and hour = '{1}') or (p_date='{2}' and hour = '{3}')";

        String num = "2.3";
        System.out.println(NumberUtils.isCreatable(num));
        System.out.println(NumberUtils.isCreatable("123"));
        System.out.println(NumberUtils.isCreatable("-890123"));
        System.out.println(NumberUtils.isCreatable("-90123.10231"));

        List<Integer> list = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(list));
        list.add(5);
        System.out.println(list);
        System.out.println(list.getClass().getSimpleName());
        System.out.println(list instanceof List);
        System.out.println(list instanceof ArrayList);

        String val = "string";
        int flag = 0;
        switch (val.getClass().getSimpleName()) {
            case "int":
                flag = 1;
                break;
        }
        System.out.println("flag : " + flag);

        String val2 = "123";
        System.out.println(val2.getClass().getSimpleName());
        System.out.println(NumberUtils.isCreatable(val2));

        Set<String> roles = new HashSet<>();
        List<String> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        l1.add("huang"); l1.add("xuan");
        l2.add("feng");
        roles.addAll(l1);
        roles.addAll(l2);
        System.out.println(roles);

        System.out.println("test2....");

        User user = new User.Builder()
                .username("huang")
                .age(20)
                .city("北京")
                .build();
        System.out.println("build: " + user.toString());

        val = "[huang; xuan;feng]";
        List<String> pValueList = new ArrayList<>();
        if (val.startsWith("[") && val.endsWith("]")
                && val.contains("; ")) {
            pValueList = Arrays.asList(val
                    .substring(1, val.length() - 1)
                    .split("; "));
        }
        System.out.println(pValueList);

        IPZone ipZone = QQWry.findIP("1.189.7.208");
        System.out.println("success");
        System.out.println(ipZone.getMainInfo());
        System.out.println(ipZone.getSubInfo());
        System.out.println(ipZone.toString());

    }
}
