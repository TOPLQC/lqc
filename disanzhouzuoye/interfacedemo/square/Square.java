package com.wnxy.disanzhouzuoye.interfacedemo.square;

public class Square {
    public void printSquare(int line, ISymbol iSymbol) {
        for (int i = 1; i <= line; i++) {
            for (int j = 1; j <= line; j++) {
                System.out.printf("%s  ", iSymbol.getSymbol(i));
            }
            System.out.println();
        }
    }
}
