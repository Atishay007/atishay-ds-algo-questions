package com.recursion;

public class PrintSumOfFirstNNaturalNo {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(printSumOfNNaturalNos(n));
    }

    private static int printSumOfNNaturalNos(int n) {
        //base condition
        if (n == 0) {
            return n;
        }
        //Here we have assumed that printSumOfNNaturalNos(n - 1); will give sum from 9..0 and then we will add 10 in that
        return n + printSumOfNNaturalNos(n - 1);
    }
}
