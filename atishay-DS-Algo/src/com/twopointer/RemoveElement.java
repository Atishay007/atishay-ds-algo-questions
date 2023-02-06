package com.twopointer;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-element/description/
 *
 * TC: O(n)
 * SC: O(1)
 * Two Pointer
 * We are using logic of "Move zeroes in front question: where we have to start loop from end"
 *
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(removeElement(nums, val));
    }

    private static int removeElement(int[] nums, int val) {
        int count = 0;
      //  Arrays.sort(nums);

        int startIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
                int tmp = nums[i];
                nums[i] = nums[startIndex];
                nums[startIndex] = tmp;
                startIndex--;
                count++;
            }
        }
        return (nums.length - count);
    }
}
