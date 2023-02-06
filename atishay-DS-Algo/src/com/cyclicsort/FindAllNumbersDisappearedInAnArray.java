package com.cyclicsort;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the
integers in the range [1, n] that do not appear in nums.
 */
public class FindAllNumbersDisappearedInAnArray {

    //TC:O(n)
    //SC:O(1)
    //Can't use sum of natural no. formula as array have duplicate no.
    //We can use  sum of natural no. formula where no are unique and we have to find missing no.
    //Here, no. are from 1 to n, and we are playing with index here, so 0 index will not be consider.
    //We are getting output on basis of index which are acting as no.
    //Edge case if disappeared no. not present in array at all. [1,1] -> output 2
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        //edge case: [1,1]
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) == nums.length) {
                continue;
            }

            int tmpIndex = Math.abs(nums[i]);
            nums[tmpIndex] = -Math.abs(nums[tmpIndex]);
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i);
            }
        }

        if (result.size() > 0) {
            return result;
        }

        result.add(nums.length);

        return result;
    }
}