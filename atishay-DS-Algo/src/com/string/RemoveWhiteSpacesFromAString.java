package com.string;

public class RemoveWhiteSpacesFromAString {
    public static void main(String[] args) {
        String str = "All greek to me.  ";
        str = str.trim();
        str = str.replaceAll("\\s+", "");
        System.out.println(str);
    }
}
