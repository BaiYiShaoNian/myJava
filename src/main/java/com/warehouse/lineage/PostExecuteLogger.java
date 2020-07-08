package com.warehouse.lineage;

import org.apache.hadoop.hive.ql.hooks.*;
import org.apache.hadoop.hive.ql.session.SessionState;
import org.apache.hadoop.security.UserGroupInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Set;

/**
 * Create by huangxuanfeng on 2020/5/8 下午4:45
 */
public class PostExecuteLogger implements ExecuteWithHookContext {
    @Override
    public void run(HookContext hookContext) throws Exception {
        //System.out.println("hello, huangxuanfeng, this is first hook test");
        //System.out.println("start hook  ... ");
        //System.out.println("1, " + hookContext.getInputs());
        //System.out.println("2, " + hookContext.getOutputs());
        //System.out.println("3, " + hookContext.getOperationName());
        //System.out.println("目前开始时间为： " + System.currentTimeMillis());
        //System.out.println("end hook  ... ");
        if (hookContext.getOperationName().equals("QUERY")
                || hookContext.getOperationName().equals("CREATETABLE_AS_SELECT")) {
            String input = hookContext.getInputs().toString().replaceAll(" ", "");
            String output = hookContext.getOutputs().toString().replaceAll(" ", "");
            String queryId = hookContext.getQueryPlan().getQueryId();
            String queryString = hookContext.getQueryPlan().getQuery().getQueryAttributes().getOrDefault("queryString", "none");
            long startTime = System.currentTimeMillis();

            Connection conn;
            PreparedStatement stmt;
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://premysql01.rds.svc.ali.keep:3306/keep_melon_server?useSSL=false";
            String user = "p_melon_server";
            String password = "PifolbGWpkLDNDPS";
            String sql = "insert into meta_sql_duration (query_id,query_string,input,output,start_time) values (?,?,?,?,?)";

            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
                stmt = (PreparedStatement) conn.prepareStatement(sql);
                stmt.setString(1, queryId);
                stmt.setString(2, queryString);
                stmt.setString(3, input);
                stmt.setString(4, output);
                stmt.setLong(5, startTime);
                //stmt.executeUpdate();
                stmt.execute();
                conn.close();
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
    }
}
