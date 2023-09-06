package com.wnxy.new_crm_06.factory;

import com.wnxy.crm_v05.dao.CustomerDao;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
    @SneakyThrows
    public static CustomerDao creatCustomerDao() {
        //要找到目标文件，从文件中读取内容
        //得到当前类的字节码，获取当前类的加载器，通过类加载器读取文件内容
        ClassLoader loader = DaoFactory.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("dao.properties");//输入

        Properties properties = new Properties();
        properties.load(is);//加载文件内容
        //通过properties以及关键字，将要创建的DaoImpl类的类名创建出来
        String property = properties.getProperty("CUSTOMER_DAO");
        CustomerDao customerDao = (CustomerDao) Class.forName(property).newInstance();
        return customerDao;
    }
}
