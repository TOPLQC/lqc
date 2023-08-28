package com.wnxy.zhoukao.student.view;

import com.wnxy.zhoukao.student.dao.StudentDao;
import com.wnxy.zhoukao.student.entity.Student;
import com.wnxy.zhoukao.student.factory.DaoFactory;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentView {

    StudentDao studentDao = DaoFactory.creatStudentDao();//通过DaoFactory获取StudentDao的方法
    Scanner scanner = new Scanner(System.in);
    Map<String, String> menuMap = new HashMap<>();

    {
        menuMap.put("查询全部学员", "showAllStudent");
        menuMap.put("添加学员", "addStudent");
        menuMap.put("查询每个年级的年级名称和学员人数", "selectStudentCountByGrade");
        menuMap.put("根据id号修改学员所属城市和年级", "updateStudentInfo");
        menuMap.put("根据id号删除学员", "deleteStudentById");
        menuMap.put("查询每个城市的学员人数", "selectStudentCountByAllCity");
        menuMap.put("查询姓张的学员人数", "selectFirstNameByZhang");
    }

    public void run() {
        System.out.println("~~~~~~欢迎使用本系统！~~~~~~");
        while (true) {
            showMenu();
            System.out.println("是否要继续？y/n");
            String flag = scanner.next();
            if (!flag.equalsIgnoreCase("y")) {
                return;
            }
        }
    }

    @SneakyThrows
    private void showMenu() {
        String[] menus = new String[menuMap.size()];
        menuMap.keySet().toArray(menus);//把菜单的key放到String数组中
        for (int i = 0; i < menus.length; i++) {
            System.out.printf("%s、%s\n", i + 1, menus[i]);
        }
        int index = scanner.nextInt() - 1;
        if (index > menus.length - 1) {
            System.out.println("输入错误");
            return;
        }
        String methodName = menuMap.get(menus[index]);
        Method method = StudentView.class.getDeclaredMethod(methodName);
        method.invoke(this);
    }

    public void showAllStudent() {
        List<Student> students = studentDao.showAllStudent();
        students.forEach(System.out::println);
    }

    private Student getStudentInfo() {
        Student student = new Student();

//        System.out.print("请输入学生编号：");
//        student.setId(scanner.nextInt());

        System.out.print("请输入学生姓名：");
        student.setName(scanner.next());

        System.out.print("请输入学生年级：");
        student.setGrade(scanner.next());

        System.out.print("请输入学生所在地：");
        student.setCity(scanner.next());

        System.out.print("请输入学生年龄：");
        student.setAge(scanner.nextInt());

        return student;
    }

    public void addStudent() {
        Student student = getStudentInfo();
        studentDao.addStudent(student);
        showAllStudent();
    }

    public void selectStudentCountByGrade() {
        Map<String, Long> map = studentDao.selectStudentCountByGrade();
        map.forEach((grade, count) ->
                System.out.println("年级：" + grade + "，学员人数：" + count));
    }

    public void updateStudentInfo() {
        showAllStudent();
        System.out.println("请输入要修改学生的id");
        int id = scanner.nextInt();
        System.out.println("请输入新的城市");
        String city = scanner.next();
        System.out.println("请输入新的年级");
        String grade = scanner.next();
        boolean flag = studentDao.updateStudentInfo(id, city, grade);
        if (!flag) {
            System.out.println("修改失败，请检查你输入的id");
        }
        System.out.println("修改成功，请重新查询全部学员");
    }

    public void deleteStudentById() {
        showAllStudent();
        System.out.println("请输入需要删除的学生id");
        int id = scanner.nextInt();
        studentDao.deleteStudentById(id);
        showAllStudent();
    }

    public void selectStudentCountByAllCity() {
        Map<String, Long> map = studentDao.selectStudentCountByAllCity();
        map.forEach((city, count) -> System.out.println("城市：" + city + ".学生人数:" + count));
    }

    public void selectFirstNameByZhang() {
        Long count = studentDao.selectFirstNameByZhang();
        System.out.println("张姓学生的人数为：" + count);
    }
}
