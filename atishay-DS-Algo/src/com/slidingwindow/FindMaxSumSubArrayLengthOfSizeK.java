package com.slidingwindow;

public class FindMaxSumSubArrayLengthOfSizeK {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 8, 2, 9, 1};
        int k = 3;
        System.out.println(findMaxSubarrayLengthWithMaxSum(nums, k));
    }

    private static int findMaxSubarrayLengthWithMaxSum(int[] nums, int k) {
        //Edge cases/Negative cases.
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int globalSum = 0;
        int localSum = 0;
        int length = 0;
        for (int i = 0; i < k; i++) {
            localSum = localSum + nums[i];
        }
        globalSum = localSum;
        length = k;

        int startIndex = 0;
        for (int i = k; i < nums.length; i++) {
            localSum = localSum - nums[startIndex];
            startIndex++;

            //Add new element of sliding window
            localSum = localSum + nums[i];

            if (globalSum < localSum) {
                globalSum = localSum;
                length = (i - startIndex) + 1;
            }
        }
        return length;
    }
}
