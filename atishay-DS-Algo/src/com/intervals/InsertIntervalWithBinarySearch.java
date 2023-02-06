package com.intervals;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
TC:O(n)
SC:O(n)
https://leetcode.com/problems/insert-interval/description/

Using BinarySearch FindInsert Position functionality..

            Binary Search has this property that if we can't find the target
            Then the start position or index will always return the insertion point
            where that value should be present.

*/
public class InsertIntervalWithBinarySearch {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};

        // int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        //int[] newInterval = {4, 8};
        int insertPos = getInsertPos(intervals, 0, intervals.length - 1, newInterval[0]);

        int[][] extendedIntervals = getExtendedArray(intervals, newInterval, insertPos);
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

    private static int[][] getExtendedArray(int[][] intervals, int[] newInterval, int insertPos) {
        int[][] extendedIntervals = new int[intervals.length + 1][];
        int start = 0;
        for (; start < insertPos; start++) {
            extendedIntervals[start] = intervals[start];
        }
        extendedIntervals[insertPos] = newInterval;
        int newPos = ++insertPos;
        for (; start < intervals.length; start++) {
            extendedIntervals[newPos] = intervals[start];
            newPos++;
        }
        return extendedIntervals;
    }

    private static int getInsertPos(int[][] nums, int start, int end, int target) {
        while (start <= end) {
            //To prevent int overflow
            int mid = start + (end - start) / 2;

            if (nums[mid][0] == target) {
                return mid;
            } else if (nums[mid][0] > target) {
                end = mid - 1;
            } else if (nums[mid][0] < target) {
                start = mid + 1;
            }
        }
        /*
            Binary Search has this property that if we can't find the target
            Then the start position or index will always return the insertion point
            where that value should be present.
         */
        return start;
    }
}
