package com.linkedlist;

/**
 * https://leetcode.com/problems/add-two-numbers-ii/description/
 * TC: O(n+m) as we are iterating on 2 LL
 * SC:O(1)
 */
public class AddTwoNumberII {
    public static void main(String[] args) {
        CustomLinkedList<Integer> l1 = new CustomLinkedList<>();
        CustomLinkedList<Integer> l2 = new CustomLinkedList<>();

        System.out.print("Running TestCase 1:--> ");
        l1.add(7);
        l1.add(2);
        l1.add(4);
        l1.add(3);

        l2.add(5);
        l2.add(6);
        l2.add(4);

        l1.addLinkedListsII(l2);
        l1.print();

        System.out.println();

        System.out.print("Running TestCase 2:--> ");
        l1 = new CustomLinkedList<>();
        l1.add(0);

        l2 = new CustomLinkedList<>();
        l2.add(0);
        l1.addLinkedListsII(l2);
        l1.print();
        System.out.println();

        System.out.print("Running TestCase 3: -->");
        l1 = new CustomLinkedList<>();
        l1.add(9);
        l1.add(9);
        l1.add(9);
        l1.add(9);
        l1.add(9);
        l1.add(9);
        l1.add(9);

        l2 = new CustomLinkedList<>();
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);

        l1.addLinkedListsII(l2);
        l1.print();

        System.out.println();

        System.out.print("Running TestCase 4:--> ");
        l1 = new CustomLinkedList<>();
        l1.add(9);
        l1.add(9);
        l1.add(9);
        l1.add(9);

        l2 = new CustomLinkedList<>();
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);
        l2.add(9);

        l1.addLinkedListsII(l2);
        l1.print();
        System.out.println();


        System.out.print("Running TestCase 5:--> ");
        l1 = new CustomLinkedList<>();
        l1.add(5);

        l2 = new CustomLinkedList<>();
        l2.add(5);

        l1.addLinkedListsII(l2);
        l1.print();
        System.out.println();

        System.out.print("Running TestCase 6:--> ");
        l1 = new CustomLinkedList<>();
        l1.add(3);
        l1.add(7);

        l2 = new CustomLinkedList<>();
        l2.add(9);
        l2.add(2);

        l1.addLinkedListsII(l2);
        l1.print();
        System.out.println();
    }
}
