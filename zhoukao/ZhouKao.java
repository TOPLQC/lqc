package com.wnxy.zhoukao;

import java.util.Scanner;

public class ZhouKao {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        demo10();
    }

    public static void demo10() {
        String person = "";
        String[] names = {"研发部-马化腾-2001", "研发部-李彦宏-2002",
                "市场部-董明珠-1977", "后勤部-王健林-1966", "研发部-雷军-1999"};
        for (String name : names) {
            String[] source = name.split("-");
            int year = Integer.parseInt(source[2]);
            if (year >= 2000) {
                person += source[1] + "-" + source[2] + ",";
            }
        }
        System.out.println("00后员工为：" +
                person.substring(0, person.length() - 1) + "。");
    }

    public static void demo09() {
        System.out.println("请输入密码，密码由数字和非数字");
        String pwd;
        pwd = scanner.next();
        int count = 0;
        int mark = 0;
        for (int i = 0; i < pwd.length(); i++) {
            if (pwd.charAt(mark) >= '0' && pwd.charAt(mark) <= '9') {
                count++;
            }
            mark++;
            if (count == pwd.length()) {
                System.out.println("错误，密码中必须包含非数字");
                return;
            }
        }
        System.out.println("密码设置成功！");
    }

    public static void demo08() {
        int[] numbers = {1, 3, 55, 77, 96, 123, 300, 88, 97, 13, 1000, 10};
        int min = 100;
        for (int number : numbers) {
            if (number > 9 && number < 100) {
                if (min > number) {
                    min = number;

                }
            }
        }
        System.out.println("最小的十位数为：" + min);
    }


    public static void demo07() {
        int count = 0;
        String person = "";
        String[] names = {"研发部-马化腾", "研发部-李彦宏",
                "市场部-董明珠", "后勤部-王健林", "研发部-雷军"};
        for (String name : names) {
            String[] source = name.split("-");
            if (source[0].equals("研发部")) {
                person += source[1] + ",";
            }
            if (source[0].equals("市场部")) {
                count++;
            }
        }
        System.out.println("研发部人员姓名为：" + person.substring
                (0, person.length() - 1));
        System.out.println("市场部人员数量为：" + count);

    }

    public static void demo06() {
        String[] names = {"张无忌-男", "杨过-男", "小昭-女", "金毛狮王-男", "灭绝师太-女"};
        int man = 0;
        int woman = 0;
        for (String name : names) {
            String[] person = name.split("-");
            if (person[1].equals("男")) {
                man++;
            }
            if (person[1].equals("女")) {
                woman++;
            }
        }
        System.out.println("男生人数为 ： " + man);
        System.out.println("女生人数为 ： " + woman);
    }

    public static void demo05() {
        int num;
        int factorial = 1;
        System.out.println("请输入一个整数");
        num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        System.out.println(num + "的阶乘为：" + factorial);
    }


    public static void demo04() {
        double chinese;
        double math;
        double english;
        double totalScore;
        System.out.println("请输入语文成绩");
        chinese = scanner.nextDouble();
        System.out.println("请输入数学成绩");
        math = scanner.nextDouble();
        System.out.println("请输入英语成绩");
        english = scanner.nextDouble();
        totalScore = chinese + math + english;
        if (chinese < 60 || math < 60 || english < 60 || totalScore < 200) {
            if (totalScore < 200) {
                System.out.println("该学生成绩不合格，因为总分为：" + totalScore + "，低于200分");
            }
            if (chinese < 60 || math < 60 || english < 60) {
                System.out.println("该学生成绩不合格，因为三科中有一科没达到60分");
            }
            return;
        }
        System.out.println("该学生成绩合格,该学生的总分为：" + totalScore);
    }

    public static void demo03() {
        int i = 2;
        int count = 1;
        while (true) {
            count++;
            i = i * 2;
            if (i > 1000) {
                break;
            }
        }
        System.out.println(count);
    }

    public static void demo02() {
        for (int i = 1; i <= 100; i++) {
            if ((i % 2 != 0) && (i % 3 != 0) && (i % 5 != 0)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void demo01() {
        int sum = 0;
        for (int i = 20; i <= 50; i++) {
            if (i % 3 == 0) {
                sum += i;
            }
        }
        System.out.println("20-50之内，3的倍数的和为：" + sum);
    }

}

