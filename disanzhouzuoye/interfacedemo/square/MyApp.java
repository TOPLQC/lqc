package com.wnxy.disanzhouzuoye.interfacedemo.square;

public class MyApp {
    public static void main(String[] args) {

    }

    public static void printDemo() {
        Square square = new Square();
        ISymbol iSymbol = new ISymbol() {
            @Override
            public char getSymbol(int lineNumber) {
                return lineNumber % 2 == 1 ? '*' : '+';
            }
        };
        square.printSquare(5, iSymbol);
        iSymbol = new ISymbol() {
            @Override
            public char getSymbol(int lineNumber) {
                return '*';
            }
        };
        iSymbol = new ISymbol() {
            @Override
            public char getSymbol(int lineNumber) {
                return (char) (65 + lineNumber - 1);
            }
        };
        square.printSquare(5, iSymbol);
    }
}
