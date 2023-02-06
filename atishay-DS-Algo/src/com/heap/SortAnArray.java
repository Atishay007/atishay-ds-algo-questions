package com.heap;

import java.util.PriorityQueue;

public class SortAnArray {
    public static void main(String[] args) {
        //Ascending order
        //O(nlogk)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //  int[] nums = {5, 2, 3, 1};
        int[] nums = {5, 1, 1, 2, 0, 0};

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        while (pq.size() > 0) {
            System.out.println(pq.poll());
        }
    }
}
