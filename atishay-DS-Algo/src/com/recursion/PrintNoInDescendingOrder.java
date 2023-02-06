package com.recursion;

public class PrintNoInDescendingOrder {
    public static void main(String[] args) {
        printNo(5);
    }

    private static void printNo(int no) {
        //Base condition where recursion will break.
        if (no == 0) {
            return;
        }
        System.out.println(no);
        printNo(no-1);
    }
}
