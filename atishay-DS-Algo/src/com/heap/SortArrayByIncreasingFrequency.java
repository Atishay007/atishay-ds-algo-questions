package com.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};

        sortArrayByIncreasingFreq(nums);
    }

    private static void sortArrayByIncreasingFreq(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //First decide which Heap we want. Here we want MinHeap.
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>
                ((a, b) -> (a.getValue() == b.getValue()) ? b.getKey() - a.getKey() : a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }


        int j = 0;
        while (pq.size() > 0) {
            Map.Entry<Integer, Integer> entry = pq.poll();

            for (int i = 0; i < entry.getValue(); i++) {
                nums[j] = entry.getKey();
                j++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
