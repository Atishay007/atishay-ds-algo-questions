package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNo {

    public static void main(String[] args) {
        //  int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};

        int[] nums = {1, 1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -Math.abs(nums[index]);

        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                result.add(i + 1);
            }

        }


        return result;
    }
}
