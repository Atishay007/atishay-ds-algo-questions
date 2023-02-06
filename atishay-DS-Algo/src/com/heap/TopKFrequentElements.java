package com.heap;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;

        System.out.println(Arrays.toString(findTopKFrequentNumbers(arr, k)));
    }

    private static int[] findTopKFrequentNumbers(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());

        for (int key : map.keySet()) {
            pq.add(new AbstractMap.SimpleEntry<>(key, map.get(key)));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.stream().mapToInt(a -> a.getKey()).toArray();
    }
}
