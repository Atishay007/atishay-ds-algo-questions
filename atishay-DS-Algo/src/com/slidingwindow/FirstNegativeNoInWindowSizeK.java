package com.slidingwindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//TC:O(n)
//SC:O(n) as we are using Queue.
public class FirstNegativeNoInWindowSizeK {
    public static void main(String[] args) {
        // int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        //int windowSize = 3;
        int[] arr = {-8, 2, 3, -6, 10};
        int windowSize = 2;
        List<Integer> result = findFirstNegativeInWindow(arr, windowSize);
        System.out.println(result);
    }

    private static List<Integer> findFirstNegativeInWindow(int[] arr, int windowSize) {
        int startIndex = 0;
        Deque<Integer> queue = new LinkedList<>();
        int k = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (k >= windowSize) {
                if (queue.size() > 0) {
                    if (queue.peekFirst() == arr[startIndex]) {
                        result.add(queue.pollFirst());
                    } else {
                        result.add(queue.peekFirst());
                    }
                } else {
                    result.add(0);
                }
                startIndex++;
                k--;
            }
            k++;
            if (arr[i] < 0) {
                queue.addLast(arr[i]);
            }
        }

        //Handling last case when loop get terminated but
        //still elements are present in Queue.
        if (queue.size() > 0) {
            result.add(queue.pollFirst());
        } else {
            result.add(0);
        }
        return result;
    }
}
