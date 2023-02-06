package com.arrays;

import java.util.Arrays;

public class SubArrayWithKSumNonNegative {
    public static void main(String[] args) {
        //  int[] arr = {1, 4, 20, 3, 10, 5};
        //int sum = 33;

        //int[] arr = {1, 4, 0, 0, 3, 10, 5};
        //int sum = 7;

        //startIndex should be smaller than end index.
        //As Subarray need 2 index, 1 start and 1 end index.
        int[] arr = {1, 4};
        int sum = 0;

        System.out.println(Arrays.toString(findSubArrayWithGivenSum(arr, sum)));
    }

    private static int[] findSubArrayWithGivenSum(int[] arr, int sum) {

        int totalSum = 0;
        int starIndex = 0;
        int[] result = new int[0];

        for (int i = 0; i < arr.length; i++) {
            totalSum = totalSum + arr[i];

            if (totalSum > sum) {
                while (totalSum > sum) {
                    totalSum = totalSum - arr[starIndex];
                    starIndex++;
                }
            }

            if (totalSum == sum && starIndex <= i) {
                result = new int[2];
                result[0] = starIndex;
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
