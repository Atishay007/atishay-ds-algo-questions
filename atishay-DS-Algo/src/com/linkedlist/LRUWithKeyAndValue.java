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
public class LRUWithKeyAndValue {

    public static void main(String[] args) {
        LRUCacheWithKeyAndValue lruCache = new LRUCacheWithKeyAndValue(2);
        System.out.println("null");
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.put(2, 6));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.put(1, 5));
        System.out.println(lruCache.put(1, 2));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}

class LRUCacheWithKeyAndValue {
    private HashMap<Integer, Integer> lruCache;
    private int capacity = 0;

    LRUCacheWithKeyAndValue(int capacity) {
        lruCache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    /*
    public void refer(int key) {
        if (get(key) == -1) {
            put(key);
        }
    }
     */

    public int get(int key) {
        if (lruCache.containsKey(key)) {
            return addKeyToLast(key, null);
        }
        return -1;
    }

    private int addKeyToLast(int key, Integer newVal) {
        int val = 0;
        if (newVal != null) {
            val = newVal;
        } else {
            val = lruCache.get(key);
        }
        //removing the existing key
        lruCache.remove(key);
        //Adding key again at bottom as it is recently used.
        lruCache.put(key, val);
        return val;
    }

    /**
     * 3 Steps
     * 1. If key is already present then update the exisitng key with new val and update its position to last.
     * 2. If key is not present then:
     * If size of LL ==capacity then delete the top entry and add new entry(default added in last in LL)
     * If size != capacity then simply add new entry.
     *
     * @param key: old or new key
     * @param val
     * @return
     */
    public Integer put(int key, int val) {
        //Check if key already present
        if (lruCache.containsKey(key)) {
            addKeyToLast(key, val);
        } else {
            //New key-value scenario
            if (lruCache.size() == capacity) {
                /*
                Removing first element as this is oldest visited element.
                Cache.iterator() doesn't create whole list, this is O(1) operation.
                 */
                Map.Entry<Integer, Integer> firstKey = lruCache.entrySet().iterator().next();
                lruCache.remove(firstKey.getKey());
                lruCache.put(key, val);
            } else {
                lruCache.put(key, val);
            }
        }
        return null;
    }

    public void display() {
        if (lruCache.size() > 0) {
            LinkedList<Integer> lst = new LinkedList<>(lruCache.keySet());
            Iterator<Integer> descItr = lst.descendingIterator();
            while (descItr.hasNext()) {
                System.out.println(descItr.next());
            }
        } else {
            System.out.println("Cache is empty");
        }
    }
}