package com.keep.me.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create by huangxuanfeng on 2022/1/27 2:15 PM
 *
 * @author huangxuanfeng
 */
public class HelloIO {

    public static void main(String[] args) {
        File file = new File("/Users/huangxuanfeng/Documents/my_warehouse/data/comment.txt");
        try {
            List<String> list = FileUtils.readLines(file, "UTF-8");
            List<String> l = new ArrayList<>();
            for (String tmp: list) {
                l = Arrays.asList(tmp.split("\t"));
                System.out.println("length: " + l.size() + " " + (l.size()>2?l.get(1):" "));
            }
            list = new ArrayList<>();
            list.add("huang");
            list.add("黄");
            FileUtils.writeLines(file, list, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
