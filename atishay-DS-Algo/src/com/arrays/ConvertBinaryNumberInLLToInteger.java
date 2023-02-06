package com.arrays;

public class ConvertBinaryNumberInLLToInteger {
    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();
        builder.append("1").append("0").append(1);

        int decimalNo = 0;
        int power = builder.length() - 1;

        for (int i = 0; i < builder.length(); i++) {
            int no = Character.getNumericValue(builder.charAt(i));
            decimalNo = decimalNo + (no * (int) Math.pow(2, power));
            power--;
        }

        System.out.println(decimalNo);
    }
}
