package com.wnxy.crm06;

import com.wnxy.crm06.dao.EmpDao;
import com.wnxy.crm06.dao.impl.EmpDaoImpl;
import com.wnxy.crm06.entity.Employee;

public class MyTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        EmpDao empDao = new EmpDaoImpl();
        Employee ww = empDao.selectByAccount("ww");
        System.out.println(ww);
    }

//    public static void test2(){
//        test3();
//    }
//    public static void test3(){
//        test2();
//    }
}
