package com.wnxy.day16;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        demo02();
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
