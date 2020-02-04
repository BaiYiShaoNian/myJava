package com.keep.me.tools;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * Create by huangxuanfeng on 2019/11/11 下午2:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class OtherUser extends User {
    private String address;
}
