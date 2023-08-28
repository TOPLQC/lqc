package com.wnxy.day06;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArrDemo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        bubbleSort();
    }


    public static void bubbleSort() {
        int[] nums = {1000, 64, 34, 25, 12, 22, 11, 90, 80, 60, 100, 102, 800, 30};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }


    public static void triangle1() {
        System.out.println("请输入三角形的边长：");
        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int k = num - i; k >= 1; k--) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void triangle() {
        System.out.println("请输入三角形的边长：");
        int length = scanner.nextInt();

        for (int i = 1; i <= length; i++) {

            for (int k = length - i; k >= 1; k--) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            for (int j = 2; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void demo04() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%s*%s=%s\t", j, i, i * j);
            }
            System.out.println();
        }
    }


    public static void demo03() {
        int num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }


    public static void demo02() {
        System.out.println("请输入正方形的边长：");
        int length = scanner.nextInt();

        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (i == 1 || i == length || j == 1 || j == length) {
                    System.out.print("*  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }


    public static void demo01() {
        int num = scanner.nextInt();
        for (int i = 1; i <= num; i++) {

            for (int j = 0; j <= num; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }


    public static void delecByValue() {
        String[] arrs = {"a", "b", "c", "d", "e", "f", "g", "a", "b", "a", "p", "a"};
        System.out.println("原数组的值为" + Arrays.toString(arrs));
        int index = 0;
        String[] tapm = new String[arrs.length];
        System.out.println("请输入要删除的元素");
        String target = scanner.next();

        for (String arr : arrs) {
            if (!arr.equals(target)) {
                tapm[index] = arr;
                index++;
            }
        }
        if (index == arrs.length) {
            System.out.println("没有你要删除的元素");
        } else {
            arrs = Arrays.copyOf(tapm, index);
            System.out.println("已成功删除元素，现数组值为" + Arrays.toString(arrs));
        }
    }


    public static void delectByIndex() {
        String[] arrs = {"a", "b", "c", "d", "e", "f", "g"};
        System.out.println("请输入需要删除第几个元素");
        int index = scanner.nextInt() - 1;
        for (int i = index + 1; i < arrs.length; i++) {
            arrs[i - 1] = arrs[i];
        }
        String[] tamp = Arrays.copyOf(arrs, arrs.length - 1);
        arrs = tamp;
        System.out.println(Arrays.toString(arrs));
    }


    public static void reverseArr() {
        String[] arrs = {"a", "b", "c", "d", "e", "f", "g"};
        String tamp;
        for (int i = 0, j = arrs.length - 1; i < j; i++, j--) {
            tamp = arrs[i];
            arrs[i] = arrs[j];
            arrs[j] = tamp;

        }
        System.out.println("Arrays.toString(arrs) = " + Arrays.toString(arrs));
    }
}
