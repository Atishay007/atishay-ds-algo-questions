package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
Using Sliding window technique
https://leetcode.com/problems/permutation-in-string/
TC:O(n)
SC:O(n)
 */
public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        Map<Character, Integer> mapS1 = new HashMap<>();
        Map<Character, Integer> mapS2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            mapS1.put(s1.charAt(i), mapS1.getOrDefault(s1.charAt(i), 0) + 1);
            mapS2.put(s2.charAt(i), mapS2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (mapS1.equals(mapS2)) {
            return true;
        }

        //V# starting of window, which will help to remove elements going out of the window
        int start = 0;
        for (int i = s1.length(); i < s2.length(); i++) {
            if (mapS1.equals(mapS2)) {
                return true;
            }

            //Slide the window
            Integer val = mapS2.get(s2.charAt(start));
            if (val != null) {
                val--;
                if (val <= 0) {
                    mapS2.remove(s2.charAt(start));
                } else {
                    mapS2.put(s2.charAt(start), val);
                }
            }
            start++;

            //Adding new window element
            mapS2.put(s2.charAt(i), mapS2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        return mapS1.equals(mapS2);
    }
}
