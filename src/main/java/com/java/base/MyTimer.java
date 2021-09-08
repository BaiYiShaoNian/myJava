package com.java.base;

import org.apache.commons.lang3.math.NumberUtils;

import java.sql.*;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Create by huangxuanfeng on 2021/4/24 下午7:42
 *
 * @author huangxuanfeng
 */
public class MyTimer {

    /**
     * @see #test()
     * @see com.java.base.model.KeepMoMessage
     * @see com.java.base.locks.MyLockTest
     */
    private static String MYSQL_CONN = "jdbc:mysql://{0}:3306/{1}?useUnicode=true&characterEncoding=UTF-8" +
            "&connectTimeout=1000&socketTimeout=1000";

    private static Map<Long, String> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        //MyTimer myTimer = new MyTimer();
        //System.out.println("start...");
        //for (Map.Entry<Long, String> entry: map.entrySet()) {
        //    System.out.println("k-v: " + entry.getKey() + " " + entry.getValue());
        //}
        //Timer timer = new Timer();
        //timer.schedule(myTimer.new MyTask(), 0, 5 * 1000);
        //
        //Thread.sleep(10 * 1000);
        //
        //System.out.println("end...");
        //for (Map.Entry<Long, String> entry: map.entrySet()) {
        //    System.out.println("new k-v: " + entry.getKey() + " " + entry.getValue());
        //}
        //
        //Thread.sleep(5 * 1000);
        //timer.cancel();
        MyTimer myTimer = new MyTimer();
        myTimer.test();

        String s = "fq";
        System.out.println(NumberUtils.isNumber(s));
        s = "";
        System.out.println(NumberUtils.isNumber(s));
        s = "123";
        System.out.println(NumberUtils.isNumber(s));

        String entry = "true";
        String actualType = entry.getClass().getSimpleName();
        System.out.println(actualType);

        System.out.println(myTimer.getCurHourStage(3));

    }

    public int getCurHourStage(Integer param) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int hour = 15;
        int stageUnit = 24 / param;
        System.out.println("stageUnit: " + stageUnit);
        int index = 0;
        for (int i=0; i<24; i+=stageUnit) {
            index += 1;
            if (hour >= i && hour < i+stageUnit) {
                break;
            }
        }
        return index;
    }

    /**
     * @deprecated 哈哈哈，{@link #test2()}
     */
    @Deprecated
    public void test() {
        MyTimer myTimer = new MyTimer();
        System.out.println("start...");
        for (Map.Entry<Long, String> entry: map.entrySet()) {
            System.out.println("k-v: " + entry.getKey() + " " + entry.getValue());
        }
        Timer timer = new Timer(true);
        timer.schedule(myTimer.new MyTask(), 0, 5 * 1000);
    }

    public void test2() {
        System.out.println("");
    }

    public class MyTask extends TimerTask {
        String driver = "com.mysql.jdbc.Driver";
        String url = MessageFormat.format(MYSQL_CONN, "localhost", "test");
        String user = "root";
        String pwd = "123456";
        String table = "dev_product";
        String sql = MessageFormat.format("select product_id,product_name from {0}", table);

        Connection conn = null;
        Statement stmt = null;

        @Override
        public void run() {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, pwd);
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    map.put(rs.getLong(1), rs.getString(2));
                }
                rs.close();
                System.out.println("ProductConvMapper-MyTask-ok size: " + map.size());
                for (Map.Entry<Long, String> entry: map.entrySet()) {
                    System.out.println("run k-v: " + entry.getKey() + " " + entry.getValue());
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("ProductConvMapper-MyTask-fail: " + e.getMessage());
            } finally {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.out.println("ProductConvMapper-stmt close fail");
                }
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("ProductConvMapper-conn close fail");
                }
            }
        }
    }
}
