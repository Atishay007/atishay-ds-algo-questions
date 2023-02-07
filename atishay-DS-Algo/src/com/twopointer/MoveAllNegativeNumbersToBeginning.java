package com.twopointer;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
 * TC:O(n)
 * SC:O(1)
 * Two Pointer
 */
public class MoveAllNegativeNumbersToBeginning {
    public static void main(String[] args) {
        int[] nums = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = nums[startIndex];
                nums[startIndex] = nums[i];
                nums[i] = tmp;
                startIndex++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
