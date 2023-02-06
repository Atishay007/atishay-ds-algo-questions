package com.tries.questions;

import java.util.Arrays;

public class SpellingChecker {
    public static void main(String[] args) {
        //   String[] dic = {"hat", "cat", "rat"};
        // String[] words = {"cat", "ball"};

        String[] dic = {"tape", "bcci"};
        String[] words = {"table", "cci"};

        int[] result = new int[words.length];

        //We have to create root node.
        Node root = new Node();

        for (int i = 0; i < dic.length; i++) {
            insert(root, dic[i]);
        }

        for (int i = 0; i < words.length; i++) {
            result[i] = search(root, words[i]);
        }

        System.out.println(Arrays.toString(result));
    }

    private static int search(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            Node[] nodes = root.nodes;
            if (nodes[index] == null) {
                return 0;
            }
            root = nodes[index];
        }

        return root.isEnd ? 1 : 0;
    }

    private static void insert(Node root, String word) {
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            Node[] nodes = root.nodes;
            if (nodes[index] == null) {
                Node newNode = new Node(word.charAt(i));
                newNode.countFreq++;
                nodes[index] = new Node();
            } else {
                nodes[index].countFreq++;
            }
            //Shifting to next pointer.
            root = nodes[index];
        }
        root.isEnd = true;
    }
}
