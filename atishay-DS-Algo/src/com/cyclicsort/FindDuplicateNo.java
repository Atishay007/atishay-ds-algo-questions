package com.cyclicsort;

/*
https://leetcode.com/problems/find-the-duplicate-number/description/
TC: O(n)
SC:O(1)
Technique:Swap Sort
 */
public class FindDuplicateNo {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int repeatedNo = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                repeatedNo = index + 1;
                break;
            } else {
                nums[index] = -Math.abs(nums[index]);
            }
        }
        return repeatedNo;
    }
}
