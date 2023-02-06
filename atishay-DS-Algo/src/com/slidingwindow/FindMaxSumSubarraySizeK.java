package com.slidingwindow;

/**
 * https://www.geeksforgeeks.org/find-maximum-minimum-sum-subarray-size-k/
 * Sliding Window problem
 * TC:O(n), SC:O(1)
 * Consecutive means: We can't do sorting as their sequence is important.
 */
public class FindMaxSumSubarraySizeK {
    public static void main(String[] args) {
        int[] nums = {100, 200, 300, 400};
        int k = 2;
        System.out.println(getMaxSumSubarray(nums, k));

        nums = new int[]{1, 4, 2, 10, 23, 3, 1, 0, 20};
        k = 4;
        System.out.println(getMaxSumSubarray(nums, k));
    }

    private static int getMaxSumSubarray(int[] nums, int k) {
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
            globalSum = Math.max(localSum, globalSum);
        }
        return globalSum;
    }
}
