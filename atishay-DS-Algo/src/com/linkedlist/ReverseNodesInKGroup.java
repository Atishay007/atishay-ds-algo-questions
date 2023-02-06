package com.linkedlist;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        CustomLinkedList<Integer> lst = new CustomLinkedList<>();

        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        lst.add(6);
        lst.add(7);
        lst.add(8);
        lst.add(9);

        lst.print();
        System.out.println();

        int k = 2;

        System.out.println("After reversing in K groups");

        lst.reverseNodesInKGroupMatchingWithK(k);

        lst.print();
    }
}
