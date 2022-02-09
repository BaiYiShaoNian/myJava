package com.keep.me.tools;

import lombok.Data;

/**
 * Create by huangxuanfeng on 2020/8/31 下午4:23
 */
@Data
public class SportsInfo {

    // 训练
    SportsBaseData trainingData;

    // 跑步
    SportsBaseData runningData;

    // 骑行
    SportsBaseData cyclingData;

    // 行走
    SportsBaseData hikingData;

    public SportsInfo() {
        this.cyclingData = new SportsBaseData();
        this.trainingData = new SportsBaseData();
        this.hikingData = new SportsBaseData();
        this.runningData = new SportsBaseData();
    }
}
