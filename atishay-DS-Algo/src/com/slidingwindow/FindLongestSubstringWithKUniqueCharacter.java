package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//TC:O(n)
//SC:O(n)
//URL: https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
public class FindLongestSubstringWithKUniqueCharacter {
    public static void main(String[] args) {
        String s1 = "gbwkfnqduxwfn";
        int k = 15;

        System.out.println(findLengthOfLongestSubstring(s1, k));
    }

    private static int findLengthOfLongestSubstring(String s1, int k) {
        int count =-1;
        int startIndex = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            //Inserting all elements in beginning
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);

            //Slide the window
            if (map.keySet().size() > k) {
                count = findMaxLengthOfSubstring(count, startIndex, i);

                while (map.keySet().size() > k) {
                    int val = map.get(s1.charAt(startIndex));
                    val--;

                    if (val == 0) {
                        map.remove(s1.charAt(startIndex));
                    } else {
                        map.put(s1.charAt(startIndex), val);
                    }
                    startIndex++;
                }
            }
        }


        //Last case
        if (map.keySet().size() == k) {
            count = findMaxLengthOfSubstring(count, startIndex, s1.length());
        }

        return count;
    }

    private static int findMaxLengthOfSubstring(int count, int startIndex, int currentIndex) {
        return Math.max(count, ((currentIndex - 1) - startIndex) + 1);
    }
}
