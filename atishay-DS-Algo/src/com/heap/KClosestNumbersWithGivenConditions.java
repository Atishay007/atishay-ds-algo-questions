package com.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestNumbersWithGivenConditions {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        KClosestNumbersWithGivenConditions closestNumber = new KClosestNumbersWithGivenConditions();
        closestNumber.findKClosestNumbers(arr, x, k);
    }

    private void findKClosestNumbers(int[] arr, int x, int k) {
        PriorityQueue<Entry> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(new Entry(arr[i], arr[i], x));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (pq.size() > 0) {
            result.add(pq.poll().getValue());
        }

        result.sort(Comparator.naturalOrder());
        System.out.println(result);
    }

    private class Entry implements Comparable<Entry> {
        private int key;
        private int value;
        private int x;

        public Entry(int key, int value, int x) {
            this.key = key;
            this.value = value;
            this.x = x;
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

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Entry other) {
            boolean result = (Math.abs(this.getKey() - this.getX()) < Math.abs(other.getKey() - this.getX()))
                    || ((Math.abs(this.getKey() - this.getX()) == Math.abs(other.getKey() - this.getX())) && (this.getKey() < other.getKey()));

            //-1 will always be on top in sorting.
            //Here we are creating MaxHeap so that elements far from above condition can be on top.
            return result ? 1 : -1;
        }
    }
}
