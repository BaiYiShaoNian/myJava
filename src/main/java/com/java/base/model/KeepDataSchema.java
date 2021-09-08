package com.java.base.model;

import lombok.Data;

/**
 * Create by huangxuanfeng on 2021/4/24 下午9:06
 *
 * @author huangxuanfeng
 */
@Data
public class KeepDataSchema {
    private String namespace;

    private KeepFieldSchema[] schemas;

    private String primaryKey;

    @Data
    public static class KeepFieldSchema {

        private String fieldName;

        private String fieldType;

    }
}
