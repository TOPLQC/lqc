package com.wnxy.lqc.view;

import com.wnxy.lqc.dao.DepartmentDao;
import com.wnxy.lqc.dao.MajorDao;
import com.wnxy.lqc.dao.StudentDao;
import com.wnxy.lqc.dto.DepartmentDto;
import com.wnxy.lqc.dto.MajorDto;
import com.wnxy.lqc.dto.StudentDto;
import com.wnxy.lqc.entity.Student;
import com.wnxy.lqc.factory.DaoFactory;
import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {
    DepartmentDao departmentDao = DaoFactory.createDao(DepartmentDao.class);
    StudentDao studentDao = DaoFactory.createDao(StudentDao.class);
    MajorDao majorDao = DaoFactory.createDao(MajorDao.class);
    Scanner scanner = new Scanner(System.in);
    Map<String, String> menuMap = new HashMap<>();

    {
        menuMap.put("---根据姓氏查找学生---", "getStudentBynName");
        menuMap.put("---列出所有开设超过两个专业的系的名称、该系专业数量---", "getMoreThanTwoMajors");
        menuMap.put("---只列出所有开设超过两个专业的系的名称---", "getMoreThanTwoMajorsOnlyName");
        menuMap.put("---查询每个系对应的专业名称、学生姓名、年龄---", "getStudentByMajors");
        menuMap.put("---查询学生表重复的数据显示出来---", "getRepeatStudent");
        menuMap.put("---添加系新的系---", "addDepartment");
    }

    public void run() {
        System.out.println("-------------------欢迎使用本系统！---------------------");
        while (true) {
            showMenu();
            System.out.println("是否要继续？y/n");
            String flag = scanner.next();
            if (flag.equals("n")) {
                return;
            }
        }
    }


    @SneakyThrows
    private void showMenu() {
        String[] menus = new String[menuMap.size()];
        menuMap.keySet().toArray(menus);

        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%s、%s\n", i + 1, menus[i]);
        }
        int index = scanner.nextInt() - 1;
        if (index > menus.length - 1) {
            System.out.println("输入错误");
            return;
        }
        String methodName = menuMap.get(menus[index]);

        Method method = View.class.getDeclaredMethod(methodName);
        try {
            method.invoke(this);//如果目标方法中有参数，那我们还必须在this后面填写实际参数
        } catch (InvocationTargetException ex) {
            System.out.println("出现了异常，原因是：" + ex.getTargetException().getMessage());
        }
    }

    private void addDepartment() {
        System.out.println("请输入新的系名");
        departmentDao.addDepartment(scanner.next());
    }

    private void getStudentBynName() {
        System.out.println("请输入姓氏");
        String name = scanner.next();
        List<StudentDto> studentBynName = studentDao.getStudentBynName(name);
        studentBynName.forEach(System.out::println);
    }

    private void getMoreThanTwoMajors() {
        List<MajorDto> list = majorDao.selectMoreThanTwoMajors();
        list.forEach(System.out::println);
    }

    private void getMoreThanTwoMajorsOnlyName() {
        List<MajorDto> list = majorDao.selectMoreThanTwoMajorsOnlyName();
        list.forEach(System.out::println);
    }

    private void getRepeatStudent() {
        List<Student> repeatStudent = studentDao.getRepeatStudent();
        repeatStudent.forEach(System.out::println);
    }

    private void getStudentByMajors() {
        List<DepartmentDto> list = departmentDao.selectStudentByMajors();
        list.forEach(System.out::println);
    }
}
