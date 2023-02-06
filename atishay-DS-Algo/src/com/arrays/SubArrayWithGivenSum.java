package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] nums = {5, 10, 20, 100, 105};
        int target = 110;
        System.out.println(Arrays.toString(findSubArray(nums, target)));
    }

    private static int[] findSubArray(int[] nums, int target) {
        if (nums.length == 1 && nums[0] != target) {
            return new int[]{-1};
        }

        int sum = 0;
        int startIndex = 0;
        List<Integer> lst = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (sum == target) {
                break;
            }

            sum = sum + nums[i];
            lst.add(nums[i]);

            if (sum > target) {
                while (sum > target) {
                    sum = sum - nums[startIndex];
                    if (lst.size() > 0 && startIndex < nums.length) {
                        //After removing element in
                        lst.remove(0);
                    }
                    startIndex++;
                }
            }
        }

        if (sum == target) {
            int[] arr = new int[lst.size()];

            for (int i = 0; i < lst.size(); i++) {
                arr[i] = lst.get(i);
            }
            return arr;
        }

        return new int[]{-1};
    }
}
