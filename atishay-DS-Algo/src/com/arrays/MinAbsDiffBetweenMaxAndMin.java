package com.arrays;

import java.util.*;

public class MinAbsDiffBetweenMaxAndMin {
    public static void main(String[] args) {
        // int[] arr = {2, 6, 3, 9, 8};
        //int b = 3;

        List<Integer> lst = Arrays.asList(9, 9, 9);
        int b = 9;

        System.out.println(solve(lst, b));
    }

    public static int solve(List<Integer> lst, int b) {
        Map<Integer, Integer> map = new HashMap<>();
        int minNo = Integer.MAX_VALUE;
        int maxNo = Integer.MIN_VALUE;

        for (int i = 0; i < lst.size(); i++) {
            maxNo = Math.max(maxNo, lst.get(i));
            minNo = Math.min(minNo, lst.get(i));
        }

        if (Math.abs(maxNo - minNo) == 0) {
            return 0;
        }

        //Creating frequency map.
        for (int i = 0; i < lst.size(); i++) {
            map.put(lst.get(i), map.getOrDefault(lst.get(i), 0) + 1);
        }


        while (b > 0) {
            if (map.get(maxNo) > b && map.get(minNo) > b) {
                break;
            }

            if (map.get(maxNo) < map.get(minNo)) {
                int oldMaxNo = maxNo;
                maxNo--;
                if (map.get(maxNo) != null) {
                    map.put(maxNo, map.get(oldMaxNo) + map.get(maxNo));
                } else {
                    map.put(maxNo, map.get(oldMaxNo));
                }
                b = b - map.get(oldMaxNo);
                map.remove(oldMaxNo);
            } else {
                int oldMinNo = minNo;
                minNo++;
                if (map.get(minNo) != null) {
                    map.put(minNo, map.get(oldMinNo) + map.get(minNo));
                } else {
                    map.put(minNo, map.get(oldMinNo));
                }
                b = b - map.get(oldMinNo);
                map.remove(oldMinNo);
            }

            if ((maxNo - minNo) == 0) {
                break;
            }
        }
        return Math.abs(maxNo - minNo);
    }
}
