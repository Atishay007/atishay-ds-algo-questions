package com.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonOverLappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(overLapInterval(intervals));
    }

    public static int overLapInterval(int[][] intervals) {

        //Sorting array: O(nlogn)
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();

        //O(n)
        for (int i = 0; i < intervals.length; i++) {
            startTimes.add(intervals[i][0]);
        }

        //O(n)
        for (int i = 0; i < intervals.length; i++) {
            endTimes.add(intervals[i][1]);
        }

        int p2 = 0;
        int count = 0;

        for (int i = 1; i < startTimes.size(); i++) {
            if (startTimes.get(i) < endTimes.get(p2)) {
                count++;
                if (endTimes.get(i) <= endTimes.get(p2)) {
                    p2 = i;
                }
            } else {
                if (endTimes.get(i) > endTimes.get(p2)) {
                    p2 = i;
                }
            }
        }

        return count;
    }
}
