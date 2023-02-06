package com.string;

public class AddStrings {
    public static void main(String[] args) {
        String num1 = "888888";
        String num2 = "99009009900";
        System.out.println(addStrings(num1, num2));
    }

    private static String addStrings(String s1, String s2) {
        if (s2.length() > s1.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }

        StringBuilder builder1 = new StringBuilder(s1);
        builder1.reverse();
        StringBuilder builder2 = new StringBuilder(s2);
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

