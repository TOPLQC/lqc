//package com.wnxy.day11.interfaceDemo;
//
//public class SquarePrinter {
//    public static void printSquare(SquarePattern person, int size) {
//        char[] pattern = person.getPattern(size);
//        if (pattern == null || pattern.length != size) {
//            System.out.println("Invalid pattern or size.");
//            return;
//        }
//
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                System.out.print(pattern[i]);
//            }
//            System.out.println();
//        }
//    }
//    public static void main(String[] args) {
//        SquarePattern personD = new SquarePattern() {
//            @Override
//            public char[] getPattern(int size) {
//                char[] pattern = new char[size];
//                for (int i = 0; i < size; i++) {
//                    pattern[i] = (i == 1) ? '*' : '-';
//                }
//                return pattern;
//            }
//        };
//
//        printSquare(personD, 3);
//    }
//}
