package com.arrays;

public class Find2UniqueNo {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2, 2, 1, 5, 4};

        int pos = checkWhichBitIsSet(arr[0]);
        int xorLeft = 0;
        int xorRight = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & (1 << pos)) > 0) {
                xorLeft = xorLeft ^ arr[i];
            } else {
                xorRight = xorRight ^ arr[i];
            }
        }

        System.out.println(xorLeft);
        System.out.println(xorRight);
    }

    private static int checkWhichBitIsSet(int no) {
        int setBitPos = 0;
        for (int i = 0; i < 32; i++) { //only 32 bits are there for int
            if (checkBitIsSet(no, i)) {
                setBitPos = i;
                break;
            }
        }
        return setBitPos;
    }

    private static boolean checkBitIsSet(int no, int pos) {
        return ((no & (1 << pos)) > 0);
    }
}
