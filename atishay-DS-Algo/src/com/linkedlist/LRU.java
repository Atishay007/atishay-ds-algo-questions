package com.linkedlist;

import java.util.*;

/**
 * We are using LinkedHashSet to implement LRU(Least Recently Used)
 * Add/Remove: O(1)
 * Maintains insertion order/Sequence
 * LinkedHashSet will have recent visited elements at the bottom side and
 * on top old visited elements are there.
 * <p>
 * 3 methods are important
 * refer()
 * get()
 * put()
 */
public class LRU {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.refer(1);
        lruCache.refer(2);
        lruCache.refer(3);
        lruCache.refer(1);
        lruCache.refer(4);
        lruCache.refer(5);
        lruCache.display();
    }
}

class LRUCache {
    private HashSet<Integer> lruCache;
    private int capacity = 0;

    LRUCache(int capacity) {
        lruCache = new LinkedHashSet<>(capacity);
        this.capacity = capacity;
    }

    public void refer(int key) {
        if (get(key) == false) {
            put(key);
        }
    }

    public boolean get(int key) {
        if (lruCache.contains(key)) {
            lruCache.remove(key);
            return lruCache.add(key);
        }
        return false;
    }

    public void put(int key) {
        if (lruCache.size() == capacity) {
            //Removing first element as this is oldest visited element.
            // cache.iterator() doesn't create whole list, this is O(1) operation.
            int firstKey = lruCache.iterator().next();
            lruCache.remove(firstKey);
        }
        lruCache.add(key);
    }

    public void display() {
        if (lruCache.size() > 0) {
            LinkedList<Integer> lst = new LinkedList<>(lruCache);
            Iterator<Integer> descItr = lst.descendingIterator();
            while (descItr.hasNext()) {
                System.out.println(descItr.next());
            }
        } else {
            System.out.println("Cache is empty");
        }
    }
}