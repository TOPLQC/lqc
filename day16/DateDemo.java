package com.wnxy.day16;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        demo03();
    }

    public static void demo03() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(now.format(dateTimeFormatter));
    }

    public static void demo02() {
        String date = "1998-08-25";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = null;
        try {
            birth = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(birth);
    }

    public static void demo01() {
        Date now = new Date();
        System.out.println(now);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 时间：hh:mm:ss SSS");
        String format = simpleDateFormat.format(now);
        System.out.println(format);
    }
}
