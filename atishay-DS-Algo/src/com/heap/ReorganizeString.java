package com.heap;

import javax.lang.model.type.IntersectionType;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reorganize-string/description/
 * TC: O(nlogn)
 * SC:O(n)
 */


public class ReorganizeString {
    public static void main(String[] args) {
        String str = "aba";

        System.out.println(reorganizeString(str));
    }

    private static String reorganizeString(String str) {
        if (str == null || str.length() == 0 || str.length() == 1 || str.equals("")) {
            return str;
        }

        double freqValidation = Math.round((double)str.length() / 2);

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            if (map.get(str.charAt(i)) > freqValidation) {
                return "";
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        StringBuilder stringBuilder = new StringBuilder(str.length());

        //Poll out the character having max Freq. first and then other elements with lower Freq. can be used.
        Map.Entry<Character, Integer> pastEntry = pq.poll();
        //Max freq character is appended.
        stringBuilder.append(pastEntry.getKey());
        //Max freq character is reduced as it is appended.
        pastEntry.setValue(pastEntry.getValue() - 1);

        Map.Entry<Character, Integer> polledEntry = null;
        while (pq.size() > 0) {
            polledEntry = pq.poll();
            stringBuilder.append(polledEntry.getKey());
            polledEntry.setValue(polledEntry.getValue() - 1);

            if (pastEntry.getValue() > 0) {
                pq.add(pastEntry);
            }
            if (pq.size() == 0) {
                break;
            }
            pastEntry = polledEntry;
        }

        if (polledEntry != null && polledEntry.getValue() > 0) {
            return "";
        }

        return stringBuilder.length() == 1 ? "" : stringBuilder.toString();
    }
}
