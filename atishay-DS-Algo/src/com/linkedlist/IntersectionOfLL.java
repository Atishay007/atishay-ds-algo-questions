package com.linkedlist;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 * TC:O(n), SC:O(1)
 */
public class IntersectionOfLL {
    public static void main(String[] args) {

    }
}

/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lst1Len= getLength(headA);
        int lst2Len= getLength(headB);
        int timesToMove=0;

        if(lst1Len>lst2Len){
            timesToMove =lst1Len-lst2Len;
            headA= moveNode(headA,timesToMove);
        }else if(lst2Len>lst1Len){
            timesToMove =lst2Len-lst1Len;
            headB= moveNode(headB,timesToMove);
        }

        while(headA!=null && headB!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }

        return null;
    }

    private ListNode moveNode(ListNode head, int timesToMove){
        while(timesToMove>0){
            head=head.next;
            timesToMove--;
        }
        return head;
    }

    private int getLength(ListNode head){
        ListNode tmpHead=head;
        int len=0;

        while(tmpHead!=null){
            len++;
            tmpHead=tmpHead.next;
        }
        return len;
    }
    */
