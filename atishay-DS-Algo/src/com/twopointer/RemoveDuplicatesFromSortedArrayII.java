package com.twopointer;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
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
class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{1, 1};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{2, 2, 2, 2, 2};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{0, 0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{1, 1, 1, 3, 5, 5, 7};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{2, 3, 4, 4, 5, 6, 6, 6, 8, 8};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int start = 0;
        int end = start + 1;
        while (end < nums.length) {
            if (nums[end] != nums[start]) {
                if (nums[start] == nums[start + 1]) {
                    start = start + 2;
                } else {
                    start = start + 1;
                }
                swap(nums, start, end);
            } else {
                /*
                This else will execute when start and end index have same no.
                if there is different no. betweeen start and end index but start have to check whether it
                has duplicate no. behind or not as atmost 2 duplicate no. can be present, there is a chance that
                start-1 is already duplicate with start so we have to search for different no. that nums[start]
                 */

                if (start > 0 && nums[start - 1] != nums[start] && nums[start + 1] != nums[end]) {
                    swap(nums, ++start, end);
                }
            }
            end++;
        }

        System.out.println(Arrays.toString(nums));
        /*
        We have to check if start+1 index is also same as start index then we have to include it.
        As start index moves only when it found some different no, otherwise it remains behind the
        duplicate no.
        But in this question at most 2 duplicates are allowed.
         */
        if ((start + 1) < nums.length && nums[start] == nums[start + 1]) {
            start++;
        }
        //Index starts from 0 but we have to return how many no. are unique.
        return start + 1;
    }

    private static void swap(int[] nums, int start, int end) {
        if (start != end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}
