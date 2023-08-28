package com.wnxy.dierzhouzuoye;

import java.util.Arrays;

public class ZuoYe {
    public static void main(String[] args) {
        calldoSort();
    }

    public static void calldoSort() {
        int[] arr = {5, 6, 2, 4, 8, 9, 2, 3, 6};

        boolean upSort = true;
        int[] arraySort = doSort(arr, upSort);
        System.out.println(Arrays.toString(arraySort));
    }


    public static int[] doSort(int[] nums, boolean upSort) {
        int length = nums.length;
        boolean judge;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                judge = upSort ? nums[j] > nums[j + 1] : nums[j] < nums[j + 1];
                if (judge) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }


//    public static int[] getArraySort(int[] numbers, boolean ascend) {
//        int length = numbers.length;
//        boolean judg;
//        for (int i = 0; i < length - 1; i++) {
//            for (int j = 0; j < length - i - 1; j++) {
//                judg = ascend ? numbers[j] > numbers[j + 1] : numbers[j] < numbers[j + 1];
//                if (judg) {
//                    int temp = numbers[j];
//                    numbers[j] = numbers[j + 1];
//                    numbers[j + 1] = temp;
//                }
//            }
//        }
//
//        return numbers;
//    }

}
