package com.tries.create.recursion;


public class Trie {
    public static void main(String[] args) {
        //TC: Insertion will take: O(N) -> N is the length of the String.
        //TC: Search will also take: O(N) -> N is the length of the String.
        //SC: O(N*L*26) -> N is the no. of words and L is the length and each Node class will have 26 character array.
        //Currently handling lowercase alphabets, no numeric/Special/Capital letters
        String word = "trie";
        String word2 = "atishay";
        String word3 = "mani";
        Node root = new Node();
        insert(root, word, 0);
        insert(root, word2, 0);
        insert(root, word3, 0);
        insert(root, word2 + "jain", 0);

        //Search for the word
        System.out.println("tries word present: " + search(root, "tries", 0));
        System.out.println(word + " present: " + search(root, word, 0));
        System.out.println(word2 + " present: " + search(root, word2, 0));
        System.out.println(word3 + " present: " + search(root, word3, 0));
        System.out.println("hello" + " present: " + search(root, "hello", 0));
        System.out.println("money" + " present: " + search(root, "money", 0));
        System.out.println("manii" + " present: " + search(root, "manii", 0));
        System.out.println("atishayjain present: " + search(root, "atishayjain", 0));
    }

    private static void insert(Node root, String word, int i) {
        //Recursion base case
        if (i >= word.length()) {
            root.isEnd = true;
            return;
        }

        char cha = word.charAt(i);
        int index = cha - 'a';

        Node[] nodes = root.nodes;
        if (nodes[index] == null) {
            nodes[index] = new Node(cha);
        }

        i++;
        insert(nodes[index], word, i);
    }


    private static boolean search(Node root, String word, int i) {
        //Recursion base case
        if (i >= word.length()) {
            if (root.isEnd) {
                return true;
            }
            return false;
        }

        char cha = word.charAt(i);
        int index = cha - 'a';

        Node[] nodes = root.nodes;
        if (nodes[index] == null || nodes[index].data != cha) {
            return false;
        }
        //Never increase variable in recursion call.
        i++;
        //As root n
        return search(nodes[index], word, i);
    }
}

class Node {
    char data;
    boolean isEnd;
    Node[] nodes = new Node[26];

    public Node(char data) {
        this.data = data;
    }

    public Node() {
    }
}
