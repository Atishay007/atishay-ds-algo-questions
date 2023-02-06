package com.string;

public class StringPalindromeSolution2 {

    public static void main(String[] args) {
        String s = "0P";
        s = s.toLowerCase();
        s = s.replaceAll("[^A-Za-z0-9]", "");
        if (s == null) {
            System.out.println(true);
        }
        int start = 0;
        int end = (s.length()) - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                System.out.println(false);
            } else {
                start++;
                end--;
            }
        }
        System.out.println(true);
    }
}