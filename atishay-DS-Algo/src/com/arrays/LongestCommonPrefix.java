package com.arrays;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        // String[] strs = {"abcdefgh", "aefghijk", "abcefgh"};
        // String[] strs= {"abab", "ab", "abcd"};
        String[] strs = {"reflower", "flow", "flight"};
        String smallStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (smallStr.length() > strs[i].length()) {
                smallStr = strs[i];
            }
        }
        //   Arrays.sort(str, (a, b) -> a.length() - b.length());
        int globalPrefixCount = Integer.MAX_VALUE;


        for (int i = 0; i < strs.length; i++) {
            if (smallStr.equals(strs[i])) {
                continue;
            }
            int localPrefixCount = 0;
            String localStr = strs[i];

            for (int j = 0; j < smallStr.length(); j++) {
                if (smallStr.charAt(j) == localStr.charAt(j)) {
                    localPrefixCount++;
                } else {
                    break;
                }
            }

            globalPrefixCount = Math.min(globalPrefixCount, localPrefixCount);
        }
        System.out.println(smallStr.substring(0, globalPrefixCount));
    }
}
