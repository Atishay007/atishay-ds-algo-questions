package com.string;


//TC: O(s1+s2) // as we are checking on 2 Strings.
//SC: O(1)
public class CheckIfS1IsRotationOfS2Optimized {
    public static void main(String[] args) {
        //  String s1 = "erbottlewat"; //erbottlewaterbottlewat
        //String s2 = "waterbottle";

        String s1 = "bbbacddceeb";
        String s2 = "ceebbbbacdd";
        System.out.println(checkIfSubstring(s1, s2));
    }

    private static boolean checkIfSubstring(String s1, String s2) {
        //Edge case: If the length is not matching then return false.
        if (s1.length() != s2.length()) {
            return false;
        }

        //Concatenating Original String
        s1 = s1 + s1;
        return s1.contains(s2);
    }
}