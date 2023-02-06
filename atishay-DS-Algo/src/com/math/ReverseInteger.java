package com.math;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 * TC: O(n)
 * SC:O(1)
 */
public class ReverseInteger {
    public static void main(String[] args) {
        //int num = -2147483412;
        int num = -1563847412;

        System.out.println(reverseNum(num));
    }

    private static int reverseNum(int num) {
        if (num == Integer.MAX_VALUE || num == Integer.MIN_VALUE) {
            return 0;
        }

        //Create copy of Original no.
        int originalNum = num;
        String strOriginalNum = String.valueOf(num);

        //Remove - negative sign to do reverse operation
        if (num < 0) {
            num = Math.abs(num);
        }

        int reverse = 0;
        int numLength = strOriginalNum.length();

        //Run loop length-1, stop before reaching to last
        while (numLength > 1) {
            reverse = (reverse * 10) + num % 10;
            num = num / 10;
            numLength--;
        }

        String strDefaultValue = null;

        if (originalNum >= 0) {
            strDefaultValue = String.valueOf(Integer.MAX_VALUE);
        } else {
            strDefaultValue = String.valueOf(Integer.MIN_VALUE);
        }

        //Edge case
        if (strOriginalNum.length() == strDefaultValue.length()) {
            strDefaultValue = strDefaultValue.substring(0, strDefaultValue.length() - 1);
            if (originalNum < 0) {
                if (-reverse > Integer.parseInt(strDefaultValue)) {
                    return 0;
                }
            } else if (reverse > Integer.parseInt(strDefaultValue)) {
                return 0;
            }
        }

        //Do reverse when there is some remaining no. pending.
        if (num > 0) {
            //Reverse the last digit
            reverse = (reverse * 10) + num % 10;
        }

        //If original no. is negative
        return originalNum < 0 ? -reverse : reverse;
    }
}