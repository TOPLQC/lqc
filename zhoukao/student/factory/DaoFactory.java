package com.wnxy.zhoukao.student.factory;

import com.wnxy.zhoukao.student.dao.StudentDao;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
    @SneakyThrows
    public static StudentDao creatStudentDao() {
        ClassLoader loader = DaoFactory.class.getClassLoader();
        InputStream is = loader.getResourceAsStream("dao.properties");
        Properties properties = new Properties();
        properties.load(is);
        String property = properties.getProperty("STUDENT_DAO");
        StudentDao studentDao = (StudentDao) Class.forName(property).newInstance();
        return studentDao;
    }
}
