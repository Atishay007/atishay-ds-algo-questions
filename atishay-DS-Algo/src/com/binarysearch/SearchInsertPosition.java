package com.binarysearch;

/*
https://leetcode.com/problems/search-insert-position/description/
TC:O(logn)
SC:O(1)

Array is sorted here:

Binary Search start pointer property: If we are not able to find the element we usually return -1
index to say that no. is not present but start pointer of binary search always stop on the position/index
where that no. should be present in array. It is a very important property and concept
of Binary Search.

This is a good way to find where we have to insert new no. in sorted array.
Also, this can handle negative and positive no.

V##: nums contains distinct values sorted in ascending order.
 */
class SearchInsertPosition {
    public static void main(String[] args) {
        //Nums should be in ascending order only, given in q.
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(searchInsert(nums, target));

        //Descending order don't work, then we have to change code.
        nums = new int[]{-5, -4, -2};
        target = -3;
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
