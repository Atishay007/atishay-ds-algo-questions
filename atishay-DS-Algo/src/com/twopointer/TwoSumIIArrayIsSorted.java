package com.twopointer;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * TC:O(n)
 * SC:O(1)
 */
public class TwoSumIIArrayIsSorted {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(getIndexes(nums, target)));
    }

    private static int[] getIndexes(int[] nums, int target) {
        int end = nums.length - 1;
        int[] result = new int[2];
        int start = 0;

        while (start < end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                /*if we write this condition in if on top of all conditions
                then the loop is taking 60ms if we write below code here in else
                then it is taking 1ms.
                */
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }
        }
        return result;
    }
}
