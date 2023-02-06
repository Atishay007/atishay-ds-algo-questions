package com.intervals;

import java.util.Arrays;

/*
https://www.lintcode.com/problem/920/description
Don't use stack as we don't have to store any past values
Deque<Interval> stack = new ArrayDeque<>();
stack.push(intervals.get(0));

We need sorting in interval questions
 */
public class MeetingRoomsI {
    public static void main(String[] args) {
        //int[][] intervals = {{0, 30}, {5, 10}, {15, 20}}; //output: false
        int[][] intervals = {{5, 8}, {9, 15}}; //true
        System.out.println(intervalsConflict(intervals));
    }

    private static boolean intervalsConflict(int[][] intervals) {
        //Sorting: O(nlogn)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        //We just have to compare with the next element.
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] curr = intervals[i];
            int[] fut = intervals[i + 1];

            if (curr[1] > fut[0]) {
                return false;
            }
        }
        return true;
    }
}
