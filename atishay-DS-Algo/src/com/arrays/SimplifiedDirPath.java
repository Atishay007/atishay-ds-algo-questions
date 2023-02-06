package com.arrays;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifiedDirPath {
    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(path));

        Deque<Integer>deq= new LinkedList<>();
    }


    public static String simplifyPath(String path) {

        if (path.length() == 1) {
            return path;
        }

        String[] arr = path.split("/");

        LinkedList<String> lst = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("") || arr[i].equals(".")) {
                continue;
            } else if (arr[i].equals("..")) {
                if (!lst.isEmpty()) {
                    lst.removeLast();
                }
            } else {
                lst.addLast(arr[i]);
            }
        }

        if (lst.isEmpty()) {
            return "/";
        }

        StringBuilder strBuild = new StringBuilder();

        //Using LinkedList as a Deque.
        while (!lst.isEmpty()) {
            strBuild.append("/").append(lst.removeFirst());
        }

        return strBuild.toString();

    }
}