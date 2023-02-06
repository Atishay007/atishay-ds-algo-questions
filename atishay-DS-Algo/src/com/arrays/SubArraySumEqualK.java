package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualK {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 7, 8};
        int k = 12;
        System.out.println(solve(arr, k));
    }

    public static int solve(int[] arr, int k) {

        int prefixSum = 0;
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();

        //Staring prefix sum =0
        map.put(prefixSum, 1);

        for (int i = 0; i < arr.length; i++) {

            prefixSum = prefixSum + arr[i];

            int target = prefixSum - k;

            if (!map.containsKey(target)) {
                map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
            } else {
                result = result + map.get(target);
                map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
            }
        }
        return result;
    }
}
