package com.linkedlist;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MergeKSortedLL {
    public static void main(String[] args) {
        LinkedList[] arr = new LinkedList[3];
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(4);
        ll.add(5);
        arr[0] = ll;

        ll = new LinkedList<>();
        ll.add(1);
        ll.add(3);
        ll.add(4);
        arr[1] = ll;

        ll = new LinkedList<>();
        ll.add(2);
        ll.add(6);
        arr[2] = ll;


    }
}
