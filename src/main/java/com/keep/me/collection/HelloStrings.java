package com.keep.me.collection;

import com.google.common.base.Strings;

/**
 * Create by huangxuanfeng on 2022/2/8 7:22 PM
 *
 * @author huangxuanfeng
 */
public class HelloStrings {

    public static void main(String[] args) {
        String input = "";
        System.out.println("1: " + Strings.isNullOrEmpty(input) + " 1");
        input = null;
        System.out.println("2: " + Strings.isNullOrEmpty(input) + " 2");
        System.out.println("3: " + Strings.nullToEmpty(input) + " 3");
        input = "";
        System.out.println("4: " + Strings.emptyToNull(input) + " 4");

        System.out.println(Strings.commonPrefix("aaac", "fe"));
    }
}
