package com.trees.binary;

public class CalculateDiameterOfBinaryTree {
    int dia = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node root = new Node();
        root = root.addNodeinBinarySearchTree(null, 1);

        for (int i = 2; i <= 5; i++) {
            root = root.addNodeinBinarySearchTree(root, i);
        }

        System.out.println(root.getDiameter(root));
    }
}