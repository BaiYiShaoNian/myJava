package com.keep.me.collection;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;

import java.util.List;

/**
 * Create by huangxuanfeng on 2022/2/8 5:23 PM
 *
 * @author huangxuanfeng
 */
public class HelloInts {

    public static void main(String[] args) {
        List<Integer> list = Ints.asList(3, 4, 5, 10);
        System.out.println(list);

        list = Lists.newArrayList(1, 2, 3, 10, 100);
        System.out.println(list);
        list.add(23);
        System.out.println(list);
    }
}
