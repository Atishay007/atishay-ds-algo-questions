package com.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArrayOrNearlySortedArray {
    public static void main(String[] args) {
        //int arr[] = {6, 5, 3, 2, 8, 10, 9};
        //int k = 3;
        int[] arr = {10, 9, 8, 7, 4, 70, 60, 50};
        int k = 4;
        System.out.println(Arrays.toString(arr));
        System.out.println("After Sorting");
        sort(arr, k);
        System.out.println(Arrays.toString(arr));
    }

        private static void sort ( int[] arr, int k){
            int kSize = k + 1;
            int startIndex = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 0; i < arr.length; i++) {
                if (pq.size() == kSize) {
                    arr[startIndex] = pq.poll();
                    startIndex++;
                }
                pq.add(arr[i]);
            }

            while (pq.size() > 0) {
                arr[startIndex] = pq.poll();
                startIndex++;
            }

        }
    }
