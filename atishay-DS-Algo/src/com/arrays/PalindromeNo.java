package com.arrays;

public class PalindromeNo {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-2147483648));
    }

    public static boolean isPalindrome(int x) {
        if(x==Integer.MIN_VALUE){
            return false;
        }
        int countDigits = 0;

        int tmpX = x;

        while (Math.abs(tmpX) > 0) {
            countDigits++;
            tmpX = tmpX / 10;
        }

        countDigits--;

        tmpX = x;
        int tmpX2 = x;

        while (Math.abs(tmpX2) > 0) {
            int leftDigit = tmpX / (int) (Math.pow(10, countDigits));
            int rightDigit = Math.abs(tmpX2 % 10);

            if (leftDigit != rightDigit) {
                return false;
            }

            //For Left digit
            tmpX = tmpX % (int) (Math.pow(10, countDigits));

            //For right digit, removing last element.
            tmpX2 = tmpX2 / 10;

            countDigits--;
        }

        return true;
    }
}
