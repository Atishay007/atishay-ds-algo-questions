package com.arrays;

import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        //String A = "{([])}";
        //String A = "(){";
        //  "()[]";
        String A = "[])";
        System.out.println(balanceParanthesis(A));
    }

    private static int balanceParanthesis(String A) {
        Stack<Character> stack = new Stack<>();
        stack.push(A.charAt(0));
        int i = 1;

        while (i < A.length()) {
            if (A.charAt(i) == '{' || A.charAt(i) == '(' || A.charAt(i) == '[') {
                stack.push(A.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                char temp = stack.pop();
                if (!((A.charAt(i) - temp >= 1) && (A.charAt(i) - temp <= 2))) {
                    return 0;
                }
            }
            i++;
        }
        //Edge Case: Stack should be empty in end.
        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
}
