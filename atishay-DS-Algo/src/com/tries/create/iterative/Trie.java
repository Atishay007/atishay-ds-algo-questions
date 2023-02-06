package com.tries.create.iterative;

import java.util.Arrays;

public class Trie {
    public static void main(String[] args) {
        String[] strs = {"zebra", "dog", "duck", "dove"};
        String[] prefixes = new String[strs.length];
        Node root = new Node();
        for (int i = 0; i < strs.length; i++) {
            insert(root, strs[i]);
        }

        for (int i = 0; i < strs.length; i++) {
            prefixes[i] = findShortestUniquePrefix(root, strs[i]);
        }

        //Searching from Trie
        for (int i = 0; i < strs.length; i++) {
            System.out.println("Is " + strs[i] + " word present: " + search(root, strs[i]));
            System.out.println(search(root, strs[i] + "aaa"));
        }

        System.out.println("Word present with prefix: " + startsWith(root, "dov"));

        System.out.println(Arrays.toString(prefixes));
    }

    public static boolean startsWith(Node root, String prefix) {
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            Node[] nodes = root.nodes;
            Node tmpNode = nodes[index];
            if (tmpNode == null || tmpNode.value != prefix.charAt(i)) {
                return false;
            }
            //like LinkedList, we have to move to next node.
            root = tmpNode;
        }
        return true;
    }

    private static boolean search(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            Node[] nodes = root.nodes;
            Node tmpNode = nodes[index];
            if (tmpNode == null) {
                return false;
            }
            //like LinkedList, we have to move to next node.
            root = tmpNode;
        }

        if (root.isEnd) {
            return true;
        } else {
            return false;
        }
    }

    private static String findShortestUniquePrefix(Node root, String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            Node[] nodes = root.nodes;
            Node tmpNode = nodes[index];
            builder.append(tmpNode.value);
            if (tmpNode.freqCount == 1) {
                break;
            }
            //like LinkedList, we have to move to next node.
            root = tmpNode;
        }
        return builder.toString();
    }

    private static void insert(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            int index = character - 'a';
            Node[] nodes = root.nodes;
            if (nodes[index] == null) {
                Node newNode = new Node(character);
                newNode.freqCount++;
                nodes[index] = newNode;
            } else {
                Node tmpNode = nodes[index];
                tmpNode.freqCount++;
            }
            //like LinkedList, we have to move to next node.
            root = nodes[index];
        }
        //Marking end of word.
        root.isEnd = true;
    }
}


class Node {
    int freqCount = 0;
    boolean isEnd = false;
    char value;
    Node[] nodes = new Node[26];

    public Node(char value) {
        this.value = value;
    }

    public Node() {
    }
}
