package com.trees.binary;

public class SumOfAllNodesOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(15);
        root = root.addNodeinBinarySearchTree(root, 10);
        root = root.addNodeinBinarySearchTree(root, 20);
        root = root.addNodeinBinarySearchTree(root, 8);
        root = root.addNodeinBinarySearchTree(root, 12);
        root = root.addNodeinBinarySearchTree(root, 16);
        root = root.addNodeinBinarySearchTree(root, 25);

        System.out.println(root.sumOfNodes(root));
    }
}
