package com.recursion;

//Following IBH method: Induction Base condition and Hypothesis
public class PrintNInAscendingOrder {
    public static void main(String[] args) {
        int n = 7;

        printNoInAscendingOrder(n);
    }

    private static void printNoInAscendingOrder(int n) {
        //Base condition
        if (n == 0) {
            return;
        }

        printNoInAscendingOrder(n - 1);

        //Induction condition or business logic
        System.out.println(n);
    }
}
