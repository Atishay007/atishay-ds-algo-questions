package com.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Tc:O(nlogn)
SC:O(n)

https://leetcode.com/problems/largest-number/description/
::Edge case {0,0} --> return single 0
 */
public class LargestNo {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(formLargestNo(nums));
    }

    private static String formLargestNo(int[] nums) {
        //We can't use comparator for primitives but the logic is to convert each no. into
        //String so we will convert the whole array into String

        String[] strArr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(strArr, (s1, s2) -> {
            String no1 = s1 + s2;
            String no2 = s2 + s1;

            return no1.compareTo(no2) >= 0 ? -1 : 1;
        });

        //Handling edge case
        if (strArr[0].equals("0")) {
            return "0";
        }

        return Arrays.stream(strArr).collect(Collectors.joining());
    }
}
