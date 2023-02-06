package com.linkedlist;

/*
https://leetcode.com/problems/linked-list-cycle/description/
Using Fast and slow pointer algo.
Floyd's tortoise and haire algo.
 */
public class LinkedListCycle {
    /*

    public static void main(String[] args) {
        public boolean hasCycle (ListNode head){
            if (head == null || head.next == null) {
                return false;
            }

            //Floyd's tortoise and haire algo
            //It is expected that if there is a cycle then at some point fast and slow pointer will match
            //Otherwise fast pointer will reach to null.
            ListNode slow = head;
            ListNode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return true;
                }
            }

            return false;
        }
        
     */
    }