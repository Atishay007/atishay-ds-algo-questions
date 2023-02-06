package com.linkedlist;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        CustomLinkedList<Integer> lst = new CustomLinkedList<>();
        lst.add(1);
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(3);

        System.out.println("Before removing duplicate elements");
        lst.print();

        lst.removeDuplicateNodesWhenListSorted();
        System.out.println("");
        System.out.println("After removing duplicate elements");
        lst.print();
    }
}
