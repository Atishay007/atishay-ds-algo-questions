package com.linkedlist;

/**
 * https://leetcode.com/problems/reorder-list/description/
 * TC:O(n)
 * SC:O(1)
 * <p>
 * This question has following parts
 * 1. Find middle element: middleNode =slow.next after loop terminates.
 * 2. Make node pointing to null which is previously pointing to middle node: slow.next=null
 * 3. Reverse the LL from middle node.
 * 4. There are 2 parts of LL, now we have to merge them
 * 5. We will point newHead.next= oldNext only when OldNext is not null
 * 6. If oldNext==null then the newNode will keep pointing to its remaining nodes and loop will be terminated.
 */
public class ReorderList {
    /*
     public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast= head;

        //Finding middle node
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //Middle node
        ListNode newHead = slow.next;
        //Setting null is important for first half of LL, to distinguish
        //with second part of LL
        slow.next =null;

        //Reversing LL
        ListNode p1=null;
        ListNode p2 = newHead;
        ListNode p3 =null;

        while(p2!=null){
            p3=p2.next;
            p2.next=p1;
            p1=p2;
            p2=p3;
        }

        newHead = p1;
        ListNode oldHead=head;

        //Reorder LL or we can say merging 2 LL
        while(oldHead!=null && newHead!=null){
            ListNode oldNext= oldHead.next;
            ListNode newNext= newHead.next;

            oldHead.next = newHead;

            //V# condition
            if(oldNext!=null){
                newHead.next=oldNext;
            }

            //Shift pointers forward
            oldHead = oldNext;
            newHead = newNext;
        }
    }
}
     */
}
