package com.slidingwindow;

//TC:O(n)
//SC:O(1)
//Pattern: Sliding window: subarray question
public class SmallestSubarrayWithSumGreaterThanX {
    public static void main(String[] args) {
        //int[] arr = {1, 4, 45, 6, 0, 19};
        //int x = 51;

        int arr[] = {1, 10, 5, 2, 7};
        int x = 9;
        System.out.println(smallestSubArrayWithSumGreaterThanX(arr, x));
    }


    public static int smallestSubArrayWithSumGreaterThanX(int arr[], int x) {
        int startIndex = 0;
        int length = Integer.MAX_VALUE;
        int localSum = 0;

        for (int i = 0; i < arr.length; i++) {
            localSum = localSum + arr[i];

            if (localSum > x) {
                while (localSum > x) {
                    int newLength = (i - startIndex) + 1;
                    if (newLength < length) {
                        length = newLength;
                    }
                    localSum = localSum - arr[startIndex];
                    startIndex++;
                }
            }
        }
        return length;
    }
}


