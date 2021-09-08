package com.java.base.head.first;

import com.java.base.model.User;

/**
 * Create by huangxuanfeng on 2021/7/12 下午2:36
 *
 * @author huangxuanfeng
 */
public class singleton {

    public static void main(String[] args) {
        User user = User.getInstance();
        User user1 = User.getInstance();
        System.out.println(user == user1);
    }
}
