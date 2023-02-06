package com.twopointer;

import java.util.Arrays;

/**
 * https://www.educative.io/courses/coderust-hacking-the-coding-interview/k58JJ
 * TC: O(n)
 * SC:O(1)
 * Using Two pointer logic, both pointer will start from end.
 * Second pointer will check if any no. is !=0 then swap.
 * Decrement Second pointer
 */
public class MoveZeroesInFrontOfArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        // int[] nums = {1, 2, 3, 4, 0, 0, 0, 0, 0};
        System.out.println("Original array: " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int start = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                swapNo(nums, start, i);
                start--;
            }
        }
    }

    private static void swapNo(int[] nums, int start, int index) {
        int temp = nums[start];
        nums[start] = nums[index];
        nums[index] = temp;
    }
}