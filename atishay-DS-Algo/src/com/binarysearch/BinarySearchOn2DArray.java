package com.binarysearch;

/*
TC:O(logn)
https://leetcode.com/problems/binary-search/description/
 */
public class BinarySearchOn2DArray {
    public static void main(String[] args) {
        // int[][] nums = {{1, 3}, {6, 9}};
        int[][] nums = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int target = 4;
        System.out.println(getIndex(nums, 0, nums.length - 1, target));
    }

    private static int getIndex(int[][] nums, int start, int end, int target) {
        while (start <= end) {
            //To prevent int overflow.
            int mid = start + (end - start) / 2;

            if (nums[mid][0] == target) {
                return mid;
            } else if (nums[mid][0] > target) {
                end = mid - 1;
            } else if (nums[mid][0] < target) {
                start = mid + 1;
            }
        }
        /*
            Binary Search has this property that if we can't find the target
            Then the start position or index will always return the insertion point
            where that value should be present.
         */
        return start;
    }
}
