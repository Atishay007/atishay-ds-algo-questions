package com.arrays;

import java.util.Arrays;

public class SortStackUsingOtherStack_Array {
    public static void main(String[] args) {
        int[] arr = {5, 17, 100, 11};
        //int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(solve(arr)));
    }

    public static int[] solve(int[] A) {
        int[] arr = new int[A.length];
        int temp = 0;
        arr[0] = A[0];
        int i = 1;
        int j = 0;

        while (i < A.length && j < arr.length) {
            if (A[i] > arr[j]) {
                j++;
                arr[j] = A[i];
                A[i] = 0;
                i++;
            } else if (A[i] >= 0) {
                temp = A[i];
                A[i] = -1;
                while (j >= 0) {
                    if (arr[j] > temp) {
                        i--;
                        A[i] = arr[j];
                        arr[j] = -1;
                        j--;
                    } else {
                        j++;
                        arr[j] = temp;
                        temp = -1;
                        break;
                    }
                }

                if (j < 0) {
                    j = 0;
                    arr[j] = temp;
                    temp = -1;
                }
            } else {
                i++;
            }
        }

        return arr;
    }
}