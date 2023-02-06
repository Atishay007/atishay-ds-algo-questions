package com.misc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 10, 6, 9, 8, 7, 5};
        int k = 3;
        System.out.println(Arrays.toString(getMaximum(nums, k)));
    }

    private static int[] getMaximum(int[] nums, int k) {
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

            if (deque.size() > 0 && deque.peekFirst() < nums[i]) {
                deque.pollFirst();
                deque.addFirst(nums[i]);
            } else if (deque.size() > 0 && deque.peekLast() < nums[i]) {
                //Keep polling elements from last if the nums[i] > then elements present in Priority Queue
                while (deque.peekLast() < nums[i]) {
                    deque.pollLast();
                }
                deque.addLast(nums[i]);
            } else {
                deque.addLast(nums[i]);
            }

            windowSize++;
        }

        //Handle last Case
        if (deque.size() > 0) {
            if (deque.peekFirst() > deque.peekLast()) {
                result.add(deque.pollFirst());
            } else {
                result.add(deque.pollLast());
            }
        }

        return result.stream().mapToInt(a -> a).toArray();
    }
}
