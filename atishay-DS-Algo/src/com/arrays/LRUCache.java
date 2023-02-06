package com.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        /*


 7 S 2 1 S 1 10 S 8 13 G 12 S 2 8 G 11 G 7 S 14 7 S 12 9 S 7 10 G 11 S 9 3 S 14 15 G 15 G 9 S 4 13 G 3 S 13 7
G 2 S 5 9 G 6 G 13 S 4 5 S 3 2 S 4 12 G 13 G 7 S 9 7 G 3 G 6 G 2 S 8 4 S 8 9 S 1 4 S 2 9 S 8 8 G 13 G 3 G 13 G 6 S 3 8 G 14 G 4 S 5 6 S 10 15
G 12 S 13 5 S 10 9 S 3 12 S 14 15 G 4 S 10 5 G 5 G 15 S 7 6 G 1 S 5 12 S 1 6 S 11 8

         */
        LRUCache cache = new LRUCache(59);
        cache.set(2, 1);
        cache.set(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.set(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

    //For holding References of DLL.
    //If we are working with multi-Threading env. then we can use ConcurrentHashMap as well.
    private Map<Integer, DoublyLinkedList> map;
    private int capacity = 0;
    DoublyLinkedList node = new DoublyLinkedList();

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        DoublyLinkedList dll = map.get(key);
        int value = 0;

        if (dll == null) {
            return -1;
        } else {
            value = dll.value;

            //deleting from map.
            map.remove(key);

            //Removing node from DLL.
            //If head to be removed.
            if (dll.prev == null) {
                node.removeFirst();
            } else {
                node.deleteNode(dll);
            }

            //Adding it in end of DLL as MRU and adding back into HashMap.
            DoublyLinkedList newNode = node.set(key, value);
            map.put(key, newNode);

            DoublyLinkedList tmpNode = map.get(key);
            return tmpNode.value;
        }
    }

    public void set(int key, int value) {
        DoublyLinkedList tmpHead = node.getHead();
        DoublyLinkedList sameKeyNode = map.get(key);

        //If we found duplicate key, but it is not head.
        if (sameKeyNode != null && sameKeyNode != tmpHead) {
            if (sameKeyNode.next == null) { //it means duplicate key is the last node which is MRU.
                sameKeyNode.value = value;
                map.put(key, sameKeyNode);
                return;
            } else {
                node.deleteNode(sameKeyNode);
            }
        }
        //Check for Map size
        else if (map.size() >= capacity) {
            //Removing from Map.
            map.remove(tmpHead.key);
            //Deleting first node of DLL.
            node.removeFirst();
        }
        //Adding and creating new Node.
        DoublyLinkedList newNode = node.set(key, value);
        map.put(key, newNode);
    }
}

class DoublyLinkedList {

    DoublyLinkedList prev;
    int key;
    int value;
    DoublyLinkedList next;
    //Head and Tail Pointer
    DoublyLinkedList head;
    DoublyLinkedList tail;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public DoublyLinkedList set(int key, int value) {
        DoublyLinkedList tmpNode = new DoublyLinkedList(key, value);

        if (head == null) {
            head = tmpNode;
        } else {
            tail.next = tmpNode;
            tmpNode.prev = tail;
        }

        tail = tmpNode;
        return tmpNode;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
            //2 conditions: If head is not null then its prev pointer should be null.
            if (head != null && head.prev != null) {
                head.prev = null;
            } else if (head == null) {
                //if head is null then tail should also be null.
                tail = null;
            }
        }
    }

    public DoublyLinkedList getHead() {
        return head;
    }

    public void deleteNode(DoublyLinkedList nodeToDelete) {
        //it means this is last node.
        if (nodeToDelete.next == null) {
            nodeToDelete.prev.next = null;
            //Adjusting tail pointer.
            tail = nodeToDelete.prev;
        } else {
            nodeToDelete.prev.next = nodeToDelete.next;
            nodeToDelete.next.prev = nodeToDelete.prev;
        }
    }
}
