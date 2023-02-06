package com.linkedlist;

import java.util.PriorityQueue;

public class SortList {
    public static void main(String[] args) {
        Node node = new Node(-1);
        node.add(5);
        node.add(3);
        node.add(4);
        node.add(0);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.getVal() - b.getVal());

        while (node != null) {
            pq.add(node);
            node = node.next;
        }

        Node newHead = pq.poll();
        Node tmpHead = newHead;

        while (pq.size() > 0) {
            Node localHead = pq.poll();
            localHead.next = null;
            tmpHead.next = localHead;
            tmpHead = localHead;
        }

        tmpHead.next = null;

        newHead.printNodes(newHead);

    }

    private static class Node {
        private int val;
        private Node next;
        private Node head;
        private Node tail;

        private Node(int val) {
            this.val = val;
            this.head = this;
            this.tail = this;
        }

        private void add(int val) {
            Node newNode = new Node(val);
            tail.next = newNode;
            tail = newNode;
        }

        private void printNodes(Node head) {
            while (head != null) {
                System.out.println(head.getVal());
                head = head.next;
            }
        }

        public int getVal() {
            return val;
        }
    }
}
