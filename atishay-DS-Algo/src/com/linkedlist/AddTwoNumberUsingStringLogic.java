package com.linkedlist;

public class AddTwoNumberUsingStringLogic {
    public static void main(String[] args) {
        CustomLinkedList<Integer> l1 = new CustomLinkedList<>();
        CustomLinkedList<Integer> l2 = new CustomLinkedList<>();

        System.out.print("Running TestCase 1:--> ");
        l1.add(2);
        l1.add(4);
        l1.add(3);

        l2.add(5);
        l2.add(6);
        l2.add(4);

        StringBuilder builder = l1.addLinkedListsUsingStringBuilder(l2);
        CustomLinkedList<Integer> finalLL = getFinalLL(builder);
        finalLL.print();
        System.out.println();

        System.out.print("Running TestCase 2:--> ");
        l1 = new CustomLinkedList<>();
        l1.add(0);

        l2 = new CustomLinkedList<>();
        l2.add(0);
        builder = l1.addLinkedListsUsingStringBuilder(l2);
        finalLL = getFinalLL(builder);
        finalLL.print();
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
        builder = l1.addLinkedListsUsingStringBuilder(l2);
        finalLL = getFinalLL(builder);
        finalLL.print();
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
        builder = l1.addLinkedListsUsingStringBuilder(l2);
        finalLL = getFinalLL(builder);
        finalLL.print();
        System.out.println();


        System.out.print("Running TestCase 5:--> ");
        l1 = new CustomLinkedList<>();
        l1.add(5);

        l2 = new CustomLinkedList<>();
        l2.add(5);
        builder = l1.addLinkedListsUsingStringBuilder(l2);
        finalLL = getFinalLL(builder);
        finalLL.print();
        System.out.println();

        System.out.print("Running TestCase 6:--> ");
        l1 = new CustomLinkedList<>();
        l1.add(3);
        l1.add(7);

        l2 = new CustomLinkedList<>();
        l2.add(9);
        l2.add(2);
        builder = l1.addLinkedListsUsingStringBuilder(l2);
        finalLL = getFinalLL(builder);
        finalLL.print();
        System.out.println();
    }

    private static CustomLinkedList<Integer> getFinalLL(StringBuilder builder) {
        CustomLinkedList<Integer> finalLL = new CustomLinkedList<>();
        for (int i = 0; i < builder.length(); i++) {
            finalLL.add(Character.getNumericValue(builder.charAt(i)));
        }
        return finalLL;
    }
}
