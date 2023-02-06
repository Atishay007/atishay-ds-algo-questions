package com.heap;

import java.util.Arrays;

//TC: O(NlogN)
//Here we are using: Heapify up method, where
//child node gets compared with Parent root using formula: (j-1)/2 as
// we are taking 0 index.
public class CreateHeapUsingHeapifyUP {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        System.out.println(Arrays.toString(createAndReturnMaxHeap(arr)));
    }

    //Total TC: O(N*logN)
    private static int[] createAndReturnMaxHeap(int[] arr) {
        int[] maxHeap = new int[arr.length];

        for (int i = 0; i < maxHeap.length; i++) {
            //Tc: O(1)
            maxHeap[i] = arr[i];

            //Adjusting element: O(logN) as we are dividing everytime.
            //Comparing with Parent root and using Heapify up method.
            for (int j = i; j >= 0; j = (j - 1) / 2) {
                int rootIndex = (j - 1) / 2;
                if (maxHeap[j] > maxHeap[rootIndex]) {
                    int temp = maxHeap[rootIndex];
                    maxHeap[rootIndex] = maxHeap[j];
                    maxHeap[j] = temp;
                } else {
                    break;
                }
            }
        }
        return maxHeap;
    }
}
