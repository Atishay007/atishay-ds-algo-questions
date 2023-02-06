package com.trees.binary;

public class CountNodes {
    public static void main(String[] args) {
        Node root = new Node(1);
        root = root.addNodeinBinarySearchTree(root, 2);
        root = root.addNodeinBinarySearchTree(root, 3);
        // root = root.addNodeinBinarySearchTree(root, 3);
        //   root = root.addNodeinBinarySearchTree(root, 4);
        // root = root.addNodeinBinarySearchTree(root, 5);
        // root = root.addNodeinBinarySearchTree(root, 6);

        root.printNodesPreOrder(root);

        System.out.println();

        System.out.println(root.countNodesPostOrder(root));
    }
}
