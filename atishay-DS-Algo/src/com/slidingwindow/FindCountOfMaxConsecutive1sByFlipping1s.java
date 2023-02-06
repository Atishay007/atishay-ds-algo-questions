package com.slidingwindow;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 * TC:O(n)
 * SC:O(n)
 * <p>
 * Sliding Window Pattern
 */
public class FindCountOfMaxConsecutive1sByFlipping1s {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, k));

        nums = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        k = 3;
        System.out.println(longestOnes(nums, k));
    }

    public static int longestOnes(int[] nums, int k) {
        //window size
        int windowSize = k;

        int startIndex = 0;
        int globalCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                windowSize--;
            }

            //Slide window
            while (windowSize < 0) {
                if (nums[startIndex] == 0) {
                    windowSize++;
                }
                startIndex++;
            }

            globalCount = Math.max((i - startIndex) + 1, globalCount);
        }

        return globalCount;
    }
}
