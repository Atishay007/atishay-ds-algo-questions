package com.arrays;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CustomQueue {
    public static void main(String[] args) {


        int[] nums = {2, 2, 2, 2, 2};
        //int[] nums = {1, 2, 3, 4, 5};

        //int[] oriArr = {3, 1, 3, 4, 2};
        //int[] nums = {1, 2, 3, 4};
        int sum = 0;
        int sum1 = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        for (int i = 1; i < nums.length; i++) {
            sum1 = sum1 + i;
        }


        System.out.println(sum - sum1);
    }
}
