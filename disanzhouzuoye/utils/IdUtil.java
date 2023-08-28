package com.wnxy.disanzhouzuoye.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class IdUtil {
    //工具类中的都是静态方法
    public static String createId() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter yyyyMMddHHmmss = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String timeStr = now.format(yyyyMMddHHmmss);
        Random random = new Random();
        int number = random.nextInt(10000);
        String id = String.format("%s%04d", timeStr, number);
        return id;
    }
}
