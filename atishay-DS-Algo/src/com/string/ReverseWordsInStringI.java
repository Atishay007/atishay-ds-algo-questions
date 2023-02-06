package com.string;

public class ReverseWordsInStringI {
    public static void main(String[] args) {
        String str = "  the sky is blue  ";
        System.out.println(reverseWordsInString(str));
    }

    private static String reverseWordsInString(String str) {
        if (str == null || str.equals("") || str.equals(" ") || str.length() == 1) {
            return str;
        }

        //Removes all starting and ending spaces.
        str = str.trim();
        //It will remove all the extra spaces between words and replace those
        //extra spaces with single space.
        str.replaceAll("\\s+", " ");
        StringBuilder strBuilder = new StringBuilder(str);
        //eulb si eht yks
        str = strBuilder.reverse().toString();
        char[] charArr = str.toCharArray();

        int startIndex = 0;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                int k = i - 1;
                swap(charArr, startIndex, k);
                startIndex = i + 1;
            }
        }

        int j = charArr.length - 1;
        swap(charArr, startIndex, j);

        return String.valueOf(charArr);
    }

    private static void swap(char[] charArr, int startIndex, int k) {
        for (int j = startIndex; j < k; j++, k--) {
            char tmp = charArr[j];
            charArr[j] = charArr[k];
            charArr[k] = tmp;
        }
    }
}
