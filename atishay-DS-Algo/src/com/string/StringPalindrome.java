package com.string;

public class StringPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));

    }


    public static boolean isPalindrome(String s) {
        //edgeCase
        if (s == null) {
            return false;
        }

        s = s.toLowerCase();

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 123) {
                str.append(String.valueOf(s.charAt(i)));
            }
        }

        s = str.toString();

        int j = s.length() - 1;

        for (int i = 0; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;

    }
}
