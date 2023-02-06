package com.arrays;

public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        System.out.println(solve(5));
    }

    public static int solve(int A) {

        if (A == 1) {
            return 1;
        }

        int[] arr = new int[(A / 2) + 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }


        int count = 1;

        int startIndex = 0;
        int sum = 0;

        for (int i = 1; i < arr.length; ) {
            if (sum > A) {
                while (sum > A) {
                    sum = sum - arr[startIndex];
                    if (sum == A) {
                        count++;
                    }
                    startIndex++;
                }
            } else {
                sum = sum + arr[i];
                if (sum == A) {
                    count++;
                }
            }
            i++;
        }

        return count;

    }
}
