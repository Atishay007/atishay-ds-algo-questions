package com.linkedlist;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        CustomLinkedList<Integer> lst = new CustomLinkedList<>();
        lst.add(1);
        lst.add(2);
        lst.add(6);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        lst.add(6);

        System.out.println("Printing values of old list");
        lst.print();

        int val = 6;

        System.out.println();

        System.out.println("Printing values of old list");
        lst.removeNodesWithGivenValue(val);

        lst.print();

    }
}
