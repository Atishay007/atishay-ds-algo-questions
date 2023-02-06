package com.arrays;

public class PickFromBothSidesWithPrefixSum {
    public static void main(String[] args) {
        int[] nums = {96, 90, 41, 82, 39, 74, 64, 50, 30};
        int B = 8;
        System.out.println(solve(nums, B));
    }

    public static int solve(int[] nums, int B) {
        //populating prefixSumArray
        int[] prefixSumArr = new int[nums.length];
        prefixSumArr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSumArr[i] = prefixSumArr[i - 1] + nums[i];
        }

        //populating suffixSumArray
        int[] suffixSumArr = new int[nums.length];
        suffixSumArr[suffixSumArr.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixSumArr[i] = suffixSumArr[i + 1] + nums[i];
        }

        int prefixSum = 0;
        int suffixSum = 0;
        //1. Taking sum of all nos from left.
        int maxSum = prefixSumArr[B - 1];
        /*finding max sum
        2. Taking all no from left.
        3. Taking 1 no. from left and b-i no from right.
        In this way we have to take all nos.
         */
        for (int i = 0; i < B; i++) {
            if (i != 0) {
                prefixSum = prefixSumArr[i - 1];
            }
            suffixSum = suffixSumArr[nums.length - (B - i)];
            maxSum = Math.max(maxSum, prefixSum + suffixSum);
        }
        return maxSum;
    }
}
