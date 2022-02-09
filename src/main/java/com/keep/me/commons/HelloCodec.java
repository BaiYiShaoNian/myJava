package com.keep.me.commons;

import org.apache.commons.codec.binary.Base64;

/**
 * Create by huangxuanfeng on 2022/1/27 4:46 PM
 *
 * @author huangxuanfeng
 */
public class HelloCodec {

    public static void main(String[] args) {
        Base64 base64 = new Base64();

        String data = "this is origin data";
        byte[] bytes = data.getBytes();

        System.out.println(base64.encodeToString(bytes));
        System.out.println(new String(base64.decode(base64.encode(bytes))));
    }
}
