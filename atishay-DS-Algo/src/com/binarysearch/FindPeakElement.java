package com.binarysearch;

/**
 * https://leetcode.com/problems/find-peak-element/description/
 * TC:O(logn)
 * SC:O(1)
 * This logic is used in: https://afteracademy.com/blog/find-an-element-in-a-bitonic-array/
 * find-an-element-in-a-bitonic-array/ Question
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(getPeakElementIndex(nums, 0, nums.length - 1));

        nums = new int[]{1, 2, 3, 1};
        System.out.println(getPeakElementIndex(nums, 0, nums.length - 1));

        //Edge case
        nums = new int[]{1, 2};
        System.out.println(getPeakElementIndex(nums, 0, nums.length - 1));

        //Edge case
        nums = new int[]{2, 1};
        System.out.println(getPeakElementIndex(nums, 0, nums.length - 1));

        //Edge case
        nums = new int[]{1};
        System.out.println(getPeakElementIndex(nums, 0, nums.length - 1));
    }

    private static int getPeakElementIndex(int[] nums, int start, int end) {
        //Edge case
        if (nums.length == 1) {
            return 0;
        }
        while (start <= end) {
            //To prevent int overflow
            int mid = start + (end - start) / 2;

            if (mid == 0 && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid == nums.length - 1 && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
