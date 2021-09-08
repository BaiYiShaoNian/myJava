package com.java.base;

import com.alibaba.fastjson.JSONObject;
import com.java.base.model.KeepMoMessage;

/**
 * Create by huangxuanfeng on 2021/4/24 下午9:04
 *
 * @author huangxuanfeng
 */
public class MyJson {

    public static void main(String[] args) {
        String s = "{\n" +
                "\"source\": \"\",\n" +
                "\"database\": \"db_trade\",\n" +
                "\"table\": \"order_item\",\n" +
                "\"type\": \"record\",\n" +
                "\"schema\": {\n" +
                "\"namespace\": \"\",\n" +
                "\"schemas\": [{\n" +
                "\"fieldName\": \"\",\n" +
                "\"fieldType\": \"\"\n" +
                "}],\n" +
                "\"primaryKey\": \"\"\n" +
                "},\n" +
                "\"record\": {\"checkpoint\":\"123847@3561@160184346@233675574\",\"operation\":\"insert\",\"timestamp\":\"1619267654\",\"value\":{\"product_id\":\"123\",\"product_name\":\"哈哈哈1省份\", \"consign_time\":\"\",\"district\":\"东城区\"}}\n" +
                "}";
        KeepMoMessage keepMoMessage = JSONObject.parseObject(s, KeepMoMessage.class);
        System.out.println(keepMoMessage.getDatabase());

    }
}
