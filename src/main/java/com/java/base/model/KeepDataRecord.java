package com.java.base.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * Create by huangxuanfeng on 2021/4/24 下午9:06
 *
 * @author huangxuanfeng
 */
@Data
public class KeepDataRecord implements Serializable {

    private static final long serialVersionUID = 1555912638370961617L;

    private String operation;

    private String timestamp;

    private String checkpoint;

    private Map<String, Object> value;

}
