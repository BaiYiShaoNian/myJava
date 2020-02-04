package com.keep.me;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        LocalDate localDate = LocalDate.parse("2019-10-12");
        System.out.println(localDate);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println(sdf.parse("2019-10-12 12:22"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH");

        LocalDateTime localDateTime = LocalDateTime.parse("2019-10-19-22", df);
        System.out.println(localDateTime);
        LocalDateTime localDateTime2 = LocalDateTime.parse("2019-10-23-09", df);
        System.out.println(localDateTime2);

        System.out.println(localDateTime.plusHours(2));
        System.out.println(localDateTime.compareTo(localDateTime2));

        //按照小时
        while(localDateTime2.compareTo(localDateTime) >= 0) {
            System.out.println(localDateTime + " " + localDateTime.format(df).toString());
            localDateTime = localDateTime.plusHours(1);
        }

        collectLocalDates("2019-10-01", "2019-11-23").forEach(x -> {
            System.out.println("当前日期为： " + x);
            Calendar calendar = Calendar.getInstance();
            try {
                calendar.setTime(sdf.parse(x));
                int week = calendar.get(Calendar.DAY_OF_WEEK) -1;
                System.out.println("week: " + week);
                System.out.println("month: " + calendar.get(Calendar.DAY_OF_MONTH));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd-HH"), sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date = sdf3.parse("2019-10-21 15:30");
            System.out.println(date.getTime());
            System.out.println(date.toString());
            System.out.println(sdf2.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.format(df));
        System.out.println(ldt.plusDays(-30).format(df));

    }

    public static List<String> collectLocalDates(String timeStart, String timeEnd){
        return collectLocalDates(LocalDate.parse(timeStart), LocalDate.parse(timeEnd));
    }

    /**
     * 收集起始时间到结束时间之间所有的时间并以字符串集合方式返回
     * @param start
     * @param end
     * @return
     */
    public static List<String> collectLocalDates(LocalDate start, LocalDate end) {
        // 用起始时间作为流的源头，按照每次加一天的方式创建一个无限流
        return Stream.iterate(start, localDate -> localDate.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end) + 1)  // 截断无限流，长度为起始时间和结束时间的差+1个
                .map(LocalDate::toString)  // 由于最后要的是字符串，所以map转换一下
                .collect(Collectors.toList());  // 把流收集为List

    }
}
