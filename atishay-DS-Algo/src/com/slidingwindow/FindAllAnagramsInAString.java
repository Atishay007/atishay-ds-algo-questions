package com.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * TC:O(n)
 * SC:O(n)
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(checkForAnagram(s, p));

        //Edge case condition, s length should be more than p.
        s = "aaaaaaaaaa";
        p = "aaaaaaaaaaaaa";
        System.out.println(checkForAnagram(s, p));
    }


    public static List<Integer> checkForAnagram(String s, String p) {
        //Edge cases are very important to handle
        if ((s == null || p == null) || (s.length() < p.length())) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapP = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            mapP.put(p.charAt(i), mapP.getOrDefault(p.charAt(i), 0) + 1);
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }

        //Helper in Sliding window.
        int startIndex = 0;

        if (mapS.equals(mapP)) {
            result.add(startIndex);
        }

        for (int i = p.length(); i < s.length(); i++) {
            //Slide window and remove element.
            Integer val = mapS.get(s.charAt(startIndex));
            if (val != null) {
                if (val <= 1) {
                    mapS.remove(s.charAt(startIndex));
                } else {
                    mapS.put(s.charAt(startIndex), --val);
                }
                startIndex++;
            }
            //Adding new element arrived in window.
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
            if (mapS.equals(mapP)) {
                result.add(startIndex);
            }
        }
        return result;
    }
}
