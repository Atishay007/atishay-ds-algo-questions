package com.string;

/**
 * https://leetcode.com/problems/add-strings/
 * TC:O(n+m) length of both Strings
 * SC:O(1): Didn't used any extra space, modifications happening in the String which is > in length
 * <p>
 * Can use used in: https://leetcode.com/problems/multiply-strings/description/
 */
public class AddStrings {
    public static void main(String[] args) {
        String num1 = "2233569940800578652115";
        String num2 = "238255300016431168468";

        String[] strings = {"1496485980588", "14964859805880", "249414330098000", "4489457941764000", "9976573203920000", "299297196117600000", "3491800621372000000", "34918006213720000000", "199531464078400000000", "1995314640784147483647", " 3990629281568147483647"};

        String result = null;
        for (int i = 0; i < strings.length; i++) {
            result = addStrings(strings[i], result);
            System.out.println("Result: " + i + " " + result);
        }


        // System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String s1, String s2) {
        if (s1 == null) {
            return s2;
        } else if (s2 == null) {
            return s1;
        }

        if (s2.length() > s1.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }

        StringBuilder builder1 = new StringBuilder(s1);
        StringBuilder builder2 = new StringBuilder(s2);
        builder1.reverse();
        builder2.reverse();

        int carryF = 0;
        int i = 0;
        for (; i < builder1.length(); i++) {
            carryF = addValueAndGetCarryF(builder1, builder2, i, carryF);
        }

        if (carryF >= 0) {
            builder1 = builder1.append(carryF);
        }

        return builder1.reverse().toString();
    }


    private static int addValueAndGetCarryF(StringBuilder s1, StringBuilder s2, int index, int carryF) {
        if (carryF < 0) {
            carryF = 0;
        }

        int tmpVal = 0;
        //Good logic
        if (index < s2.length()) {
            tmpVal = Character.getNumericValue(s1.charAt(index)) + Character.getNumericValue(s2.charAt(index)) + carryF;
        } else {
            tmpVal = Character.getNumericValue(s1.charAt(index)) + carryF;
        }

        //V#  Character.forDigit to convert int into character.
        s1.setCharAt(index, Character.forDigit((tmpVal % 10), 10));

        if (tmpVal >= 10) {
            carryF = tmpVal / 10;
        } else {
            carryF = -1;
        }
        return carryF;
    }
}
