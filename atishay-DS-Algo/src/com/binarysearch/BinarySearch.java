package com.binarysearch;

//TC:O(logn)
//https://leetcode.com/problems/binary-search/description/
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(getIndex(nums, 0, nums.length - 1, target));
    }

    private static int getIndex(int[] nums, int start, int end, int target) {
        while (start <= end) {
            //To prevent int overflow
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }

        return -1;
    }
}
