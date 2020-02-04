package com.keep.me;

import lombok.Data;

/**
 * Create by huangxuanfeng on 2020/1/17 下午12:59
 */
@Data
public class ActionEvent {
    private Integer actionId;

    private String eventName;

    private String task;

    private String moduleName;

    private String description;

    private String propertyId;

    private String propertyMessage;

    private Boolean valid = true;
}

