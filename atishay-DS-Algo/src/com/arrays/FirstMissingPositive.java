package com.arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        // int[] nums = {-2};
        //int[] nums = {1, 2, 0};
        //int[] nums = {3, 4, -1, 1};
        // int[] nums = {7, 8, 9, 11, 12};
        // int[] nums = {2, 1};
        //int[] nums = {-1, -2};
        int[] nums = {-1, 4, 2, 1, 9, 10};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        //Making array positive
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums.length) {
                nums[i] = 0;
            } else {
                int tmp = Math.abs(nums[i]) - 1;
                if (tmp >= 0) {
                    int value = nums[tmp];

                    if (value == 0) {
                        nums[tmp] = -Math.abs(nums[i]);
                    } else {
                        nums[tmp] = -Math.abs(nums[tmp]);
                    }
                }
            }
        }

        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }
        return i + 1;

    }
}