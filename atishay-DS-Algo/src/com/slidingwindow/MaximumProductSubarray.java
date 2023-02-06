package com.slidingwindow;

//TC:O(n)
//SC:O(1)
//Pattern: Sliding window: subarray question
//Here we cover full window from left to right and from right to left.
public class MaximumProductSubarray {
    public static void main(String[] args) {
        int arr[] = {2, 3, -2, 4};
        //int[] arr = {-2, 0, -1};
        System.out.println(findMaxProductSubarray(arr));
    }

    /**
     * It is proved that answer will not be in middle.
     * Answer will always be starting from 0th to n index (left to right)
     * or
     * Answer will always be starting from nth index to 0 index (right to left)
     */
    public static int findMaxProductSubarray(int[] arr) {
        //As the question is of multiplication, so we take product as 1.
        int localP = 1;
        int globalP = Integer.MIN_VALUE;

        //One loop will be from left to right
        for (int i = 0; i < arr.length; i++) {
            localP = localP * arr[i];
            globalP = Math.max(localP, globalP);

            //Edge case for 0
            if (localP == 0) {
                localP = 1;
            }
        }

        //Second loop will be from right to left.
        localP = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            localP = localP * arr[i];
            globalP = Math.max(localP, globalP);

            //Edge case for 0
            if (localP == 0) {
                localP = 1;
            }
        }
        return globalP;
    }
}


