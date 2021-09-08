package com.java.base;

import com.java.base.dto.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Create by huangxuanfeng on 2020/5/19 下午7:18
 */
public class MyLog {
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println("hello2");

        List<User> list = new ArrayList<>();
        User user = new User.Builder()
                .city("重庆")
                .age(23)
                .username("sef")
                .build();
        list.add(user);
        System.out.println(list);

        List<User> userList = new ArrayList<>();
        User user1 = new User.Builder()
                .city("北京")
                .age(30)
                .username("upqer")
                .build();
        userList.add(user1);
        System.out.println(userList);
        list = userList;
        System.out.println(list);
        //System.out.println(list.subList(0, 100));

        String a = "2021-05-17 12:11:20", b = "2021-05-17 12:11:02";
        System.out.println(a.compareTo(b));
        a = "2021-05-17 12:11:20"; b = "2021-05-17 12:12:02";
        System.out.println(a.compareTo(b));
        a = "2021-05-17 12:11:20"; b = "2021-05-17 12:11:20";
        System.out.println(a.compareTo(b));

        Date today = null;
        System.out.println(today == null);
        today = new Date();
        System.out.println(today);
        System.out.println(today.toString());

        Random random = ThreadLocalRandom.current();
        System.out.println(random.nextInt(1000 * 3600 * 24));
        System.out.println(random.nextInt(1000 * 3600 * 24));
    }
}
