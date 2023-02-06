package com.string;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateLettersFromString {
    public static void main(String[] args) {
        String s = "bcabc";

        //This is possible as TreeSet implements NavigableSet<E>
        //But we have to create instance of TreeSet only.
        TreeSet<Character> treeSet = new TreeSet<>();

        for (int i = 0; i < s.length(); i++) {
            treeSet.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            treeSet.add(s.charAt(i));
        }

        StringBuilder stringBuilder = new StringBuilder(treeSet.size());
        while (treeSet.size() > 0) {
            stringBuilder.append(treeSet.pollFirst());
        }

        s = stringBuilder.toString();
        System.out.println(s);

    }
}
