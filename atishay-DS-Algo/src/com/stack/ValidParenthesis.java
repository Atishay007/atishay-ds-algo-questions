package com.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 * TC:O(n)
 * SC:O(n)
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        //String s = "{([])}";
        //String s = "(){";
        //  "()[]";
        String s = "[])";
        System.out.println(isStringBalanced(s));
    }

    public static boolean isStringBalanced(String s) {
        if (s.isBlank()) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')') {
                //While popping out and If stack is null then it means no open brackets present.
                if (stack.isEmpty()) {
                    return false;
                } else if (!(s.charAt(i) - stack.peek() >= 1 && s.charAt(i) - stack.peek() <= 2)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
