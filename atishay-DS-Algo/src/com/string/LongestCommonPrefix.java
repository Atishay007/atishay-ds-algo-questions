package com.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        //  String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"dog", "racecar", "car"};

        //Edge cases
        if (strs.length == 0) {
            System.out.println("");
            System.exit(0);
        }
        if (strs.length == 1) {
            System.out.println(strs[0]);
            System.exit(0);
        }

        StringBuilder minPrefix = new StringBuilder(strs[0]);

        //O(n)
        for (int i = 1; i < strs.length; i++) {
            String s1 = strs[i];
            if (minPrefix.equals(s1)) {
                continue;
            }
            StringBuilder tmpBuilder = new StringBuilder();
            for (int j = 0; j < s1.length(); j++) {
                if (j >= minPrefix.length()) {
                    break;
                }
                if (minPrefix.charAt(j) != s1.charAt(j)) {
                    break;
                } else {
                    tmpBuilder.append(s1.charAt(j));
                }
            }
            minPrefix = tmpBuilder.length() < minPrefix.length() ? tmpBuilder : minPrefix;
        }

        System.out.println(minPrefix.toString());
    }
}
