package com.intervals;

import java.util.*;

/*
https://leetcode.com/problems/merge-intervals/description/
Sorting is important in interval questions

**Use Deque in place of Stack**

A more complete and consistent set of LIFO stack operations is provided by the Deque interface and its implementations,
which should be used in preference to this class. For example:
Deque<Integer> stack = new ArrayDeque<Integer>();

 */
public class MergeIntervals {
    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(intervals);
          /*
        int[][] intervals = {{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};

        merge(intervals);


        intervals = new int[][]{{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}};
        merge(intervals);
        intervals = new int[][]{{1, 4}, {0, 2}, {3, 5}};
        merge(intervals);
*/
    }

    private static void merge(int[][] intervals) {

        //Sorting by their starting time: v# O(nlogn)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Deque<int[]> stack = new ArrayDeque<>();

        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int currStart = cur[0];
            int currEnd = cur[1];

            int[] prev = stack.pop();
            int prevStart = prev[0];
            int prevEnd = prev[1];

            if (prevEnd >= currStart && currEnd >= prevEnd) {
                int[] merged = {prevStart, currEnd};
                stack.push(merged);
            } else if (prevEnd >= currEnd) {
                stack.push(prev);
            } else {
                stack.push(prev);
                stack.push(cur);
            }
        }


        int[][] mergedIntervals = new int[stack.size()][];

        int index = 0;
        while (!stack.isEmpty()) {
            int[] tmpArr = stack.pollLast();
            int[] newArr = {tmpArr[0], tmpArr[1]};
            mergedIntervals[index] = newArr;
            index++;
        }

        for (int[] arr : mergedIntervals) {
            System.out.println(Arrays.toString(arr));
        }

    }
}
