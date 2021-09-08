package com.java.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.base.dto.City;
import com.keep.commons.utils.location.IpLocationUtils;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Create by huangxuanfeng on 2020/12/13 下午10:17
 *
 * @author huangxuanfeng
 */
public class MyDate {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.length());

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println(second);
        second = localDateTime.toEpochSecond(ZoneOffset.ofHours(8));
        System.out.println(second);
        System.out.println(localDateTime.minusYears(1));
        System.out.println(localDateTime.plusMonths(2));
        System.out.println(localDateTime.plusDays(2));

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        localDate = LocalDate.of(2020, 2, 28);
        System.out.println(localDate);
        System.out.println(localDate.plusDays(3));

        localDate = LocalDate.parse("2020-03-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(localDate);
        System.out.println(localDate.plusDays(-3));

        String ip = "223.104.1.30";

        ObjectMapper objectMapper = new ObjectMapper();
        City city = new City();
        city.setCountry("中国");
        city.setProvince("北京市");
        city.setCity("北京市");
        String val = "";
        try {
            val = objectMapper.writeValueAsString(city);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("val: " + val);
        val = "{\"country\":\"中国\",\"province\":\"北京市\",\"city\":\"北京市\"}";
        try {
            System.out.println("val new: " + val);
            City city1 = objectMapper.readValue(val, City.class);
            System.out.println(city1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String startDate = "2021-08-02", endDate = "2021-08-02";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter m_dtf = DateTimeFormatter.ofPattern("yyyy-MM");
        LocalDate localDate1 = null;
        while (startDate.compareTo(endDate) <= 0) {
            localDate1 = LocalDate.parse(startDate);
            System.out.println("cur month: " + localDate1.format(m_dtf));
            startDate = localDate1.plusMonths(1).format(dtf);
        }

        Long c = 16540993L;
        System.out.println(c + " " + c * 1.0);
        Double d = 16540993 * 1.0;
        DecimalFormat df = new DecimalFormat();
        System.out.println(d + d);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = "2021-08-23 16:00:00";
        try {
            System.out.println(sdf.parse(s).getDate());
            System.out.println(sdf.parse(s).getTime());
            System.out.println(System.currentTimeMillis() - sdf.parse(s).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        int curResult = 491, compareValue = 1000;
        boolean flag = false;
        String alarmReason = null;
        switch ("大于") {
            case "大于":
                if (curResult > compareValue) {
                    flag = true;
                    alarmReason = MessageFormat.format("监控结果为{0}，固定值大于阈值{1}", curResult, compareValue);
                }
                break;
            case "小于":
                if (curResult < compareValue) {
                    flag = true;
                    alarmReason = MessageFormat.format("监控结果为{0}，固定值小于阈值{1}", curResult, compareValue);
                }
                break;
            case "等于":
                if (curResult == compareValue) {
                    flag = true;
                    alarmReason = MessageFormat.format("监控结果为{0}，固定值等于阈值{1}", curResult, compareValue);
                }
                break;
            default:
        }
        System.out.println("alarmReason: " + alarmReason);
        alarmReason = "p_date={{ beijing_ds }}";
        System.out.println(alarmReason.replace("{{ beijing_ds }}", "'{{ beijing_ds }}'"));



    }
}
