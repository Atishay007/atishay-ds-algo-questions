package com.linkedlist;

public class ReverseLLII {
    public static void main(String[] args) {
        CustomLinkedList<Integer> lst = new CustomLinkedList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);

        System.out.println("Printing values of old list");
        lst.print();

        int left = 2;
        int right = 4;

        lst.reverseBetween(left, right);

        System.out.println("Printing values of reversed list");
        lst.print();
    }
}
