package com.linkedlist;

import java.util.PriorityQueue;

public class CustomLinkedList<T> {
    private Node head;
    private Node tail;

    static class Node<T> {
        private T val;
        private Node next;

        public Node(T val) {
            this.val = val;
        }
    }

    public CustomLinkedList add(T val) {
        Node newNode = new Node(val);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node temp = tail;
            this.tail.next = newNode;
        }
        this.tail = newNode;
        return this;
    }

    public void print() {
        Node head = this.head;

        while (head != null) {
            System.out.print(head.val);
            System.out.print(" ");
            head = head.next;
        }
    }

    private void print(Node head) {
        Node tmpHead = head;
        while (tmpHead != null) {
            System.out.print(tmpHead.val);
            System.out.print(" ");
            tmpHead = tmpHead.next;
        }
    }

    public CustomLinkedList<T> reverseLinkedList() {
        Node head = this.head;
        Node p1 = null;
        Node p2 = head;
        Node p3 = null;

        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        //p1 holds the last value
        this.head = p1;
        return this;
    }

    public void reverseUsingRecursion() {
        this.head = reverseLLUsingRecursion(this.head);
    }

    //Following BHI Approach: Base<We need Base condition to break recursion>, Hypothesis<Calling recursion>, Induction<Code> approach
    private Node reverseLLUsingRecursion(Node head) {
        if (head == null | head.next == null) {
            return head;
        }
        Node newHead = reverseLLUsingRecursion(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void reverseNodesInKGroupMatchingWithK(int k) {
        if (k == 1) {
            return;
        }
        Node tmpHead = this.head;
        int length = 0;

        length = getLength(tmpHead);

        int count = 0;
        //3 pointer strategy or reversing LL
        Node p1 = null;
        Node p2 = this.head;
        Node p3 = null;
        Node newHead = null;

        Node oldPrev = p2;

        int windowSize = k - 1;
        while (count <= windowSize) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            count++;
        }

        if (newHead == null) {
            newHead = p1;
        }

        //We have slide the window
        length = length - count;
        count = 0;
        p1 = null;

        Node newPrev = null;
        while (length >= k) {
            newPrev = p2;

            while (count <= windowSize && p2 != null) {
                p3 = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = p3;
                count++;
            }

            length = length - count;
            count = 0;

            oldPrev.next = p1;
            oldPrev = newPrev;

            p1 = null;

        }

        //Last case where remaining length is not matching
        //with k group to be reverse so we will keep that group as it is.
        if (length > 0 && length < k) {
            oldPrev.next = p2;
        }

        this.head = newHead;
    }

    public void reverseNodesInKGroup(int k) {
        if (k == 1) {
            return;
        }
        Node tmpHead = this.head;
        int length = 0;

        length = getLength(tmpHead);

        int count = 0;
        //3 pointer strategy or reversing LL
        Node p1 = null;
        Node p2 = this.head;
        Node p3 = null;
        Node newHead = null;

        Node oldPrev = p2;

        int windowSize = k - 1;
        while (count <= windowSize) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            count++;
        }

        if (newHead == null) {
            newHead = p1;
        }

        //We have slide the window
        length = length - count;
        count = 0;
        p1 = null;

        Node newPrev = null;
        while (length >= k) {
            newPrev = p2;

            while (count <= windowSize && p2 != null) {
                p3 = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = p3;
                count++;
            }

            length = length - count;
            count = 0;

            oldPrev.next = p1;
            oldPrev = newPrev;

            p1 = null;

        }

        //Last case where remaining length is not matching
        //with k group to be reverse so we will keep that group as it is.
        if (length > 0 && length < k) {
            p1 = null;
            while (p2 != null) {
                p3 = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = p3;
            }
            oldPrev.next = p1;
        }
        this.head = newHead;
    }

    public void getMiddleNode() {
        Node head = this.head;
        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next == null) {
            print(slow);
        } else {
            print(slow.next);
        }
    }

    public void deleteMiddleNode() {
        Node tmpHead = this.head;
        //Edge case
        if (tmpHead.next == null) {
            this.head = null;
            return;
        }

        Node fast = tmpHead;
        Node slow = tmpHead;
        Node prev = null;

        while (fast.next != null && fast.next.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //Odd no. of nodes
        if (fast.next == null) {
            prev.next = slow.next;
        } else {
            //Even no. of nodes
            slow.next = slow.next.next;
        }
        this.print();
    }

    public void removeNodesWithGivenValue(T val) {
        Node tmpHead = this.head;
        Node prev = null;

        if (tmpHead == null) {
            return;
        }

        if (tmpHead.val == val && tmpHead.next == null) {
            tmpHead = null;
            this.head = null;
            return;
        }

        while (tmpHead != null) {
            //If value matching with head
            if (prev == null && tmpHead.val == val) {
                this.head = tmpHead.next;
            } else if (tmpHead.val == val) {
                prev.next = tmpHead.next;
            } else {
                prev = tmpHead;
            }
            tmpHead = tmpHead.next;
        }
    }

    public void removeDuplicateNodesWhenListSorted() {
        Node tmpHead = this.head;

        if (tmpHead == null) {
            return;
        }

        if (tmpHead.next == null) {
            return;
        }

        while (tmpHead != null) {
            if (tmpHead.next != null) {
                if (tmpHead.val == tmpHead.next.val) {
                    tmpHead.next = tmpHead.next.next;
                } else {
                    tmpHead = tmpHead.next;
                }
            } else {
                break;
            }
        }
    }

    public void removeDuplicatesFromSortedList2() {
        Node tmpHead = this.head;

        if (tmpHead == null) {
            return;
        }

        if (tmpHead.next == null) {
            return;
        }

        if (tmpHead.val == tmpHead.next.val) {
            this.head = null;
        }

        Node prev = null;

        //Prev will remain on the same spot
        //it will move only when the next node value is different.
        //(tmpHead.next != null) --> this check is necessary as the last node
        //is not duplicate.
        while (tmpHead != null && tmpHead.next != null) {
            if (prev == null && tmpHead.val == tmpHead.next.val) {
                this.head = tmpHead.next.next;
                if (head != null && head.val != tmpHead.val) {
                    tmpHead = head;
                } else {
                    tmpHead.next = head;
                }
            } else if (tmpHead.val == tmpHead.next.val) {
                prev.next = tmpHead.next.next;
                tmpHead = prev.next;
            } else {
                prev = tmpHead;
                tmpHead = tmpHead.next;
            }
        }
    }

    public void reverseBetween(int left, int right) {
        if (head == null || head.next == null) {
            return;
        }

        Node tmpHead = head;
        int start = 1;
        Node prev = null;

        while (tmpHead != null && start < left) {
            prev = tmpHead;
            tmpHead = tmpHead.next;
            start++;
        }
        Node last = tmpHead;

        //Reversing LL using 3 pointer technique.
        Node p1 = null;
        Node p2 = tmpHead;
        Node p3 = null;

        while (p2 != null && start <= right) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            start++;
        }

        prev.next = p1;
        last.next = p2;
    }

    public void addLinkedLists(CustomLinkedList<T> l2) {
        Node tmpHeadL1 = this.head;
        Node tmpHeadL2 = l2.head;
        int l1Count = getLength(tmpHeadL1);

        int l2Count = getLength(tmpHeadL2);

        //Reinitializing...
        tmpHeadL1 = this.head;
        tmpHeadL2 = l2.head;
        Node mainHead = tmpHeadL1;

        if (l2Count > l1Count) {
            tmpHeadL1 = l2.head;
            tmpHeadL2 = this.head;
            mainHead = l2.head;
        }

        int carryF = 0;
        int tmpVal = -1;
        Node prev = null;

        //Let the loop run on Longest String or LL
        //If shortest LL or String is over add a null check.
        while (tmpHeadL1 != null) {
            carryF = addValueAndReturnCarryF(tmpHeadL1, tmpHeadL2, carryF);
            //Move pointer
            prev = tmpHeadL1;
            tmpHeadL1 = tmpHeadL1.next;
            //Move next pointer only when tmpHead2 is not null.
            if (tmpHeadL2 != null) {
                tmpHeadL2 = tmpHeadL2.next;
            }
        }

        //It is possible that in end carryF is remaining.
        if (carryF >= 0) {
            createAndAttachNewNode(prev, carryF);
        }

        this.head = mainHead;
    }

    private static int getLength(Node tmpHeadL1) {
        int count = 0;
        while (tmpHeadL1 != null) {
            count++;
            tmpHeadL1 = tmpHeadL1.next;
        }
        return count;
    }

    private static void createAndAttachNewNode(Node prev, int carryF) {
        Node newNode = new Node(carryF);
        prev.next = newNode;
    }

    private static int addValueAndReturnCarryF(Node tmpHeadL1, Node tmpHeadL2, int carryF) {
        int tmpVal = 0;
        //Necessary to add, so that carryF should not be 0 is there are no actual carryF
        if (carryF < 0) {
            carryF = 0;
        }
        if (null != tmpHeadL2) {
            tmpVal = (int) tmpHeadL1.val + (int) tmpHeadL2.val + carryF;
        } else {
            tmpVal = (int) tmpHeadL1.val + carryF;
        }

        tmpHeadL1.val = tmpVal % 10;
        //Reinitialize carryF as last value is used.
        carryF = -1;

        if (tmpVal >= 10) {
            carryF = tmpVal / 10;
        }
        return carryF;
    }

    /**
     * Adding 2 list by converting LL into StringBuilder
     *
     * @param l2
     * @return StringBuilder
     */
    public StringBuilder addLinkedListsUsingStringBuilder(CustomLinkedList<T> l2) {
        Node tmpHeadL1 = this.head;
        Node tmpHeadL2 = l2.head;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder result = new StringBuilder();

        while (tmpHeadL1 != null) {
            s1.append(tmpHeadL1.val);
            tmpHeadL1 = tmpHeadL1.next;
        }

        while (tmpHeadL2 != null) {
            s2.append(tmpHeadL2.val);
            tmpHeadL2 = tmpHeadL2.next;
        }

        if (s2.length() > s1.length()) {
            StringBuilder tmp = s1;
            s1 = s2;
            s2 = tmp;
        }

        int carryF = 0;
        int i = 0;
        for (; i < s1.length(); i++) {
            carryF = addValueAndGetCarryF(s1, s2, i, carryF);
        }

        if (carryF >= 0) {
            s1.append(carryF);
        }

        return s1;
    }


    private int addValueAndGetCarryF(StringBuilder s1, StringBuilder s2, int index, int carryF) {
        if (carryF < 0) {
            carryF = 0;
        }

        int tmpVal = 0;
        if (index < s2.length()) {
            tmpVal = Character.getNumericValue(s1.charAt(index)) + Character.getNumericValue(s2.charAt(index)) + carryF;
        } else {
            tmpVal = Character.getNumericValue(s1.charAt(index)) + carryF;
        }

        //V#  Character.forDigit to convert int into character.
        s1.setCharAt(index, Character.forDigit((tmpVal % 10), 10));

        if (tmpVal >= 10) {
            carryF = tmpVal / 10;
        } else {
            carryF = -1;
        }
        return carryF;
    }

    public void addLinkedListsII(CustomLinkedList<T> l2) {
        CustomLinkedList reverseL1 = this.reverseLinkedList();
        CustomLinkedList reverseL2 = l2.reverseLinkedList();

        int count1 = getLength(reverseL1.head);
        int count2 = getLength(reverseL2.head);

        Node l1Head = reverseL1.head;
        Node l2Head = reverseL2.head;

        if (count2 > count1) {
            Node tmpHead = l1Head;
            l1Head = l2Head;
            l2Head = tmpHead;
        }
        //Pointer will be use to reverseLL in end to get final result
        Node mainHead = l1Head;

        int carryF = 0;
        Node prev = null;
        //l1 will be the longest LL or String where calculation is happening.
        while (l1Head != null) {
            carryF = addLLValuesAndReturnCarryF(l1Head, l2Head, carryF);
            prev = l1Head;
            l1Head = l1Head.next;
            if (l2Head != null) {
                l2Head = l2Head.next;
            }
        }

        if (carryF >= 0) {
            Node tmpNode = new Node(carryF);
            prev.next = tmpNode;
        }

        this.head = mainHead;
        this.reverseLinkedList();
    }

    private int addLLValuesAndReturnCarryF(Node l1Head, Node l2Head, int carryF) {
        if (carryF < 0) {
            carryF = 0;
        }

        int tmpVal = 0;
        if (l2Head != null) {
            tmpVal = (int) l1Head.val + (int) l2Head.val + carryF;
        } else {
            tmpVal = (int) l1Head.val + carryF;
        }

        l1Head.val = tmpVal % 10;
        carryF = -1;
        if (tmpVal >= 10) {
            carryF = tmpVal / 10;
        }
        return carryF;
    }

    public void partitionList(int x) {
        if (this.head == null || this.head.next == null) {
            return;
        }
        Node greaterThanX = null;
        Node tmpHead = head;
        Node prev = null;
        Node mainHead = head;

        //Finding >= x value
        while (tmpHead != null) {
            if (greaterThanX == null && (int) tmpHead.val >= x) {
                greaterThanX = tmpHead;
                break;
            }
            prev = tmpHead;
            tmpHead = tmpHead.next;
        }

        Node prev2 = greaterThanX;
        Node p2 = greaterThanX.next;
        while (p2 != null) {
            if (x > (int) p2.val) {
                Node tmpNextNode = p2.next;
                if (prev == null) {
                    prev = p2;
                    prev.next = head;
                    mainHead = prev;
                } else {
                    p2.next = prev.next;
                    prev.next = p2;
                    prev = p2;
                }
                prev2.next = tmpNextNode;
                p2 = prev2;
            } else {
                prev2 = p2;
                p2 = p2.next;
            }
        }
        this.head = mainHead;
    }
}
