package com.slidingwindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
Using Monotonic Deque where elements will be always present in decreasing order
so that we can poll largest element from head of Queue.

Maintain decreasing order in Deque.
Definition of Monotonic Queue
A monotonic Queue is a data structure the elements from the front to the end is strictly either increasing or decreasing.
*/
public class FindMaximumInSlidingWindow {
    public static void main(String[] args) {
        // int[] arr = {-4, 2, -5, 3, 6};
        //int windowSize = 3;

        int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int windowSize = 4;
        System.out.println(Arrays.toString(getMaximumInSlidingWindow(arr, windowSize)));
    }

    private static int[] getMaximumInSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        LinkedList<Integer> result = new LinkedList<>();
        //V# this is our friend.
        int startIndex = 0;
        int windowSize = 0;

        for (int i = 0; i < nums.length; i++) {
            //Slide window
            if (deque.size() > 0 && windowSize >= k) {
                if (deque.peek() == nums[startIndex]) {
                    result.add(deque.pollFirst());
                } else {
                    result.add(deque.peek());
                }
                startIndex++;
                windowSize--;
            }

            //Maintain Deque in Decreasing order: Monotonic Queue.
            if (deque.size() > 0 && deque.peekFirst() < nums[i]) {
                deque.pollFirst();
            }

            //Maintain Deque in Decreasing order:: Keep polling elements from last if the nums[i] > then elements present in Priority Queue
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }

            //Finally adding element, if it passes above 2 condition.
            deque.addLast(nums[i]);
            windowSize++;
        }


        //Handle last Case
        if (deque.size() > 0) {
            result.add(deque.pollFirst());
        }

        return result.stream().mapToInt(a -> a).toArray();

    }
}
