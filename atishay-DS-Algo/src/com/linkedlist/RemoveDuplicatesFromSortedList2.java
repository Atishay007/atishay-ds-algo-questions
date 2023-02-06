package com.linkedlist;

public class RemoveDuplicatesFromSortedList2 {
    public static void main(String[] args) {
        CustomLinkedList<Integer> lst = new CustomLinkedList<>();
//        lst.add(1);
//        lst.add(2);
//        lst.add(3);
//        lst.add(3);
//        lst.add(4);
//        lst.add(4);
//        lst.add(5);

        lst.add(1);
        lst.add(1);
        lst.add(1);
        lst.add(2);
        lst.add(3);


//        lst.add(23);
//        lst.add(28);
//        lst.add(28);
//        lst.add(35);
//        lst.add(49);
//        lst.add(49);
//        lst.add(53);
//        lst.add(53);

//        lst.add(11);
//        lst.add(11);
//        lst.add(11);
//        lst.add(11);
//        lst.add(75);
//        lst.add(75);

        System.out.println("Before removing duplicate elements");
        lst.print();

        lst.removeDuplicatesFromSortedList2();
        System.out.println("");
        System.out.println("After removing duplicate elements");
        lst.print();
    }
}
