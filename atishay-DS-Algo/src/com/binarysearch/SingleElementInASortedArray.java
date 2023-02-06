package com.binarysearch;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
 * We can do this question using XOR but that will be TC:O(n)
 * Question has specified that we have to solve this problem in O(logn) means binary search
 * as the whole array is sorted.
 * <p>
 * We have to use index property of repeated no. if mid is not on first sequence of repeated no.
 * then point mid to the first seq.
 * <p>
 * First element of each pair will be on even index before unique no. Go to right
 * First element of each pair will be on odd index before unique no. Go to left
 */
public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int result = getUniqueNoUsingBinarySearch(nums, 0, nums.length - 1);
        System.out.println(result);

        nums = new int[]{3, 3, 7, 7, 10, 11, 11};
        result = getUniqueNoUsingBinarySearch(nums, 0, nums.length - 1);
        System.out.println(result);

        nums = new int[]{3};
        result = getUniqueNoUsingBinarySearch(nums, 0, nums.length - 1);
        System.out.println(result);

        nums = new int[]{1, 3, 3};
        result = getUniqueNoUsingBinarySearch(nums, 0, nums.length - 1);
        System.out.println(result);
    }

    private static int getUniqueNoUsingBinarySearch(int[] nums, int start, int end) {
        //Edge case
        if (nums.length == 1) {
            return nums[0];
        }

        int index = -1;
        while (start <= end) {
            //Prevent int overflow
            int mid = start + (end - start) / 2;
            /*
            We have to compare first sequence of repeated no. if it is not on first sequence index
            then bring it on first seq. index.
            We have to keep discarding left or right part to get that unique no.
             */

            //mid should be >0
            if (mid > 0 && nums[mid] == nums[mid - 1]) {
                mid = mid - 1;
            }

            if (mid == 0 && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            /*
            If first sequence of repeated no. is at even index then we will get unique no. on right side.
            Discard left side
             */
            else if ((mid & 1) == 0) {
                //Go to right, discard all left elements.
                //We have to increase by 2 as the next is also same no.
                start = mid + 2;
            } else {/*
            If first sequence of repeated no. is at odd index then we will get unique no. on left side.
            Discard left side
             */
                end = mid - 1;
            }
        }
        return index;
    }
}
