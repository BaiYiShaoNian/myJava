package com.keep.me.commons;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by huangxuanfeng on 2022/1/27 4:25 PM
 *
 * @author huangxuanfeng
 */
public class HelloCollection {

    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        System.out.println(CollectionUtils.isEqualCollection(aList, bList));
        aList.add(123);
        System.out.println(CollectionUtils.isEqualCollection(aList, bList));
        bList.add(123);
        System.out.println(CollectionUtils.isEqualCollection(aList, bList));

        List<String> asList = new ArrayList<>();
        List<String> bsList = new ArrayList<>();
        System.out.println(CollectionUtils.isEqualCollection(asList, bsList));
        asList.add("huang");
        System.out.println(CollectionUtils.isEqualCollection(asList, bsList));
        bsList.add("huang");
        System.out.println(CollectionUtils.isEqualCollection(asList, bsList));

        List<String> list = new ArrayList<>();
        asList.add("xuan");
        list = new ArrayList<>(CollectionUtils.union(asList, bsList));
        System.out.println(CollectionUtils.union(asList, bsList));
        System.out.println(list);
        System.out.println(CollectionUtils.intersection(asList, bsList));

        asList.add("huang");
        System.out.println(CollectionUtils.union(asList, bsList));
    }
}
