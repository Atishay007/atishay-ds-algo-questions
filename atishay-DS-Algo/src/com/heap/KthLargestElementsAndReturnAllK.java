package com.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementsAndReturnAllK {
    public static void main(String[] args) {
        int[] arr = {12, 5, 787, 1, 23};
        int k = 2; //

        Queue<Integer> queue = new PriorityQueue<>();

        //Smallest K so we have to create MaxHeap so that we can pop large elements out.
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = queue.stream().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(result));
    }
}
