package com.intervals;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
Slower than solution InsertIntervalWithBinarySearch
TC:O(nlogn)
SC:O(n)
 */
public class InsertIntervalWithoutBinarySearch {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3,}, {6, 9}};
        int[] newInterval = {2, 5};

        // int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        //int[] newInterval = {4, 8};

        int[][] extendedIntervals = getExtendedArray(intervals, newInterval);
        int[][] mergedIntervals = insertInterval(extendedIntervals);

        for (int[] arr : mergedIntervals) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int[][] insertInterval(int[][] intervals) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int currStart = curr[0];
            int currEnd = curr[1];

            int[] prev = stack.pop();
            int prevStart = prev[0];
            int prevEnd = prev[1];

            if (prevEnd >= currStart && currEnd >= prevEnd) {
                int[] mergedInterval = {prevStart, currEnd};
                stack.push(mergedInterval);
            } else if (prevEnd >= currStart) {
                stack.push(prev);
            } else {
                stack.push(prev);
                stack.push(curr);
            }
        }

        intervals = new int[stack.size()][];
        int index = 0;
        while (!stack.isEmpty()) {
            intervals[index] = stack.pollLast();
            index++;
        }
        return intervals;
    }

    private static int[][] getExtendedArray(int[][] intervals, int[] newInterval) {
        int[][] extendedIntervals = new int[intervals.length + 1][];
        if (intervals.length >= 1) {
            System.arraycopy(intervals, 0, extendedIntervals, 0, extendedIntervals.length - 1);
        }
        extendedIntervals[extendedIntervals.length - 1] = newInterval;
        Arrays.sort(extendedIntervals, (a, b) -> a[0] - b[0]);
        return extendedIntervals;
    }
}
