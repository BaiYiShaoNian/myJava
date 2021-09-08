package com.java.base.dto;

import lombok.Data;

/**
 * Create by huangxuanfeng on 2021/4/1 下午8:42
 *
 * @author huangxuanfeng
 */
@Data
public class City {
    private String country;

    private String province;

    private String city;

    private String district;

    public City() {
        country = "中国";
        province = "四川省";
        city = "成都市";
        district = "天府新区";
    }
}
