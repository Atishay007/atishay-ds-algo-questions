package com.linkedlist;

public class GetMiddleNodeOfTheLinkedList {
    public static void main(String[] args) {
        CustomLinkedList<Integer> lst = new CustomLinkedList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        lst.add(6);

        //Using fast and slow pointer: Floyds tortoise and Haire Algo.
        lst.getMiddleNode();
    }
}
