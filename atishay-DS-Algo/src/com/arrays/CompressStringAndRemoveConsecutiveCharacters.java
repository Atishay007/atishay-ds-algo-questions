package com.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CompressStringAndRemoveConsecutiveCharacters {
    public static void main(String[] args) {
        //  String str = "aabbbbac"; //output --> c
        //String str = "abbbaaadaaccccc";  //aaaadaaccccc //daaccccc // daa
        String str = "geeksforgeeks"; //gksforgeeks //gksforgks
        int k = 2;
        System.out.println(doubleTroubleVariant(str, k));
    }

    private static String doubleTroubleVariant(String str, int k) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();

        stack.push(str.charAt(0));
        map.put(str.charAt(0), map.getOrDefault(str.charAt(0), 0) + 1);

        int i = 1;
        while (i < str.length()) {

            char tmpChar = str.charAt(i);

            map.put(tmpChar, map.getOrDefault(tmpChar, 0) + 1);

            stack.push(tmpChar);

            i++;

            if (map.get(tmpChar) != null && map.get(tmpChar) == k && !stack.isEmpty() && (i >= str.length() || stack.peek() != str.charAt(i))) {
                while (!stack.isEmpty() && stack.peek() == tmpChar) {
                    if (stack.peek() == tmpChar) {
                        stack.pop();
                    }
                }

                map.put(tmpChar, 0);

                if (map.get(tmpChar) <= 0) {
                    map.remove(tmpChar);
                }
            }
        }

        StringBuilder strBuild = new StringBuilder(16);

        while (!stack.isEmpty()) {
            strBuild = strBuild.append("").append(stack.pop());
        }

        return strBuild.reverse().toString();

    }
}
