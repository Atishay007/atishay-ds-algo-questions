package com.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

public class MaxInSlidingWindowPractice {
    public static void main(String[] args) {
        int[] nums = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        int k = 4;
        int[] result = findMaximum(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            System.out.print(" ");
        }
    }

    private static int[] findMaximum(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
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
                windowSize--;
                startIndex++;
            }

            windowSize++;
            if (deque.size() > 0 && deque.peek() < nums[i]) {
                deque.pollFirst();
                deque.addFirst(nums[i]);
            } else {
                deque.addLast(nums[i]);
            }
        }

        //Handle last Case
        if (deque.size() > 0) {
            result.add(deque.pollFirst());
        }

        return result.stream().mapToInt(a -> a).toArray();

    }
}
