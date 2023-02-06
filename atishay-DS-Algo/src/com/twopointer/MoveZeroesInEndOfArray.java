package com.twopointer;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 * TC: O(n)
 * SC:O(1)
 * Using Two pointer logic, First pointer start=0, second pointer will start from 0
 * Second pointer will check if any no. is !=0 then swap.
 * Increment Second Pointer.
 */
public class MoveZeroesInEndOfArray {
    public static void main(String[] args) {
        //int[] nums = {0, 1, 0, 3, 12};
        int[] nums = {1, 2, 3, 4, 0, 0, 0, 0, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swapNo(nums, start, i);
                start++;
            }
        }
    }

    private static void swapNo(int[] nums, int start, int index) {
        int temp = nums[start];
        nums[start] = nums[index];
        nums[index] = temp;
    }
}