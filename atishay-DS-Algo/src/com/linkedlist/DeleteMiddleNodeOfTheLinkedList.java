package com.linkedlist;

public class DeleteMiddleNodeOfTheLinkedList {
    public static void main(String[] args) {
        CustomLinkedList<Integer> lst = new CustomLinkedList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
//       st.add(1);
//        lst.add(2);
//        lst.add(6);

        //Using fast and slow pointer: Floyds tortoise and Haire Algo.
        lst.deleteMiddleNode();
    }
}
