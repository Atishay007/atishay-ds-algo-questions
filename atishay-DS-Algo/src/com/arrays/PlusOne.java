package com.arrays;

import java.util.Arrays;

/*
https://leetcode.com/problems/plus-one/description/
TC:O(n)
SC:O(1)
Other similar Questions like:
1. Add binary
2. Add 2 Sorted LL
3. Add Sorted Array etc.
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {4, 3, 2, 1};
        System.out.println(Arrays.toString(addOne(digits)));
    }

    private static int[] addOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            //if last index is smaller than 9 then there will be no carryF
            //If we are reaching to index other than last means we have carrF
            //But if we reach till end of the loop then the no is: 999
            //2 cases: 999 and 1234
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }

        //By default the int have 0 default values and first index will be 1: 999
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
