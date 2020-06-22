package com.warehouse.lineage;

import org.apache.hadoop.hive.ql.hooks.ExecuteWithHookContext;
import org.apache.hadoop.hive.ql.hooks.HookContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Create by huangxuanfeng on 2020/4/3 下午2:31
 * 数仓血缘关系解析
 */
public class LineageLogger implements ExecuteWithHookContext {

    @Override
    public void run(HookContext hookContext) throws Exception {
        System.out.println("hello, huangxuanfeng, this is first hook test");
        System.out.println("start hook  ... ");
        //System.out.println("1, " + hookContext.getQueryPlan());
        //System.out.println("2, " + hookContext.getConf());
        //System.out.println("3, " + hookContext.getCompleteTaskList());
        System.out.println("4, " + hookContext.getInputs());
        System.out.println("5, " + hookContext.getOutputs());
        //System.out.println("6, " + hookContext.getLinfo());
        ////System.out.println(hookContext.getUgi());
        //System.out.println("7, " + hookContext.getHookType());
        //System.out.println("8, " + hookContext.getIpAddress());
        //System.out.println("9, " + hookContext.getUserName());
        //System.out.println("10, " + hookContext.getInputPathToContentSummary());
        System.out.println("11, " + hookContext.getOperationName());
        System.out.println("end hook  ... ");
        if (hookContext.getOperationName().equals("QUERY")
                || hookContext.getOperationName().equals("CREATETABLE_AS_SELECT")) {
            String input = hookContext.getInputs().toString().replaceAll(" ", "");
            String output = hookContext.getOutputs().toString().replaceAll(" ", "");
            Connection conn;
            PreparedStatement stmt;
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
            String user = "root";
            String password = "12345";
            String sql = "insert into lineage_test (input_table, output_table) values (?,?)";

            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
                stmt = (PreparedStatement) conn.prepareStatement(sql);
                stmt.setString(1, input);
                stmt.setString(2, output);
                //stmt.executeUpdate();
                stmt.execute();
                conn.close();
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
    }
}
