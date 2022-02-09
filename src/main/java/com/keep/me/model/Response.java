package com.keep.me.model;

import lombok.Data;

/**
 * Create by huangxuanfeng on 2022/1/27 6:36 PM
 *
 * @author huangxuanfeng
 */
@Data
public class Response<T> {

    private Integer status;

    private String message;

    private T data;
}
