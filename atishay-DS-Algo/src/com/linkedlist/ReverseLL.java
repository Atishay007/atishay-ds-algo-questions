package com.linkedlist;

public class ReverseLL {
    public static void main(String[] args) {
        CustomLinkedList<Integer> lst = new CustomLinkedList<>();

        lst.add(10);
        lst.add(20);
        lst.add(30);
        lst.add(40);

        lst.print();

        lst = lst.reverseLinkedList();

        System.out.println();

        lst.print();
    }
}
