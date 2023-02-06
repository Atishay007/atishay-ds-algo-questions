package com.slidingwindow;

import java.util.HashSet;
import java.util.Set;
//TC: O(n)
//SC:O(n)
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
       // String str = "abcabcbb";
        //String str="bbbbb";
        String str="pwwkew";
        System.out.println(findLongestSubStringLengthWithUniqueCharacter(str));
    }

    private static int findLongestSubStringLengthWithUniqueCharacter(String str) {
        //Only unique character allowed so we use Set.
        Set<Character> set = new HashSet<>();
        int startIndex = 0;
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
            } else {
                while (set.contains(str.charAt(i))) {
                    set.remove(str.charAt(startIndex));
                    startIndex++;
                }
                set.add(str.charAt(i));
            }

            count = Math.max(count, (i - startIndex) + 1);
        }

        return count;
    }
}
