package com.java.base.constant;

import lombok.Data;

/**
 * Create by huangxuanfeng on 2020/8/21 下午12:09
 */
public class NameAgeConstants {

    public static class Name {
        public static enum name {
            HU("huang", "xuanfeng"),
            ZH("huang", "fengxuan");

            private String key;
            private String value;
            name(String key, String value) {
                this.key = key;
                this.value = value;
            }
            public String getKey() {
                return this.key;
            }
            public String getValue() {
                return this.value;
            }
        }
    }
}
