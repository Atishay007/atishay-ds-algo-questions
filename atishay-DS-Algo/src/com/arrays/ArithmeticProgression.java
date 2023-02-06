package com.arrays;

public class ArithmeticProgression {
    public static void main(String[] args) {
        //formula a+(n-1)d
        int[] arr = {3, 5, 1};

        int minDiff = arr[0] - arr[1];

        for (int i = 0; i < arr.length; i++) {
            //a+(n-1)d
            int diff = 3 + (i - 1) * minDiff;
            System.out.println(diff);
        }
    }
}
