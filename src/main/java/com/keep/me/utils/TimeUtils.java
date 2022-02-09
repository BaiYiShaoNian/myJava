package com.keep.me.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Create by huangxuanfeng on 2022/1/27 2:41 PM
 *
 * @author huangxuanfeng
 */
public class TimeUtils {

    public static final SimpleDateFormat SDF_Y_M_D_HMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static final DateTimeFormatter DTF_Y_M_D_HMS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        String today = SDF_Y_M_D_HMS.format(new Date());
        System.out.println(today);
        Date date = null;
        try {
            date = SDF_Y_M_D_HMS.parse(today);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LocalDateTime localDate = LocalDateTime.now();
        System.out.println(localDate.format(DTF_Y_M_D_HMS));
        System.out.println(localDate.plusDays(3).format(DTF_Y_M_D_HMS));
        today = localDate.plusDays(3).format(DTF_Y_M_D_HMS);
        System.out.println(DTF_Y_M_D_HMS.parse(today));

        date = DateUtils.addDays(new Date(), 5);
        System.out.println(date);
    }
}
