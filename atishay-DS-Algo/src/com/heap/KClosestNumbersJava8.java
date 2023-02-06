package com.heap;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestNumbersJava8 {
    public static void main(String[] args) {
        //int arr[] = {6, 5, 3, 2, 8, 10, 9};
        //int k = 3;
        int[] arr = {5, 6, 7, 8, 9};
        int k = 3;
        int x = 7;
        KClosestNumbersJava8 closestNumber = new KClosestNumbersJava8();
        closestNumber.findKClosestNumbers(arr, x, k);
    }

    private void findKClosestNumbers(int[] arr, int x, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByKey(Comparator.reverseOrder()));

        for (int i = 0; i < arr.length; i++) {
            pq.add(new AbstractMap.SimpleEntry<>(Math.abs(arr[i] - x), arr[i]));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (pq.size() > 0) {
            System.out.print(pq.poll().getValue());
            System.out.print(" ");
        }
    }
}
