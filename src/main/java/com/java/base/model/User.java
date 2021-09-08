package com.java.base.model;

/**
 * Create by huangxuanfeng on 2021/7/12 下午2:38
 *
 * @author huangxuanfeng
 */
public class User {
    /**
     * 单例模式
     */
    private String username;

    private int age;

    private User() {

    }

    private volatile static User user = null;

    public static User getInstance() {
        if (user == null) {
            synchronized (User.class) {
                if (user == null) {
                    user = new User();
                }
            }
        }
        return user;
    }
}
