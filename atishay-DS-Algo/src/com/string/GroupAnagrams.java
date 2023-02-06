package com.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TC: O(n*m): n is the length of the array and m is the length of the String
//SC:O(n)
//https://leetcode.com/problems/group-anagrams/description/
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charFreq = new char[26];
            for (int i = 0; i < str.length(); i++) {
                charFreq[str.charAt(i) - 'a']++;
            }

            //String has constructor to convert char array to String
            String key = new String(charFreq);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        System.out.println(map.values());
    }
}
