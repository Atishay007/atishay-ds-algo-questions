package com.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;

        Queue<Integer> queue = new PriorityQueue<>();

        //Smallest K so we have to create MaxHeap so that we can pop large elements out.
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        System.out.println(queue.poll());
    }
}
