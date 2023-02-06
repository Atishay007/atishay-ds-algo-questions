package com.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//TC:O(n)
//SC:O(n)
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        //char[] arr = "ADOBECODEBANC".toCharArray();
        //String t = "ABC";

//        char[] arr ="a".toCharArray();
//        String t="a";

        char[] arr ="a".toCharArray();
        String t="aa";
        System.out.println(findMinimumWindowSubstring(arr, t));
    }

    private static String findMinimumWindowSubstring(char[] arr, String t) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        count = map.keySet().size();
        int length = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int startIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int val = map.get(arr[i]);
                val--;
                //reducing count of character
                map.put(arr[i], val);
                if (val == 0) {
                    //if count is 0 then we found 1 character.
                    count--;
                }
            }

            //We found the first answer.
            //Let's try to find the more optimized answer.
            if (count == 0) {
                while (count == 0) {
                    if (length > (i - startIndex) + 1) {
                        length = (i - startIndex) + 1;
                        start = startIndex;
                        end = i;
                    }

                    if (map.containsKey(arr[startIndex])) {
                        int oldValue = map.get(arr[startIndex]);
                        int newValue = ++oldValue;
                        map.put(arr[startIndex], newValue);
                        if (newValue == 1) {
                            count++;
                        }
                    }
                    startIndex++;
                }
            }
        }

        //Last case
        if (length == Integer.MAX_VALUE) {
            return "";
        }

        StringBuilder builder = new StringBuilder(length);
        for (int i = start; i <= end; i++) {
            builder.append(arr[i]);
        }

        return builder.toString();
    }
}
