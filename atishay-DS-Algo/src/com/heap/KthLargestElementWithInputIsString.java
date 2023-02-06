package com.heap;

import java.math.BigDecimal;
import java.util.PriorityQueue;

//Priority Queue can handle BigDecimal as well.
// Edge Case:This can't be handled by int/double/float"6888794705"
public class KthLargestElementWithInputIsString {
    public static void main(String[] args) {
        //This can't be handled by int/double/float"6888794705"
        String[] nums = {"3", "6", "7", "10", "6888794705"};
        int k = 1;

        System.out.println(kthLargestNumber(nums, k));
    }

    public static String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigDecimal> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.add(new BigDecimal(nums[i]));

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return String.valueOf(pq.poll());
    }
}