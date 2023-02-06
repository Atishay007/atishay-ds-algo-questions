package com.arrays;

import java.util.*;

public class Add1ToNumber {

    public static void main(String[] args) {
        int[] arr = {0,0,1,9,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] arr) {
        int startPos = 0;
        //To avoid leading zeroes
        for (; startPos < arr.length; startPos++) {
            if (arr[startPos] != 0) {
                break;
            }
        }

        List<Integer> lst = new ArrayList<>();

        int carryForward = 0;
        int total = 0;

        total = arr[arr.length - 1] + 1;

        lst.add(total % 10);
        carryForward = total / 10;

        for (int i = arr.length - 2; i >= startPos; i--) {

            total = arr[i] + carryForward;
            carryForward = 0;

            if (total > 9) {
                lst.add(total % 10);
                carryForward = total / 10;
            } else {
                lst.add(total);
            }
        }

        if (carryForward > 0) {
            lst.add(carryForward);
        }

        int[] arr1 = new int[lst.size()];
        int j = 0;
        for (int i = lst.size() - 1; i >= 0; i--) {
            arr1[j] = lst.get(i);
            j++;
        }

        return arr1;

    }
}
