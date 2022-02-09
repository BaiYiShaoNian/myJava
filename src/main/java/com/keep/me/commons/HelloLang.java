package com.keep.me.commons;

import com.keep.me.utils.TimeUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Create by huangxuanfeng on 2022/1/27 2:35 PM
 *
 * @author huangxuanfeng
 */
public class HelloLang {

    public static void main(String[] args) {
        System.out.println(RandomStringUtils.randomNumeric(10));
        System.out.println(RandomStringUtils.randomAlphanumeric(10));

        System.out.println(RandomUtils.nextInt(10, 1000));
        System.out.println(RandomUtils.nextInt(10, 1000));

        System.out.println(StringUtils.isNotBlank("  "));
        System.out.println(StringUtils.isNotEmpty("  "));

        System.out.println(StringUtils.isAllLowerCase("huang"));
        System.out.println(StringUtils.isAllUpperCase("Huang"));

        System.out.println(RandomStringUtils.random(30));
    }
}
