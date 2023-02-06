package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSumK {
    public static void main(String[] args) {
        //int[] nums = {4, 3, 5, 7, 8};
        //   int k = 12;

        int[] nums = {1, 2, 3, 4};
        int k = 15;
        System.out.println(Arrays.toString(subarraySum(nums, k)));
    }

    public static int[] subarraySum(int[] arr, int k) {
        int prefixSum = 0;
        int[] result = {-1, -1};

        Map<Integer, Integer> map = new HashMap<>();

        //Staring prefix sum =0
        map.put(prefixSum, 0);

        for (int i = 0; i < arr.length; i++) {

            prefixSum = prefixSum + arr[i];

            int target = prefixSum - k;

            if (!map.containsKey(target)) {
                map.put(prefixSum, map.getOrDefault(prefixSum, i) + 1);
            } else {
                result = new int[2];
                int startIndex = map.get(target);
                if (startIndex != 0) {
                    result[0] = startIndex - 1;
                } else {
                    result[0] = startIndex;
                }
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
