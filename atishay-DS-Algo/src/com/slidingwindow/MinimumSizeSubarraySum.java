package com.slidingwindow;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(nums, target));
    }

    public static int minSubArrayLen(int[] nums, int target) {
        int startIndex = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum >= target) {
                while (sum >= target) {
                    length = Math.min(length, (i - startIndex) + 1);
                    sum = sum - nums[startIndex];
                    startIndex++;
                }
            }
        }

        if (length == Integer.MAX_VALUE) {
            return 0;
        }

        return length;
    }
}
