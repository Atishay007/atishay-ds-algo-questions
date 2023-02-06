package com.arrays;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 1, 2, 3};
        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < arr.length; i++) {
            rightSum = rightSum + arr[i];
        }

        //Edge case for 0th index
        if (leftSum == (rightSum - arr[0])) {
            return 0;
        }

        for (int i = 1; i < arr.length; i++) {
            leftSum = leftSum + arr[i - 1];

            if (leftSum == (rightSum - (leftSum + arr[i]))) {
                return i;
            }
        }

        return -1;
    }
}