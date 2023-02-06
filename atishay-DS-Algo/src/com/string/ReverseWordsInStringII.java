package com.string;

//You have to do this question in O(1) inplace.
//Here we have to use inbuilt methods of String.
//We don't have to use another array which we was using in
//this similar type of question
public class ReverseWordsInStringII {
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
        //eulb si eht yks  --> blue is the sky
        str = strBuilder.reverse().toString();
        strBuilder = new StringBuilder(str);

        int startIndex = 0;
        for (int i = 0; i < strBuilder.length(); i++) {
            if (strBuilder.charAt(i) == ' ') {
                int k = i - 1;
                swap(strBuilder, startIndex, k);
                startIndex = i + 1;
            }
        }

        int j = strBuilder.length() - 1;
        swap(strBuilder, startIndex, j);

        return strBuilder.toString();
    }

    private static void swap(StringBuilder strBuilder, int startIndex, int k) {
        for (int j = startIndex; j < k; j++, k--) {
            char tmp = strBuilder.charAt(j);
            strBuilder.setCharAt(j, strBuilder.charAt(k));
            strBuilder.setCharAt(k, tmp);
        }
    }
}
