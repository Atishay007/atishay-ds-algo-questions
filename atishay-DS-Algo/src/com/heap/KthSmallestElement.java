package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3; //7

        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

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
