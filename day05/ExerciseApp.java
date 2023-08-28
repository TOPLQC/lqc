package com.wnxy.day05;


import java.util.Scanner;

public class ExerciseApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        allDemo();
    }

    public static void allDemo() {
        boolean flag = true;
        while (flag) {
            System.out.println("请输入数字选择操作：");
            System.out.println("1：遍历学员姓名字符串数组，将所有长度为3的名字保存到一个字符串中，用逗号分隔");
            System.out.println("2：计算所有成员的总和，找出最大成员，找出最小成员.");
            System.out.println("3：挑出姓氏首字母为W的人员，挑出姓氏首字母在U->Z之间的人员");
            System.out.println("4：计算其中正数的个数,负数的个数,所有正数的总和,获得其中最小的成员");
            System.out.println("5：获得2字名的英雄,并输出,3字名的英雄有多少个?");
            System.out.println("6：获取所有的\"肉\"型英雄,并输出, 请问\"射手\"型英雄有几个?");
            System.out.println("7：请问这些员工的平均年龄是多少?找出其中的未成年员工,请问未成年员工的平均年龄是多少?");
            System.out.println("8：计算所有成员的平均值, 计算其中>10的成员的平均值");
            int action = scanner.nextInt();

            switch (action) {
                case 1: {
                    String res = "";
                    String[] names = new String[]{"张三丰", "赵敏", "张无忌", "小昭", "任我行"};
                    for (String name : names) {
                        if (name.length() == 3) {
                            res += name + ",";
                        }
                    }
                    System.out.println(res.substring(0, res.length() - 1));
                }
                case 2: {
                    int[] arrs = {6, 3, 1, 8, 12, 18, 9, 10};
                    int sum = 0;
                    int max = arrs[0];
                    int min = arrs[0];
                    for (int arr : arrs) {
                        sum += arr;
                        if (max < arr) {
                            max = arr;
                        }
                        if (min > arr) {
                            min = arr;
                        }

                    }
                    System.out.println("sum = " + sum);
                    System.out.println("max = " + max);
                    System.out.println("min = " + min);
                    break;
                }
                case 3: {
//                3：挑出姓氏首字母为W的人员，挑出姓氏首字母在U->Z之间的人员
                    String wName = "";
                    String name = "";
                    String[] arrs = {"S-苏小雨", "W-王婧", "W-王安石", "S-苏东坡", "Z-张之洞", "M-毛泽东", "X-谢广坤", "G-郭德纲"};
                    for (String arr : arrs) {
                        String[] person = arr.split("-");
                        if (person[0].equals("W")) {
                            wName += person[1] + " ";
                        }
                        if (arr.charAt(0) >= 'U' && arr.charAt(0) <= 'Z') {
                            name += person[1] + " ";
                        }
                    }
                    System.out.println("wName = " + wName);
                    System.out.println("name = " + name);
                    break;
                }
                case 4: {
                    int[] arrs = {-3, 12, -5, 6, 9, 12, -8};
                    int sum = 0;
                    int zhengCount = 0;
                    int fuCount = 0;
                    int min = arrs[0];
                    for (int arr : arrs) {
                        if (arr > 0) {
                            zhengCount++;
                            sum += arr;
                        }
                        if (arr < 0) {
                            fuCount++;
                        }
                        if (min > arr) {
                            min = arr;
                        }
                    }
                    System.out.println("sum = " + sum);
                    System.out.println("zhengCount = " + zhengCount);
                    System.out.println("fuCount = " + fuCount);
                    System.out.println("min = " + min);
                    break;
                }
                case 5: {
                    int count = 0;
                    String name = "";
                    String[] arrs = {"亚瑟", "安琪拉", "兰陵王", "周瑜", "诸葛亮"};
                    for (String arr : arrs) {
                        if (arr.length() == 2) {
                            name += arr + " ";
                        }
                        if (arr.length() == 3) {
                            count++;
                        }
                    }
                    System.out.println("name = " + name);
                    System.out.println("count = " + count);
                    break;
                }
                case 6: {
                    String name = "";
                    int count = 0;
                    String[] arrs = {"亚瑟-肉", "宫本武藏-刺客", "张飞-肉", "鲁班-射手", "狄仁杰-射手"};
                    for (String arr : arrs) {
                        String[] person = arr.split("-");
                        if (person[1].equals("肉")) {
                            name += person[0] + " ";
                        }
                        if (person[1].equals("射手")) {
                            count++;
                        }
                    }
                    System.out.println("name = " + name);
                    System.out.println("count = " + count);
                    break;
                }
                case 7: {
                    int allAge = 0;
                    String youngName = "";
                    int youngCount = 0;
                    int youngAge = 0;
                    String[] arrs = {"罗智利-20", "陈海燕-12", "刘颖聪-30", "邬艳-25", "王璐苑-14"};
                    for (String arr : arrs) {
                        String[] person = arr.split("-");
                        int age = Integer.parseInt(person[1]);
                        allAge += age;
                        if (age < 18) {
                            youngName += person[0] + " ";
                            youngCount++;
                            youngAge += age;
                        }
                    }
                    System.out.println("allAvg = " + allAge / arrs.length);
                    System.out.println("youngName = " + youngName);
                    System.out.println("youngAvg = " + youngAge / youngCount);
                    break;

                }
                case 8: {
                    int[] arrs = {13, 15, 6, 9, 8, 12, 5};
                    int sum = 0;
                    int passCount = 0;
                    int passSum = 0;
                    for (int arr : arrs) {
                        sum += arr;
                        if (arr > 10) {
                            passCount++;
                            passSum += arr;
                        }
                    }
                    System.out.println("allAvg = " + sum / arrs.length);
                    System.out.println("passAvg = " + passSum / passCount);
                    break;
                }
            }
            System.out.println("是否要回到选择界面？输入：是/否");
            String yesOrNo = scanner.next();
            if (yesOrNo.equals("否")) {
                flag = false;
            }
            if (yesOrNo.charAt(0) != '是' && yesOrNo.charAt(0) != '否') {
                flag = false;
                System.out.println("输入错误，系统关闭");
            }
        }
    }

    public static void demo09() {
        String chas = "abc1234abab5678bc";
        int count = 0;
        int index = -1;
        while ((index = chas.indexOf("ab", index + 1)) != -1) {
            count++;
            System.out.println(index);
        }
        System.out.println(count);
    }
}

//    //- 遍历学员姓名字符串数组，将所有长度为3的名字保存到一个字符串中，用逗号分隔
//    public static void demo1() {
//        String res = "";
//        String[] names = new String[]{"张三丰", "赵敏", "张无忌", "小昭", "任我行"};
//        for (String name : names) {
//            if (name.length() == 2) {
//                res += name + " ";
//            }
//        }
//        System.out.println(res);
//    }
//
//    //- int[] arr={6,3,1,8,12,18,9,10}; 计算所有成员的总和，找出最大成员，找出最小成员.
//    public static void demo02() {
//        int[] arrs = {6, 3, 1, 8, 12, 18, 9, 10};
//        int max = arrs[0];
//        int min = arrs[0];
//        int sum = 0;
//        for (int arr : arrs) {
//            sum += arr;
//            if (max < arr) {
//                max = arr;
//            }
//            if (min > arr) {
//                min = arr;
//            }
//        }
//        System.out.println("sum = " + sum);
//        System.out.println("max = " + max);
//        System.out.println("min = " + min);
//    }
//
//
//    //- String[] arr={"S-苏小雨","W-王婧",...}; 挑出姓氏首字母为W的人员，挑出姓氏首字母在U->Z之间的人员
//
//    public static void demo03() {
//        String wName = "";
//        String name = "";
//        String[] arrs = {"S-苏小雨", "W-王婧", "W-王安石", "S-苏东坡", "Z-张之洞", "M-毛泽东", "X-谢广坤", "G-郭德纲"};
//        for (int i = 0; i < arrs.length; i++) {
//            String[] person = arrs[i].split("-");
//            if (person[0].equals("W")) {
//                wName += person[1] + " ";
//            }
//            if (arrs[i].charAt(0) >= 'U' && arrs[i].charAt(0) <= 'Z') {
//                name += person[1] + " ";
//            }
//        }
//        System.out.println("wName = " + wName);
//        System.out.println("name = " + name);
////        for (String arr : arrs) {
////            String[] names = arr.split("-");
////            if (names[0].equals("W")) {
////                wName += names[1] + " ";
////            }
////            if (arr.charAt(0) >= 'U' && arr.charAt(0) <= 'Z') {
////                name += names[1] + " ";
////            }
////        }
////        System.out.println("王姓人员有：" + wName);
////        System.out.println("姓氏首字母在U->Z之间的人员 : " + name);
//    }
//
//
//    //- int[] arr1 = { -3, 12, -5, 6, 9, 12, -8 };
////// 计算其中正数的个数,负数的个数,所有正数的总和,获得其中最小的成员
//////
//    public static void demo04() {
//        String[] arrs = {"-3", "12", "-5", "6", "9", "12", "-8"};
//        int min = Integer.parseInt(arrs[0]);
//        int minus = 0;
//        int porNum = 0;
//        int sum=0;
//
//        for (int i = 0; i < arrs.length; i++) {
//            int num = Integer.parseInt(arrs[i]);
//            if (num>0){
//                porNum++;
//                sum+=num;
//            }
//            if (num < 0) {
//                minus++;
//            }
//            if (min > num) {
//                min = num;
//            }
//        }
//        System.out.println("minus = " + minus);
//        System.out.println("min = " + min);
//        System.out.println("porNum = " + porNum);
//        System.out.println("sum = " + sum);
//
//
////        int zheng = 0;
////        int fu = 0;
////        int sum = 0;
////        for (int arr : arrs) {
////            sum += arr;
////            if (arr > 0) {
////                zheng++;
////            }
////            if (arr < 0) {
////                fu++;
////            }
////        }
////        System.out.println("sum = " + sum);
////        System.out.println("zheng = " + zheng);
////        System.out.println("fu = " + fu);
//    }
//
//
//    //- String[] arr2 = { "亚瑟", "安琪拉", "兰陵王", "周瑜", "诸葛亮" };
////// 获得2字名的英雄,并输出,3字名的英雄有多少个?
//////
//    public static void domo05() {
//        int count = 0;
//        String[] arrs = {"亚瑟", "安琪拉", "兰陵王", "周瑜", "诸葛亮"};
//        for (String arr : arrs) {
//            if (arr.length() == 2) {
//                System.out.println(arr);
//            }
//            if (arr.length() == 3) {
//                count++;
//            }
//        }
//        System.out.println("count = " + count);
//    }
//
//    //- String[] arr3 = { "亚瑟-肉", "宫本武藏-刺客", "张飞-肉", "鲁班-射手", "狄仁杰-射手" };
////// 获取所有的"肉"型英雄,并输出, 请问"射手"型英雄有几个?
//////
//    public static void demo06() {
//        int count = 0;
//        String name = "";
//        String[] arr3 = {"亚瑟-肉", "宫本武藏-刺客", "张飞-肉", "鲁班-射手", "狄仁杰-射手"};
//        for (String arr : arr3) {
//            String[] person = arr.split("-");
//            if (person[1].equals("肉")) {
//                name += person[0] + " ";
//            }
//            if (person[1].equals("射手")) {
//                count++;
//            }
//
//        }
//        System.out.println("所有的肉型英雄:  " + name);
//        System.out.println("射手型英雄有：" + count + "个");
//
//    }
//
//    //- String[] arr4 = { "罗智利-20", "陈海燕-12", "刘颖聪-30", "邬艳-25", "王璐苑-14" };
////// 请问这些员工的平均年龄是多少?找出其中的未成年员工,请问未成年员工的平均年龄是多少?
//////
//////
//    public static void demo07() {
//        String[] arr4 = {"罗智利-20", "陈海燕-12", "刘颖聪-30", "邬艳-25", "王璐苑-14"};
//        int allAgeSum = 0;
//        int youngCount = 0;
//        int allYoungAge = 0;
//        String youngname = "";
//        for (String arr : arr4) {
//            String[] person = arr.split("-");
//            int age = Integer.parseInt(person[1]);
//            allAgeSum += age;
//            if (age < 18) {
//                youngname += person[0] + " ";
//                allYoungAge += age;
//                youngCount++;
//            }
//        }
//        System.out.println("员工的平均年龄：" + allAgeSum / arr4.length);
//        System.out.println("未成年员工: " + youngname);
//        System.out.println("未成年员工的平均年龄:" + allYoungAge / youngCount);
//
//    }
//
//    //- int[] arr5 = { 13, 15, 6, 9, 8, 12, 5 };
////// 计算所有成员的平均值, 计算其中>10的成员的平均值
//////
//    public static void demo08() {
//        int sum = 0;
//        int passSum = 0;
//        int count = 0;
//        String[] arr5 = {"13", "15", "6", "9", "8", "12", "5"};
//        for (String arr : arr5) {
//            int num = Integer.parseInt(arr);
//            sum += num;
//            if (num > 10) {
//                passSum += num;
//                count++;
//            }
//        }
//        System.out.println("avg = " + sum / arr5.length);
//        System.out.println("passAvg=" + passSum / count);
//    }
