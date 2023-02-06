package com.binarysearch;

/*
https://leetcode.com/problems/search-insert-position/description/
TC:O(logn)
SC:O(1)

Binary Search start pointer property: If we are not able to find the element we usually return -1
index to say that no. is not present but start pointer of binary search always stop on the position/index
where that no. which is not present in array should be present. It is a very important property and concept
of Binary Search.
 */
class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3};
        int target = 2;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        return getIndex(nums, 0, nums.length - 1, target);
    }

    private static int getIndex(int[] nums, int start, int end, int target) {
        int index = -1;
        while (start <= end) {
            //To prevent int overflow
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index == -1 ? start : index;
    }
}