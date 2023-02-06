package com.cyclicsort;

import java.util.Arrays;

/*
TC: O(N)
SC:O(1)
Asked in Egnyte interview
Given a non-empty unsorted array taken from a range of 11 to nn. Due to some data error, one of the numbers is duplicated,
which results in another number missing.
Create a function that returns the corrupt pair (missing, duplicate).

Range from 1 to 6

Inp = [4,1,2,1,6,3]
Op = [5,1]
 */
public class FindMissingAndDuplicateNo {
    public static void main(String[] args) {
        //Find Duplicate and missing no.
        int[] nums = {4, 1, 2, 1, 6, 3};
        System.out.println(Arrays.toString(findCorruptPair(nums)));
    }

    public static int[] findCorruptPair(int[] nums) {
        int[] result = new int[2];
        //Duplicate no.
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] < 0) {
                result[0] = index + 1;
            } else {
                nums[index] = -Math.abs(nums[index]);
            }
        }

        //Missing no.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[1] = i + 1;
                break;
            }
        }
        return result;
    }
}