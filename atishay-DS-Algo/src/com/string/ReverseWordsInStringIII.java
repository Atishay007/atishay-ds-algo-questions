package com.string;


import java.util.Arrays;

public class ReverseWordsInStringIII {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        char[] arr = s.toCharArray();
        int startIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                int j = i - 1;
                swap(arr, startIndex, j);
                //V# to increment.
                startIndex = i + 1;
            }
        }

        swap(arr, startIndex, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(char[] arr, int startIndex, int j) {
        for (int k = startIndex; k < j; k++, j--) {
            char tmp = arr[k];
            arr[k] = arr[j];
            arr[j] = tmp;
        }
    }
}
