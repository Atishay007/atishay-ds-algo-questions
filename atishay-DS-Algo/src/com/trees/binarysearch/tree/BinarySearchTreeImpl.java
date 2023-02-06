package com.trees.binarysearch.tree;

import com.trees.binary.Node;

public class BinarySearchTreeImpl {
    public static void main(String[] args) {
        Node root = new Node();
        root = root.addNodeinBinarySearchTree(null, 2);
        root = root.addNodeinBinarySearchTree(root, 1);
        root = root.addNodeinBinarySearchTree(root, 3);
    }
}
