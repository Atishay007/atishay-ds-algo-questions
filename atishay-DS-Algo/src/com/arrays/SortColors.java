package com.arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 * TC:O(n)
 * SC: O(1) --> Populating result in same array.
 */
class SortColors {

    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (count0 > 0) {
                nums[i] = 0;
                count0--;
            } else if (count1 > 0) {
                nums[i] = 1;
                count1--;
            } else if (count2 > 0) {
                nums[i] = 2;
                count2--;
            }
        }
    }
}