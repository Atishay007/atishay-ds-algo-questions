package com.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/smallest-subarray-k-distinct-numbers/
 * TC:O(n)
 * SC:O(n)
 * Asked in : https://navan.com/
 */
public class MinimumLenSubArrayWithKDistinctNumbers {

    private static List<Integer> lst = null;

    public static void main(String[] args) {
        lst = Arrays.asList(3, 2, 3, 3, 1, 3);
        System.out.println(findMinimumLengthSubarray(lst, 3));

        lst = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5);
        System.out.println(findMinimumLengthSubarray(lst, 3));

        lst = Arrays.asList(1, 2, 2, 3);
        System.out.println(findMinimumLengthSubarray(lst, 2));

        lst = Arrays.asList(1, 1, 2, 1, 2);
        System.out.println(findMinimumLengthSubarray(lst, 3));
    }

    public static int findMinimumLengthSubarray(List<Integer> lst, int k) {
        int startIndex = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        for (; i < lst.size(); i++) {
            //First adding element.
            map.put(lst.get(i), map.getOrDefault(lst.get(i), 0) + 1);

            //Sliding Window
            while (map.keySet().size() == k) {
                minLength = modifyCountMap(map, minLength, startIndex, i);
                startIndex++;
            }
        }

        //important to reduce i, previous loop has incremented the i.
        --i;

        /*
        Sliding Window for last scenario.
        There can be scenario where still 3 unique elements are there in map but we didn't increment 
        startIndex or we have to check for minLengthSubarry till there are no 3 unique elements left in map.
         */
        while (map.keySet().size() == k) {
            minLength = modifyCountMap(map, minLength, startIndex, i);
            startIndex++;
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    private static int modifyCountMap(Map<Integer, Integer> map, int minLength, int startIndex, int currentIndex) {
        minLength = Math.min(minLength, (currentIndex - startIndex) + 1);
        Integer val = map.get(lst.get(startIndex));
        if (val != null) {
            if (val <= 1) {
                map.remove(lst.get(startIndex));
            } else {
                map.put(lst.get(startIndex), --val);
            }
        }
        return minLength;
    }
}
