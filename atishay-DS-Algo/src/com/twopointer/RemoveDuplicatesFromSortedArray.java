package com.twopointer;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * TC:O(n)
 * SC:O(1)
 * <p>
 * Using 2 pointer technique, where first pointer is start and second is end.
 * Whenever the value is != then we will replace of ++start index with end.
 * Keep incrementing end if the value is same or different.
 * <p>
 * As we can't use extra space which means no data structure can be used.
 * As the array is sorted so 2 options
 * 1. 2 or 3 pointer or 2. Binary Search
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int start = 0;
        int end = start + 1;
        while (end < nums.length) {
            if (nums[end] != nums[start]) {
                start = start + 1;
                swap(nums, start, end);
            }
            end++;
        }
        //Index starts from 0 but we have to return how many no. are unique.
        return start + 1;
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}