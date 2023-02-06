package com.arrays;

import java.util.Arrays;
import java.util.Optional;

/**
 * We are using System.arraycopy() to merge all arrays in single array.
 * This functionality is not provided by Arrays.copyOf() so we have used
 * System.arraycopy() and System.arraycopy() is called internally by Arrays.copyOf()
 * <p>
 * We also used varArgs functionality as an optional arguments in method, this functionality
 * is pretty interesting as it gives us freedom to pass or not to pass the argument and still
 * it will not give any errors.
 */
public class MergeTwoArrays {
    public static void main(String[] args) {
        String firstName = "Atishay";
        char[] arr1 = firstName.toCharArray();
        String lastName = "Jain";
        char[] arr2 = lastName.toCharArray();

        char[] mergedArray = merge(arr1, arr2);
        System.out.println(Arrays.toString(mergedArray));
        //Calling merge method without any arguments.
        System.out.println(merge());
    }

    private static char[] merge(char[]... bytes) {
        if (bytes != null) {
            int count = 0;

            for (char[] arr : bytes) {
                count = count + arr.length;
            }
            char[] finalArray = new char[count];
            int start = 0;
            for (char[] arr : bytes) {
                System.arraycopy(arr, 0, finalArray, start, arr.length);
                start = start + arr.length;
            }
            return finalArray;
        } else {
            return null;
        }
    }
}
