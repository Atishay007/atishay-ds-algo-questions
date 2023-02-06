package com.arrays;

import java.util.Arrays;

public class MinSwapsToSort {
    public static void main(String[] args) {
        int[] arr = {7, 16, 14, 17, 6, 9, 5, 3, 18};
        System.out.println(minSwaps(arr));
    }

    //Function to find the minimum number of swaps required to sort the array.
    public static int minSwaps(int nums[]) {

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 0;
        }

        int count = 0;
        int[] nums2 = Arrays.copyOf(nums, nums.length);

        //Sort the array
        Arrays.sort(nums2);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums2[i]) {
                int index = Arrays.binarySearch(nums, 0, nums.length, nums2[i]);
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                count++;
            }
        }

        return count;
    }
}
