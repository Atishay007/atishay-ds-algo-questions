package com.string;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//TC:O(n)
//SC:O(n)
public class RemoveDuplicateLettersFromStringSimple {
    public static void main(String[] args) {
        String s = "bcabc";
        StringBuilder stringBuilder = new StringBuilder();

        Set<Character> set = new HashSet<>();

        stringBuilder.append(s.charAt(0));
        set.add(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
                set.add(s.charAt(i));
            }
        }

        s = stringBuilder.toString();
        System.out.println(s);

    }
}
