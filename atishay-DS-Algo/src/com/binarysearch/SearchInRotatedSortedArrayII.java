package com.binarysearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * BinarySearch: TC: O(logn)
 */
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));

        nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        target = 3;
        System.out.println(search(nums, target));

        nums = new int[]{1, 0, 1, 1, 1};
        target = 0;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        int index = 0;
        if (nums[0] < nums[nums.length - 1]) {
            index = binarySearch(nums, 0, nums.length - 1, target);
            if (validateResult(index)) return false;
        }

        int minElemIndex = getMinimumElement(nums, 0, nums.length - 1, target);
        int targetIndex = binarySearch(nums, 0, minElemIndex - 1, target);

        if (targetIndex != -1) {
            return true;
        }

        index = binarySearch(nums, minElemIndex, nums.length - 1, target);

        return validateResult(index);
    }

    private static boolean validateResult(int index) {
        if (index < 0) {
            return false;
        }
        return true;
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
            if (nums[mid] >= nums[start]) {
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