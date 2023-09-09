package com.wnxy.lqc.factory;

import com.wnxy.lqc.dao.DepartmentDao;
import com.wnxy.lqc.dao.MajorDao;
import com.wnxy.lqc.dao.StudentDao;
import com.wnxy.lqc.utils.PropertyUtil;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
    @SneakyThrows
    public static <T> T createDao(Class<T> clazz) {
        String simpleName = clazz.getSimpleName();
        String className = PropertyUtil.getProperty(simpleName);
        T t = (T) Class.forName(className).newInstance();
        return t;
    }


    @SneakyThrows
    public static DepartmentDao creatDepartmentDao() {
        ClassLoader loader = DaoFactory.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("application.properties");//输入
        Properties properties = new Properties();
        properties.load(is);
        String property = properties.getProperty("DepartmentDao");
        return (DepartmentDao) Class.forName(property).newInstance();
    }

    @SneakyThrows
    public static MajorDao creatMajorDao() {
        ClassLoader loader = DaoFactory.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(is);
        String property = properties.getProperty("MajorDao");
        return (MajorDao) Class.forName(property).newInstance();
    }

    @SneakyThrows
    public static StudentDao creatStudentDao() {
        ClassLoader loader = DaoFactory.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(is);
        String property = properties.getProperty("StudentDao");
        return (StudentDao) Class.forName(property).newInstance();
    }
}
