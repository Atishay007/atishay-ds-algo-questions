package com.cyclicsort;

//https://leetcode.com/problems/missing-number/
//No. are unique and are from 0 to n, that is why we used sum of n natural nos formula
public class MissingNumber {

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int sum = (nums.length * (nums.length + 1)) / 2;

        for (int i = 0; i < nums.length; i++) {
            sum = sum - nums[i];
        }

        //missing no.
        return sum;
    }
}
