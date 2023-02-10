package com.string;

/**
 * https://leetcode.com/problems/multiply-strings/
 * TC:O(n)
 * SC:O(1)
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "12";
        String num2 = "12";

        System.out.println(getMultiplication(num1, num2));
    }

    private static int getMultiplication(String num1, String num2) {
        if (num2.length() > num1.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        int num2Length = num2.length() - 1;
        int globalResult = 0;
        int carryForward = 0;
        int level = 0;

        while (num2Length >= 0) {
            StringBuilder strBuilder = new StringBuilder();
            int num2Digit = Character.getNumericValue(num2.charAt(num2Length));
            for (int i = num1.length() - 1; i >= 0; i--) {
                int result = (Character.getNumericValue(num1.charAt(i)) * num2Digit) + carryForward;

                if (result > 9) {
                    carryForward = result / 10;
                    result = result % 10;
                } else {
                    carryForward = 0;
                }
                strBuilder.append(result);
            }

            if (carryForward > 0) {
                strBuilder.append(carryForward);
            }

            int levelResult = Integer.valueOf(strBuilder.reverse().toString());
            globalResult = globalResult + (levelResult * (int) (Math.pow(10, level)));
            level++;
            num2Length--;
        }
        return globalResult;
    }
}
