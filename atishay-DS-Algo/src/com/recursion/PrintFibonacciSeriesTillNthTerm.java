package com.recursion;

public class PrintFibonacciSeriesTillNthTerm {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(0);
        System.out.println(1);
        printFiboNacciNo(0, 1, n - 2);
    }

    private static void printFiboNacciNo(int a, int b, int n) {
        if (n < 0) {
            return;
        }
        int c = a + b;
        System.out.println(c);
        printFiboNacciNo(b, c, n - 1);
    }
}
