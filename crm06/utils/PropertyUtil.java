package com.wnxy.crm06.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    private static final String fileName = "application.properties";
    private static Properties properties;

    static {
        //使用静态代码块来初始化静态成员
        //1.获取文件流(如果我们仅仅只是提供文件名，不包含路径，必须保证文件是直接放在src文件夹下)
        //如果信息是从文件到CPU，对CPU而言，就是一个输入的过程，于是就要使用输入流
        //properties去加载文件输入流

        try (InputStream is = PropertyUtil.class.getClassLoader().getResourceAsStream(fileName)) {
            properties = new Properties();
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
