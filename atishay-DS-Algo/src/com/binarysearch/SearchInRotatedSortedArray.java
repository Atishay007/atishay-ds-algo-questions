package com.binarysearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * BinarySearch: TC: O(logn)
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));

        nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        target = 3;
        System.out.println(search(nums, target));

        nums = new int[]{1};
        target = 0;
        System.out.println(search(nums, target));

        nums = new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3};
        target = 3;
        System.out.println(search(nums, target));

        nums = new int[]{10, 1, 2, 3, 5, 6, 7, 8, 9};
        target = 3;
        System.out.println(search(nums, target));

        nums = new int[]{3, 1};
        target = 1;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {

        if (nums[0] < nums[nums.length - 1]) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        int minElemIndex = getMinimumElement(nums, 0, nums.length - 1, target);

        int targetIndex = binarySearch(nums, 0, minElemIndex - 1, target);

        if (targetIndex != -1) {
            return targetIndex;
        }

        return binarySearch(nums, minElemIndex, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        int index = -1;
        while (start <= end) {
            //To prevent int overflow
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return index;
    }

    private static int getMinimumElement(int[] nums, int start, int end, int target) {
        int index = 0;
        int minElement = Integer.MAX_VALUE;
        while (start <= end) {
            //To prevent int overflow
            int mid = start + (end - start) / 2;

            //{3,1} --> here mid =0 so we have to use >=
            if (nums[mid] >= nums[0]) {
                start = mid + 1;
            } else {
                if (minElement > nums[mid]) {
                    minElement = nums[mid];
                    index = mid;
                }
                end = mid - 1;
            }
        }
        return index;
    }
}