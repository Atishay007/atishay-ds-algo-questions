package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//This is a Sliding window pattern
public class CountPermutationOfS1InS2 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abcbacabc";

        System.out.println(countOfPermutations(s1, s2));
    }

    private static int countOfPermutations(String s1, String s2) {
        //Edge and Negative cases
        if (s1.length() > s2.length()) {
            return 0;
        }

        if (s1.equalsIgnoreCase(s2)) {
            return 1;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        int count = 0;
        if (map1.equals(map2)) {
            count++;
        }

        int startIndex = 0;

        for (int i = s1.length(); i < s2.length(); i++) {
            //Slide window by removing lastIndex which is startIndex

            Integer value = map2.get(s2.charAt(startIndex));
            if (value != null) {
                if (value <= 1) {
                    map2.remove(s2.charAt(startIndex));
                } else {
                    map2.put(s2.charAt(startIndex), --value);
                }
                //Important to increase to remove last window element.
                startIndex++;
            }
            //add new window input
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
            //compare both maps
            if (map1.equals(map2)) {
                count++;
            }
        }

        return count;
    }
}
