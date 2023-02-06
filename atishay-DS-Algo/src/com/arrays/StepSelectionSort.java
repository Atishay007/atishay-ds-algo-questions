package com.arrays;

import java.util.Arrays;

public class StepSelectionSort {
    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 2, 8};
        System.out.println(Arrays.toString(solve(arr)));
    }

    public static int[] solve(int[] arr) {

        int[] resultArr = new int[arr.length - 1];

        //No need to go till last element as it is sorted when ith index is on second last
        for (int i = 0; i < arr.length - 1; i++) {
            //Assuming current ith index value is the minimum.
            int minNoIndex = i;
            int j = i + 1;

            for (; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    minNoIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minNoIndex];
            arr[minNoIndex] = temp;

            resultArr[i] = minNoIndex;
        }

        return resultArr;
    }
}
