package com.wnxy.day19new.day19.factory;

import com.wnxy.day19.dao.StudentDao;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
    @SneakyThrows
    public static StudentDao creatCustomerDao() {
        //要找到目标文件，从文件中读取内容
        //得到当前类的字节码，获取当前类的加载器，通过类加载器读取文件内容
        ClassLoader loader = DaoFactory.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("dao.properties");//输入

        Properties properties = new Properties();
        properties.load(is);//加载文件内容
        //通过properties以及关键字，将要创建的DaoImpl类的类名创建出来
        String property = properties.getProperty("STUDENT_DAO");
        StudentDao studentDao = (StudentDao) Class.forName(property).newInstance();
        return studentDao;
    }
}
