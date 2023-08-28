package com.wnxy.day16;

import com.wnxy.disanzhouzuoye.utils.IdUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class DateDemo {
    public static void main(String[] args) {
        demo06();
    }

    public static void demo06() {
        for (int i = 0; i < 20; i++) {
            System.out.println(IdUtil.createId());
        }
    }

    public static void demo05() {
        Random random = new Random();
        for (int i = 0; i < 200; i++) {
            int num = random.nextInt(10000);
            String res = String.format("%04d", num);
            System.out.println(res);
        }
    }


    //生成四位随机数
    public static void demo04() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            double number = random.nextDouble();
            System.out.println(number);
        }
        for (int i = 0; i < 5; i++) {
            int num = random.nextInt(100000);
            System.out.println(num);
        }

    }

    public static void demo03() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime birth = LocalDateTime.of(1998, 8, 25, 00, 00, 00);

        System.out.println(now.format(dateTimeFormatter));
        System.out.println(birth.format(dateTimeFormatter));
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
