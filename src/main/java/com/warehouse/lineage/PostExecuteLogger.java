package com.warehouse.lineage;

import org.apache.hadoop.hive.ql.hooks.LineageInfo;
import org.apache.hadoop.hive.ql.hooks.PostExecute;
import org.apache.hadoop.hive.ql.hooks.ReadEntity;
import org.apache.hadoop.hive.ql.hooks.WriteEntity;
import org.apache.hadoop.hive.ql.session.SessionState;
import org.apache.hadoop.security.UserGroupInformation;

import java.util.Set;

/**
 * Create by huangxuanfeng on 2020/5/8 下午4:45
 */
public class PostExecuteLogger implements PostExecute {
    @Override
    public void run(SessionState sessionState, Set<ReadEntity> set, Set<WriteEntity> set1, LineageInfo lineageInfo, UserGroupInformation userGroupInformation) throws Exception {
        long startTime = System.currentTimeMillis();
        System.out.println("post 1，" + startTime);
        System.out.println("post 2，" + sessionState.getCommandType());
        System.out.println("post 3，" + sessionState.getCmd());
        System.out.println("post 4，" + sessionState.getQueryId());
    }
}
