package com.arrays;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};

        for (int i = 0; i < nums.length; i++) {

            int index = Math.abs(nums[i]);

            if (nums[index] < 0) {
                System.out.println(Math.abs(nums[i]));
                break;
            } else {
                nums[index] = -Math.abs(nums[index]);
            }
        }
    }
}
