package com.java.base;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Create by huangxuanfeng on 2020/4/25 下午10:53
 */
public class HelloWorld {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
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
    }
}
