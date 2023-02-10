package com.string;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/multiply-strings/
 * TC:O(n)
 * SC:O(1)
 * <p>
 * Used BigInteger in mutiplication of 10 power
 * Also used in adding result.
 * If Interviewer says don't use BigInteger in adding result then we have to go for
 * https://leetcode.com/problems/add-strings/description/
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";

        System.out.println("Final Result: " + getMultiplication(num1, num2));
    }

    private static String getMultiplication(String num1, String num2) {
        if (num1 == null) {
            return num2;
        } else if (num2 == null) {
            return num1;
        }

        if (num1.equals("0") || num2.equals("0")) {
            return String.valueOf(0);
        }

        if (num2.length() > num1.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        int num2Length = num2.length() - 1;
        int globalResult = 0;
        int carryForward = 0;
        int level = 0;

        //  List<String> levelResults = new ArrayList<>();
        BigInteger bigInt = new BigInteger("10");
        BigInteger result = new BigInteger("0");

        while (num2Length >= 0) {
            StringBuilder strBuilder = new StringBuilder();
            int num2Digit = Character.getNumericValue(num2.charAt(num2Length));
            for (int i = num1.length() - 1; i >= 0; i--) {
                int tmpMultipValue = (Character.getNumericValue(num1.charAt(i)) * num2Digit) + carryForward;

                if (tmpMultipValue > 9) {
                    carryForward = tmpMultipValue / 10;
                    tmpMultipValue = tmpMultipValue % 10;
                } else {
                    carryForward = 0;
                }
                strBuilder.append(tmpMultipValue);
            }

            if (carryForward > 0) {
                strBuilder.append(carryForward);
                carryForward = 0;
            }

            //reverse it
            strBuilder.reverse();
            BigInteger tenPower = bigInt.pow(level);
            String noOfZeroes = tenPower.toString();

            //long noOfZeroes = (long) Math.pow(10, level);
            if (noOfZeroes.length() > 1) {
                strBuilder.append(noOfZeroes.substring(1));
            }
            // levelResults.add(strBuilder.toString());
            //  System.out.println(levelResults.get(level));

            result = result.add(new BigInteger(strBuilder.toString()));
            level++;
            num2Length--;
        }

        /*
        String result = null;
        for (int i = 0; i < levelResults.size(); i++) {
            result = AddStrings.addStrings(levelResults.get(i), result);
            //   System.out.println("Result: " + i + " " + result);
        }
*/
        return result.toString();
    }
}
