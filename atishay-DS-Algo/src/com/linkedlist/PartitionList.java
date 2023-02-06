package com.linkedlist;

public class PartitionList {
    public static void main(String[] args) {
        CustomLinkedList<Integer> ll = new CustomLinkedList<>();
        ll.add(1);
        ll.add(4);
        ll.add(3);
        ll.add(2);
        ll.add(5);
        ll.add(2);

        ll.partitionList(3);
        ll.print();
        System.out.println();

        ll = new CustomLinkedList<>();
        ll.add(2);
        ll.add(1);
        ll.partitionList(2);
        ll.print();

        System.out.println();


        ll = new CustomLinkedList<>();
        ll.add(1);
        ll.add(4);
        ll.add(3);
        ll.add(0);
        ll.add(5);
        ll.add(2);
        ll.partitionList(2);
        ll.print();
        System.out.println();


        ll = new CustomLinkedList<>();
        ll.add(1);
        ll.add(4);
        ll.add(2);
        ll.add(2);
        ll.add(3);
        ll.add(6);
        ll.add(7);
        ll.add(1);
        ll.partitionList(3);
        ll.print();
        System.out.println();
    }
}
