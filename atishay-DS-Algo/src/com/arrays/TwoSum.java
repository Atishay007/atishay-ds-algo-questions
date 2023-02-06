package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        int target = -3;
        int[] result = twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(final int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        //Empty array.
        int[] result = new int[2];

        for (int i = 0; i < arr.length; i++) {
            int val = target - arr[i];

            if (map.containsKey(val)) {
                result[0] = map.get(val);
                result[1] = i + 1;
                return result;
            } else {
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], i + 1);
                }
            }
        }

        return new int[0];
    }
}
