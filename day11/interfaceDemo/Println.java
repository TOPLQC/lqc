package com.wnxy.day11.interfaceDemo;

public class Println {

    public void printlnSquare(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }

//
//    public static void square01 (){
//        System.out.println("请输入边长");
//        int i=5;
//        for (int j = 0; j < i  ; j++) {
//             System.out.println();
//            for (int k = 0; k < i ; k++) {
//                System.out.print("*  ");
//            }
//        }
//    }

}
