package com.heap;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestNumbers {
    public static void main(String[] args) {
        //int arr[] = {6, 5, 3, 2, 8, 10, 9};
        //int k = 3;
        int[] arr = {5, 6, 7, 8, 9};
        int k = 3;
        int x = 7;
        KClosestNumbers closestNumber = new KClosestNumbers();
        closestNumber.findKClosestNumbers(arr, x, k);
    }

    private void findKClosestNumbers(int[] arr, int x, int k) {
        PriorityQueue<Entry> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(new Entry(Math.abs(arr[i] - x), arr[i]));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (pq.size() > 0) {
            System.out.println(pq.poll().getValue());
        }
    }

    private class Entry implements Comparable<Entry> {
        private int key;
        private int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Entry other) {
            //Descending sorting
            return other.getKey() - this.getKey();
        }
    }
}
