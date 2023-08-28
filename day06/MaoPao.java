package com.wnxy.day06;

import java.util.Arrays;

public class MaoPao {
    static private final int[] arr = {1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 5) {
                System.out.println("index = " + i);
            }
        }

    }

    public static void bubbleSort() {

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("此数组已经有序");
                break;
            } else {
                System.out.println("排序前的数组：");
                System.out.println(Arrays.toString(arr));

                System.out.println("排序后的数组：");
                System.out.println(Arrays.toString(arr));
            }

        }
    }
}

//    public static void bubbleSort() {
//        int count=0;
//        int count1=0;
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - j; j++) {
//                count1++;
//                if (arr[j] > arr[j + 1]) {
//                    int tamp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = tamp;
//                    count++;
//                }
//
//            }
//
//        }
//    }


