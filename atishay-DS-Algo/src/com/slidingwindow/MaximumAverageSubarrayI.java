package com.slidingwindow;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/description/
 * Using Sliding window pattern
 * Window size is
 * TC:O(n)
 * SC:O(1)
 */
public class MaximumAverageSubarrayI {


    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }

    private static double findMaxAverage(int[] nums, int k) {
        double localsum = 0;
        double globalSum = 0;

        for (int i = 0; i < k; i++) {
            localsum = localsum + nums[i];
        }

        //First k no. avg.
        globalSum = localsum / k;

        int startIndex = 0;
        for (int i = k; i < nums.length; i++) {
            //Removing last window element.
            localsum = localsum - nums[startIndex];
            startIndex++;
            localsum = localsum + nums[i];

            //Comparison after adding new element appeared in sliding window.
            globalSum = Math.max(globalSum, (localsum) / k);
        }
        return globalSum;
    }
}