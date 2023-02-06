package com.tries.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactFinder {
    public static void main(String[] args) {
        /*
        int[] operations = {0, 0, 1, 1};
        String[] contacts = {"hack", "hacker", "hac", "hak"};
        */

        int[] operations = {0, 1};
        String[] contacts = {"abcde", "abc"};

        List<Integer> lst = new ArrayList<>();

        //In Trie we create blank node.
        Node root = new Node();

        for (int i = 0; i < operations.length; i++) {
            if (operations[i] == 0) {
                insert(root, contacts[i]);
            } else {
                lst.add(startsWith(root, contacts[i]));
            }
        }
        int[] result = lst.stream().mapToInt(a -> a).toArray();


        System.out.println(Arrays.toString(result));
    }

    private static int startsWith(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            Node[] nodes = root.nodes;
            int index = word.charAt(i) - 'a';
            if (nodes[index] == null) {
                return 0;
            }
            root = nodes[index];
        }
        return root.countFreq;
    }

    private static void insert(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            Node[] nodes = root.nodes;
            int index = word.charAt(i) - 'a';
            if (nodes[index] == null) {
                Node newNode = new Node(word.charAt(i));
                newNode.countFreq++;
                nodes[index] = newNode;
            } else {
                nodes[index].countFreq++;
            }
            root = nodes[index];
        }
        root.isEnd = true;
    }
}


class Node {
    char value;
    boolean isEnd;
    Node[] nodes = new Node[26];
    int countFreq;

    public Node() {
    }

    public Node(char value) {
        this.value = value;
    }
}
