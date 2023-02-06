package com.arrays;

/**
 * https://leetcode.com/problems/max-consecutive-ones/description/
 * 2 Pointer
 * TC:O(n)
 * SC: O(1)
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int globalCount = 0;
        int localCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                globalCount = Math.max(globalCount, localCount);
                localCount = 0;
            } else {
                localCount++;
            }
        }
        return Math.max(globalCount, localCount);
    }
}
