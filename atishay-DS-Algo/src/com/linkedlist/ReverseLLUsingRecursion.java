package com.linkedlist;

public class ReverseLLUsingRecursion {
    public static void main(String[] args) {
        CustomLinkedList<Integer> lst = new CustomLinkedList<>();

        lst.add(10);
        lst.add(20);
        lst.add(30);
        lst.add(40);

        lst.print();
        System.out.println();

        System.out.println("After reverse using recursion");

        lst.reverseUsingRecursion();

        lst.print();
    }
}
