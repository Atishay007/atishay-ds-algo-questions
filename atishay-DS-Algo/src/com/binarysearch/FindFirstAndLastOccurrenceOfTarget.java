package com.binarysearch;

import java.util.Arrays;

/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
TC:O(logn)
SC:O(1)
Edge case: 8 appear only once at certain index lets say 2nd index,result--> (2,2)

 */
public class FindFirstAndLastOccurrenceOfTarget {
    public static void main(String[] args) {
        long no = 1011010;
        //Edge case there can be only 1 element.
        //int[] nums = {2, 4, 10, 10, 10, 18, 20};
        int[] nums = {2, 4, 8, 9};
        int target = 2;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        if (nums == null) {
            return null;
        }

        int index = getOccurrence(nums, 0, nums.length - 1, target, true);
        if (index == -1) {
            return result;
        }
        result[0] = index;
        index = getOccurrence(nums, index, nums.length - 1, target, false);
        result[1] = index;

        return result;
    }

    private static int getOccurrence(int[] nums, int start, int end, int target, boolean findStart) {
        int index = -1;

        while (start <= end) {
            //To prevent int overflow
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                index = mid;
                if (findStart) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }
}