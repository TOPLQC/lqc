package com.wnxy.crm06.factory;

import com.wnxy.crm06.dao.CustomerDao;
import com.wnxy.crm06.dao.EmpDao;
import com.wnxy.crm06.dao.RecordDao;
import com.wnxy.crm06.utils.PropertyUtil;
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
    public static CustomerDao creatCustomerDao() {
        //要找到目标文件，从文件中读取内容
        //得到当前类的字节码，获取当前类的加载器，通过类加载器读取文件内容
        ClassLoader loader = DaoFactory.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("application.properties");//输入
        Properties properties = new Properties();
        properties.load(is);//加载文件内容
        //通过properties以及关键字，将要创建的DaoImpl类的类名创建出来
        String property = properties.getProperty("CUSTOMER_DAO");
        //        CustomerDao customerDao = new CustomerDaoImpl();
        return (CustomerDao) Class.forName(property).newInstance();
    }

    @SneakyThrows
    public static EmpDao creatEmpDao() {
        ClassLoader loader = DaoFactory.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(is);
        String property = properties.getProperty("EMP_DAO");
        return (EmpDao) Class.forName(property).newInstance();
    }

    @SneakyThrows
    public static RecordDao creatRecordDao() {
        ClassLoader loader = DaoFactory.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("application.properties");
        Properties properties = new Properties();
        properties.load(is);
        String property = properties.getProperty("RECORD_DAO");
        return (RecordDao) Class.forName(property).newInstance();
    }
}
