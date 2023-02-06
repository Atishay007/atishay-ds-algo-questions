package com.arrays;

import java.util.Arrays;

public class LexicographicallyLargest {
    public static void main(String[] args) {
        String str = "twnwdluhxf_l";
        String[] strArr = str.split("_");

        StringBuilder strBuilder = new StringBuilder(strArr[0]);
        String s2 = strArr[1];

        char[] charArr = s2.toCharArray();
        Arrays.sort(charArr);

        StringBuilder strBuilderT = new StringBuilder();
        strBuilderT.append(charArr);
        strBuilderT.reverse();

        int j = 0;
        for (int i = 0; i < strBuilder.length() && j < strBuilderT.length(); i++) {
            if (strBuilder.charAt(i) < strBuilderT.charAt(j)) {
                strBuilder.setCharAt(i, strBuilderT.charAt(j));
                j++;
            }
        }

        System.out.println(strBuilder.toString());

    }
}
