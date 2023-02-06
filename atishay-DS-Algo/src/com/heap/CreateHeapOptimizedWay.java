package com.heap;

import java.util.Arrays;

public class CreateHeapOptimizedWay {

    //TC: O(n)
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        createMaxHeap(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void createMaxHeap(int[] arr) {
        int indexToSwap = 0;
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            indexToSwap = heapifyDown(arr, i);
        }

        //Edge case: We have to be sure that 0th index value should be heapify down till end.
        for (int i = indexToSwap; i < arr.length; i++) {
            heapifyDown(arr, i);
        }
    }

    private static int heapifyDown(int[] arr, int i) {
        int maxValIndex = maxValIndex(arr, i, (i * 2) + 1, (i * 2) + 2);
        swap(arr, i, maxValIndex);
        return maxValIndex;
    }

    private static int maxValIndex(int[] arr, int oriIndex, int leftNodeIndex, int rightNodeIndex) {
        int maxValIndex = oriIndex;
        if (leftNodeIndex < arr.length && arr[oriIndex] < arr[leftNodeIndex]) {
            maxValIndex = leftNodeIndex;
        }

        if (rightNodeIndex < arr.length && arr[maxValIndex] < arr[rightNodeIndex]) {
            maxValIndex = rightNodeIndex;
        }

        return maxValIndex;
    }

    private static void swap(int[] arr, int origIndex, int maxValIndex) {
        int temp = arr[origIndex];
        arr[origIndex] = arr[maxValIndex];
        arr[maxValIndex] = temp;
    }
}
