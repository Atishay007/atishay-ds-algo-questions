package com.heap;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;

        System.out.println(findTopKFrequentNumbers(words, k));
    }

    private static List<String> findTopKFrequentNumbers(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        //Map.Entry<String, Integer> this is equal to map.entrySet()
        //If values are same then we have to remove words which is lexicographically biggest.
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> (a.getValue() == b.getValue()) ? b.getKey().compareTo(a.getKey()) : b.getValue() - a.getValue());


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new LinkedList<>();
        //Add method will shift element down automatically.
        //Edge case: If freq. is same then lexicographically biggest string
        //will come on top in PQ, but as we are adding in list on 0th index
        //automatically they will be shifted down.
        while (!pq.isEmpty()) {
            result.add(0, pq.poll().getKey());
        }
        return result;
    }
}
