package com.keep.me.model;

import lombok.Data;

import java.util.List;

/**
 * Create by huangxuanfeng on 2022/1/27 5:23 PM
 *
 * @author huangxuanfeng
 */
@Data
public class Book {

    private Integer id;

    private String name;

    private List<User> userList;

    private Shop shop;
}
