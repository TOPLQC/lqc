package com.wnxy.day02;


import java.util.Arrays;
import java.util.Scanner;

public class ZuoYe {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        stacPersons();
    }

    public static void stacPersons() {
        String[] names = {"张三丰", "张无忌", "小昭", "白眉鹰王", "金毛狮王", "周芷若", "赵敏"};
        System.out.println(Arrays.toString(names));
        System.out.println("请输入要查找的姓氏");
        String surname = scanner.next();
        int count = 0;

        for (int i = 0; i < names.length; i++) {

            if (names[i].startsWith(surname)) {
                count++;
            }
        }
        System.out.println("姓" + surname + "的人数有" + count);
    }


    public static void seekName() {
        String[] names = {"张三丰", "张无忌", "小昭", "白眉鹰王", "金毛狮王", "周芷若", "赵敏"};
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals("张三")) {
                System.out.println("已经找到" + names[i] + "这名学员");
                return;
            }
        }
        System.out.println("查无此人！");
    }


    public static void stcName() {
        String[] names = {"张三丰", "张无忌", "小昭", "白眉鹰王", "金毛狮王", "周芷若", "赵敏"};
        int count = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() == 3) {
                count++;
            }
        }
        System.out.println("名字长度为3的学员人数为：" + count);
    }


    public static void collectScore() {
        System.out.println("请输入考试人数");
        int count = scanner.nextInt();
        double[] sco = new double[count];
        double sum = 0;
        for (int i = 0; i < count; i++) {
            System.out.printf("请输入第%s位学员成绩\n", i + 1);
            sco[i] = scanner.nextDouble();

        }
        double min = sco[0];
        double max = sco[0];
        for (int i = 0; i < sco.length; i++) {
            sum += sco[i];
            if (max < sco[i]) {
                max = sco[i];
            }
            if (min > sco[i]) {
                min = sco[i];
            }
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("avg=" + sum / sco.length);
    }


    public static void ergodicName() {
        String[] names = {"张三丰", "张无忌", "小昭", "白眉鹰王", "金毛狮王", "周芷若", "赵敏"};
        String sym = "";
        for (int i = 0; i < names.length; i++) {
            System.out.print(sym + names[i]);
            sym = "-";
        }

    }


    public static void exp() {
        System.out.print("请输入一个数字：");
        int number = scanner.nextInt();
        int sum = 0;
        int i = number;
        while (i != 0) {
            int digit = i % 10;
            sum += digit;
            i /= 10;
        }
        System.out.println("各个位数上数字之和为：" + sum);
    }

//    public static void test() {
//        String[][] test = {{"test1","test1","test1","test1","test1","test1"},
//                {"test2","test2","test2","test2","test2","test2"}};
//
//        System.out.println(test[0][1]);
//        System.out.println(test.length);
//    }
//
//
//    public static void sum() {
//        System.out.println("请输入一个正整数：");
//        int i = scanner.nextInt();
//        int sum = 0;
//
//        while (true) {
//            sum += i % 10;
//            if (i <= 0) {
//                break;
//            }
//            i /= 10;
//        }
//        System.out.println(sum);
//    }

//    public static void sum() {
//        System.out.print("请输入一个正整数：");
//        int num = scanner.nextInt();
//        int num2 = 0;
//        int sum = 0;
//        String count = "";
//        for (int i = num; i > 0; i = i / 10) {
//            num2 = i % 10;
//            sum += num2;
//            count = count + num2;
//            if (i >= 10) {
//                count += "+";
//            }
//        }
//        System.out.printf("%s=%s", count, sum);
//    }


//    public static void mul() {
//        int sum = 0;
//        for (int i = 51; i <= 100; i = i + 3) {
//            sum += i;
//        }
//        System.out.println(sum);
//    }


//
//    public static void sum01() {
//        System.out.println("请输入一个正数");
//        int number = scanner.nextInt();
//        if (number <= 0) {
//            System.out.println("输入错误");
//            return;
//        }
//        int sum = 0;
//        String massage = "";
//        for (int i = 1; i <= number; i++) {
//            sum += i;
//            if (i < number) {
//                massage = massage + i + "+";
//            } else {
//                massage = massage + i + "=";
//            }
//
//        }
//        System.out.println(massage + sum);
//    }
//
//
//    public static void exp() {
//        System.out.println("请输入两个正数");
//        int num = scanner.nextInt();
//        int num1 = scanner.nextInt();
//        boolean flag = (num1 < 0);
//        double res = 1;
//
//        if (flag) {
//            num1 *= -1;
//        }
//
//        for (int i = 1; i <= num1; i++) {
//            res *= num;
//        }
//
//        if (flag) {
//            res = 1 / res;
//        }
//        System.out.println(num + "的" + num1 + "次方为" + res);
//
//    }
//
//
//    public static void sum2() {
//        System.out.println("请输入一个正整数");
//        int num = scanner.nextInt();
//        int num1 = 0;
//        String count = "";
//
//        for (int i = 1; i <= num; i++) {
//            num1 += i;
//            count = count + i;
//            if (i < num) {
//                count += "+";
//            }
//
//        }
//        System.out.printf("%s=%s", count, num1);
//    }
//
//
//    public static void sum1() {
//        int sum = 0;
//        int sum1 = 0;
//        String count = "";
//        for (int i = 100; i >= 50; i--) {
//            sum = i;
//            if (sum % 2 == 1) {
//                sum1 += sum;
//                count = count + sum;
//                if (i > 50) {
//                    count += "+";
//                }
//            }
//        }
//        System.out.printf("%s=%s", count, sum1);
//    }
//
//
//    //提示用户输入一个数字，求这个数字中各个位数上数字之和。比如用户输入的是123，结果就是1+2+3 = 6；
//    public static void sum() {
//        System.out.print("请输入一个正整数：");
//        int num = scanner.nextInt();
//        int num2 = 0;
//        int sum = 0;
//        String count = "";
//        for (int i = num; i > 0; i = i / 10) {
//            num2 = i % 10;
//            sum += num2;
//            count = count + num2;
//            if (i >= 10) {
//                count += "+";
//            }
//        }
//        System.out.printf("%s=%s", count, sum);
//    }
//}


//System.out.print("请输入一个数字：");
//    int number = scanner.nextInt();
//
//    int sum = 0;
//    int temp = number;
//        while(temp !=0);
//
//    {
//        // 取出最低位的数字并加到累加和中
//        int digit = temp % 10;
//        sum += digit;
//
//        // 去掉最低位的数字
//        temp /= 10;
//    }
//
//        System.out.println("各个位数上数字之和为："+sum);
//}


//        ave();
//        weekDay();
//        score();


//    public static void ave() {
//        int num4 = 4;
//
//        System.out.println("请输入四个小数：");
//
//        double num = scanner.nextDouble();
//        double num1 = scanner.nextDouble();
//        double num2 = scanner.nextDouble();
//        double num3 = scanner.nextDouble();
//
//        System.out.println("你输入四个小数的平均值为：" + (num + num1 + num2 + num3) / num4);
//    }
//
//
//    public static void size() {
//        System.out.println("请输入三个数：");
//        double num1 = scanner.nextDouble();
//        double num2 = scanner.nextDouble();
//        double num3 = scanner.nextDouble();
//
//        double max = num1;
//        double min = num1;
//
//        if (num2 > max) {
//            max = num2;
//        }
//
//        if (num3 > max) {
//            max = num3;
//        }
//
//        if (num2 < min) {
//            min = num2;
//        }
//
//        if (num3 < min) {
//            min = num3;
//        }
//
//        System.out.println("最大值：" + max);
//        System.out.println("最小值：" + min);
//
//    }
//
//
//    public static void ave{
//        int num4 = 0;
//        System.out.println("请输入四个小数：");
//        double num = scanner.nextDouble();
//        num4 = ++num4;
//        double num1 = scanner.nextDouble();
//        num4 = ++num4;
//        double num2 = scanner.nextDouble();
//        num4 = ++num4;
//        double num3 = scanner.nextDouble();
//        num4 = ++num4;
//        System.out.println("你输入四个小数的平均值为：" + (num + num1 + num2 + num3) / num4);
//    }
//
//
//    public static void max() {
//        System.out.println("请输入三个整数：");
//        int num1 = scanner.nextInt();
//        int num2 = scanner.nextInt();
//        int num3 = scanner.nextInt();
//
//        int max = num1;
//        if (num2 > max) {
//            max = num2;
//        }
//        if (num3 > max) {
//            max = num3;
//        }
//
//        System.out.println("最大的数是：" + max);
//    }
//}
//
//
//    public static void weekDay() {
//        System.out.println("请输入星期几：");
//        int weekDay = scanner.nextInt();
//        switch (weekDay) {
//            case 1:
//            case 3:
//            case 5:
//                System.out.println("今天是星期" + weekDay + "今天吃肠粉");
//                break;
//            case 2:
//            case 4:
//            case 6:
//                System.out.println("今天是星期" + weekDay + "今天吃包子");
//                break;
//            case 7:
//                System.out.println("今天是星期" + weekDay + "今天吃面条");
//            default:
//                System.out.println("输入的格式错误");
//                break;
//        }
//    }
//
//
//    public static void score() {
//        System.out.println("请输入语文成绩：");
//        int chinese = scanner.nextInt();
//
//        System.out.println("请输入数学成绩：");
//        int mat = scanner.nextInt();
//
//        System.out.println("请输入英语成绩：");
//        int english = scanner.nextInt();
//        System.out.printf("%s (%s)+%s (%s)+%s (%s)=%s", "语文",
//                chinese, "数学", mat, "英语", english, chinese + mat + english);
//    }
}
