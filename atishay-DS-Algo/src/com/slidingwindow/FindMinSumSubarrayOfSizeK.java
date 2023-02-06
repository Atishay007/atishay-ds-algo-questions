package com.slidingwindow;

/**
 * https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/
 * Sliding Window problem
 * TC:O(n), SC:O(1)
 * Consecutive means: We can't do sorting as their sequence is important.
 */
public class FindMinSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int nums[] = {100, 200, 300, 400};
        int k = 1;

        //int arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        //int k = 4;

        //int arr[] = {2, 3};
        //int k = 3;
        System.out.println(getMinSumSubarray(nums, k));
    }

    private static int getMinSumSubarray(int[] nums, int k) {
        //Edge case
        if (nums.length == 1) {
            return 1;
        }
        int globalSum = 0;
        int localSum = 0;
        int length = 0;
        for (int i = 0; i < k; i++) {
            localSum = localSum + nums[i];
        }

        globalSum = localSum;

        int startIndex = 0;
        for (int i = k; i < nums.length; i++) {
            localSum = localSum - nums[startIndex];
            startIndex++;

            //Add new element of sliding window
            localSum = localSum + nums[i];

            //Get max sum
            globalSum = Math.min(localSum, globalSum);
        }
        return globalSum;
    }
}
