package com.wnxy.day07;

import java.util.Scanner;

public class MethodApp {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        triple1();
        callTriple2();
    }


    public static void printSquare(int sideLength) {

    }

    public static int[] doSort(int[] array, boolean sortOrder) {
        return null;
    }

    public static String determineAge(int age) {
        return null;
    }


    public static void product() {

    }

    public static String getFinal(String[] arrs) {
        return null;
    }

    public static int[] bubbleSort(int[] array) {
        return null;
    }


    public static void division(double a, double b) {
        System.out.println(a / b);
    }
//
//    public static int[] doInput(int a){
//        return null;


    public static int addArray(int[] arrs) {
        int sum = 0;
        for (int arr : arrs) {
            sum += arr;
        }
        return sum;
    }

    public static int nameCount(String[] names) {
        int count = 0;
        for (String name : names) {
            if (name.length() == 3) {
                count++;
            }
        }
        return count;
    }


    public static void triple1() {
        System.out.println("请输入一个整数");
        int i = scanner.nextInt();
        System.out.println(i * 3);
    }

    public static void callTriple2() {
        System.out.println("请输入一个整数");
        int i = scanner.nextInt();
        int res = triple2(i);
        System.out.println(res);
    }

    public static int triple2(int i) {
        return i * 3;
    }
}
