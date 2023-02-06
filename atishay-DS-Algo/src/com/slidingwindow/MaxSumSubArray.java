package com.slidingwindow;

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 * Famous: Kadane's Algo
 * TC:O(n)
 * SC:O(1)
 */
public class MaxSumSubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findMaxSumSubArray(nums));
    }

    public static int findMaxSumSubArray(int[] nums) {
        //Edge case
        if (nums.length == 1) {
            return nums[0];
        }

        int localSum = nums[0];
        int globalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= (nums[i] + localSum)) {
                localSum = nums[i];
            } else {
                localSum = nums[i] + localSum;
            }
            globalSum = Math.max(localSum, globalSum);
        }
        return globalSum;
    }
}