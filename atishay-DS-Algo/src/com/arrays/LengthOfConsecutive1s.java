package com.arrays;

public class LengthOfConsecutive1s {
    public static void main(String[] args) {
        int kSwaps = 1;
        // String str = "111011101";
        String str = "111000";
        int total1s = 0;

        //First check how many 1s are there.
        for (int i = 0; i < str.length(); i++) {
            if (Character.getNumericValue(str.charAt(i)) == 1) {
                total1s++;
            }
        }

        int startIndex = 0;

        //Ignore starting 0's
        for (int i = 0; i < str.length(); i++) {
            if (Character.getNumericValue(str.charAt(i)) != 0) {
                startIndex = i;
                break;
            }
        }

        int count0s = 0;
        int j = startIndex;
        int subArrCount = 0;
        for (int i = startIndex; i < str.length(); i++) {

            if (Character.getNumericValue(str.charAt(i)) == 0) {
                count0s++;
            }

            if (count0s > kSwaps) {
                while (Character.getNumericValue(str.charAt(j)) != 0) {
                    j++;
                }
                j++;
                count0s--;
            }

            subArrCount = Math.max(subArrCount, (i - j) + 1);
        }

        if (subArrCount > total1s) {
            System.out.println(total1s);
            System.exit(0);
        }

        System.out.println(subArrCount);
    }
}
