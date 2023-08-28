package com.wnxy.day11.println;


import java.util.function.Function;

public class Application {
    public static void main(String[] args) {

        {
            Println println = new Println();
            Function<Integer, Character> function = lien -> lien % 2 == 1 ? '*' : '-';
            println.printlnSquare(5, function);
        }
        {
            Println println = new Println();
            Function<Integer, Character> function = lien -> '-';
            println.printlnSquare(8, function);
        }

        {
            Println println = new Println();
            Function<Integer, Character> function = lien -> (char) (65 + lien - 1);
            println.printlnSquare(5, function);
        }
    }
}