package com.prefix;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * TC:O(n)
 * SC:O(n)
 * <p>
 * Using Prefix product array
 * Result array don't count in extra space
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

        nums = new int[]{-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));


        nums = new int[]{-1, 2};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] postFix = new int[nums.length];

        postFix[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            postFix[i] = nums[i] * postFix[i + 1];
        }

        //This will hold the prefix multiplication of previous no.
        int prefix = nums[0];
        result[0] = postFix[1];

        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = prefix * postFix[i + 1];
            prefix = prefix * nums[i];
        }

        //For last index
        result[result.length - 1] = prefix;
        return result;
    }
}
