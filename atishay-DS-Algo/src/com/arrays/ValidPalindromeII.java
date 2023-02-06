package com.arrays;

public class ValidPalindromeII {
    public static void main(String[] args) {
        String str = "aaccaab";
        System.out.println(checkForPalindrome(str));
    }

    private static boolean checkForPalindrome(String str) {
        //Edge case
        if (str.length() == 1) {
            return true;
        }

        boolean isPalindrome = true;
        int j = str.length() - 1;
        int i = 0;
        for (i = 0; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            return true;
        }

        boolean result = checkPalindromeExcludingIndex(str, i);

        if (result) {
            return true;
        }

        return checkPalindromeExcludingIndex(str, j);

    }

    private static boolean checkPalindromeExcludingIndex(String str, int excludeIndex) {
        int j = str.length() - 1;
        for (int i = 0; i < j; ) {
            if (i == excludeIndex) {
                i++;
            } else if (j == excludeIndex) {
                j--;
            } else {
                if (str.charAt(i) != str.charAt(j)) {
                    return false;
                }

                i++;
                j--;
            }
        }
        return true;
    }
}
