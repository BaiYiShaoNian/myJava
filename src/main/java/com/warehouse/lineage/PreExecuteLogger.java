package com.warehouse.lineage;

import org.apache.hadoop.hive.ql.hooks.*;
import org.apache.hadoop.hive.ql.session.SessionState;
import org.apache.hadoop.security.UserGroupInformation;

import java.util.Set;

/**
 * Create by huangxuanfeng on 2020/5/8 下午2:51
 */
public class PreExecuteLogger implements PreExecute {
    @Override
    public void run(SessionState sessionState, Set<ReadEntity> set, Set<WriteEntity> set1, UserGroupInformation userGroupInformation) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("pre 1，" + startTime);
        System.out.println("pre 2，" + sessionState.getCommandType());
        System.out.println("pre 3，" + sessionState.getCmd());
        System.out.println("pre 4，" + sessionState.getQueryId());
    }
}
