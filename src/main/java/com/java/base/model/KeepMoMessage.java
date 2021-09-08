package com.java.base.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Create by huangxuanfeng on 2021/4/24 下午9:06
 *
 * @author huangxuanfeng
 */
@Data
public class KeepMoMessage {
    private String source;

    private String database;

    private String table;

    private String type;

    private KeepDataSchema schema;

    private KeepDataRecord record;
}
