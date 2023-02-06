package com.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindPairSum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 1};
        System.out.println(getPairsCount(arr, 6));
    }

    private static int getPairsCount(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int value = k - arr[i];

            if (!map.containsKey(value)) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            } else {
                count = count + map.get(value);
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
        }

        return count;
    }
}
