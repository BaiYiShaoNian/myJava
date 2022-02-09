package com.keep.me.tools;

import lombok.Data;

/**
 * Create by huangxuanfeng on 2020/8/31 下午4:22
 */
@Data
public class SportsBaseData {

    private long duration;

    private long calorie;

    public SportsBaseData() {
        this.duration = 0;
        this.calorie = 0;
    }
}
