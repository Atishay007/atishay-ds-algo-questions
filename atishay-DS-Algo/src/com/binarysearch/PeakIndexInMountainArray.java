package com.binarysearch;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 * TC:O(logn)
 * SC:O(1)
 * This logic is used in: https://afteracademy.com/blog/find-an-element-in-a-bitonic-array/
 * Similar q: https://leetcode.com/problems/find-peak-element/description/
 */
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0};
        System.out.println(getPeakIndex(nums, 0, nums.length - 1));

        nums = new int[]{0, 2, 1, 0};
        System.out.println(getPeakIndex(nums, 0, nums.length - 1));

        nums = new int[]{0, 10, 5, 2};
        System.out.println(getPeakIndex(nums, 0, nums.length - 1));

        nums = new int[]{0, 10, 80, 90, 70, 60};
        System.out.println(getPeakIndex(nums, 0, nums.length - 1));

    }

    private static int getPeakIndex(int[] nums, int start, int end) {
        while (start <= end) {
            //To prevent int overflow
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
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
