package com.wnxy.day06;

import java.util.Arrays;

public class QuickSort {
    private static int[] nums; // 类成员变量

    public static void main(String[] args) {
        sort();
        System.out.println("排序结果：" + Arrays.toString(nums));
    }

    public static void sort() {
        nums = new int[]{5, 2, 8, 1, 9, 4, 7, 3, 6}; // 初始化待排序数组
        quickSort(0, nums.length - 1); // 调用排序方法
    }

    public static void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    public static int partition(int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    public static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
