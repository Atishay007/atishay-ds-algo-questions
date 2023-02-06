package com.string;

public class RotateStringByK {
    public static void main(String[] args) {
        //  String s1 = "bbbacddceeb";//output: bbbbacddcee //beecddcabbb
        // int k = 4;


//        String s1 = "ckahkzpikz";
//        System.out.println(s1.length());
//        int k = 7;

//        String s1="clrwmpkwru";
//        System.out.println(s1.length());
//        int k=7;

        String s1="abcde";
        int k=3;
        System.out.println(rotateString(s1, k));
    }

    private static String rotateString(String s1, int k) {
        k = k % s1.length();

        if (k == 0) {
            return s1;
        }


        char[] charArr = s1.toCharArray();
        //Reverse whole array
        reverseArray(0, charArr.length - 1, charArr);

        //Reverse first part
        reverseArray(0, k - 1, charArr);

        //Reverse first part
        reverseArray(k, charArr.length - 1, charArr);

        return String.valueOf(charArr);
    }

    private static void reverseArray(int start, int end, char[] arr) {
        for (int i = start; i < end; i++, end--) {
            char tmp = arr[i];
            arr[i] = arr[end];
            arr[end] = tmp;
        }
    }
}
