package com.arrays;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        String binaryResult = getSumInBinary(100, 200);
        System.out.println(convertBinaryResultToDecimal(binaryResult));
    }

    private static String getSumInBinary(int a, int b) {
        int carryForward = 0;
        String binary1 = Integer.toBinaryString(a);
        String binary2 = Integer.toBinaryString(b);

        if (binary1.length() < binary2.length()) {
            binary1 = fixLengthOfBinaryString(binary1, binary2);
        } else if (binary2.length() < binary1.length()) {
            binary2 = fixLengthOfBinaryString(binary2, binary1);
        }
        StringBuilder builder = new StringBuilder(binary1.length());

        for (int i = binary1.length() - 1; i >= 0; i--) {
            int value = Character.getNumericValue(binary1.charAt(i)) + Character.getNumericValue(binary2.charAt(i)) + carryForward;

            carryForward = value / 2;
            builder.append(value % 2);
        }

        if (carryForward > 0) {
            builder.append(carryForward);
        }

        return builder.reverse().toString();
    }

    private static String fixLengthOfBinaryString(String binary1, String binary2) {
        int diff = binary2.length() - binary1.length();
        StringBuilder builder = new StringBuilder(binary1.length());
        for (int i = 0; i < diff; i++) {
            builder.append("0");
        }
        builder.append(binary1);
        return builder.toString();
    }

    private static int convertBinaryResultToDecimal(String binaryResult) {
        int sum = 0;
        int pow = binaryResult.length() - 1;
        for (int i = 0; i < binaryResult.length(); i++) {
            sum = sum + (int) Math.pow(2, pow) * Character.getNumericValue(binaryResult.charAt(i));
            pow--;
        }

        return sum;
    }
}
