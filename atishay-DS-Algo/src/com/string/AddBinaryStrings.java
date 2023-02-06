package com.string;

/*
https://leetcode.com/problems/add-binary/
 */
public class AddBinaryStrings {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String s1 = "1010";
        String s2 = "1011";
        System.out.println(add2BinaryStrings(s1, s2));
        System.out.println(System.nanoTime() - startTime);
    }

    private static String add2BinaryStrings(String s1, String s2) {
        StringBuilder builder1 = new StringBuilder(s1);
        StringBuilder builder2 = new StringBuilder(s2);

        builder2.reverse();
        builder1.reverse();

        if (builder2.length() > builder1.length()) {
            StringBuilder tmp = builder1;
            builder1 = builder2;
            builder2 = tmp;
        }

        int carryF = 0;

        for (int i = 0; i < builder1.length(); i++) {
            carryF = addBinaryValues(builder1, builder2, i, carryF);
        }

        if (carryF > 0) {
            builder1.append(carryF);
        }

        return builder1.reverse().toString();
    }

    private static int addBinaryValues(StringBuilder builder1, StringBuilder builder2, int index, int carryF) {
        if (carryF < 0) {
            carryF = 0;
        }

        int tmpVal = 0;
        if (index < builder2.length()) {
            tmpVal = Character.getNumericValue(builder1.charAt(index)) + Character.getNumericValue(builder2.charAt(index)) + carryF;
        } else {
            tmpVal = Character.getNumericValue(builder1.charAt(index)) + carryF;
        }
        carryF = -1;

        //Only 4 cases for Binary.
        if (tmpVal == 0) {
            builder1.setCharAt(index, Character.forDigit(0, 10));
            carryF = 0;
        } else if (tmpVal == 1) {
            builder1.setCharAt(index, Character.forDigit(1, 10));
            carryF = 0;
        } else if (tmpVal == 2) {
            builder1.setCharAt(index, Character.forDigit(0, 10));
            carryF = 1;
        } else if (tmpVal == 3) {
            builder1.setCharAt(index, Character.forDigit(1, 10));
            carryF = 1;
        }

        return carryF;
    }
}
