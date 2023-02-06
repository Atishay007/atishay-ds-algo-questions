package com.trees.binary;


public class Node {
    private int val;
    private Node left;
    private Node right;

    private int dia = Integer.MIN_VALUE;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Node addNodeinBinarySearchTree(Node root, int val) {
        if (root == null) {
            return root = new Node(val, null, null);
        } else if (val < root.val) {
            root.left = addNodeinBinarySearchTree(root.left, val);
        } else if (val >= root.val) {
            root.right = addNodeinBinarySearchTree(root.right, val);
        }
        return root;
    }


    //PreOrder Traversal: Left-> Root -> Right
    public void printNodesInOrder(Node root) {
        if (root == null) {
            return;
        }

        printNodesInOrder(root.left);
        System.out.print(root.val);
        printNodesInOrder(root.right);
    }


    //PreOrder Traversal: Root-> Left -> Right
    public void printNodesPreOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val);
        printNodesPreOrder(root.left);
        printNodesPreOrder(root.right);
    }

    //PostOrder Traversal: Left -> Right ->Root
    public void printNodesPostOrder(Node root) {
        if (root == null) {
            return;
        }
        printNodesPostOrder(root.left);
        printNodesPostOrder(root.right);
        //Root is always business logic.
        System.out.print(root.val);
    }

    public int countNodesPostOrder(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodesPostOrder(root.left);
        int rightCount = countNodesPostOrder(root.right);

        return (leftCount + rightCount) + 1;
    }

    //Using PostOrder Traversal
    //Left->Right->Root
    public int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int sumLeft = sumOfNodes(root.left);
        int sumRight = sumOfNodes(root.right);
        //business logic
        return sumLeft + sumRight + root.val;

    }

    public int getDiameter(Node root) {
        populateDiameter(root);
        return dia;
    }

    private int populateDiameter(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = populateDiameter(root.left);
        int rightHeight = populateDiameter(root.right);

        int maxHeight = Math.max(leftHeight, rightHeight);
        int totalNodes = leftHeight + rightHeight;
        int tempResult = Math.max(maxHeight, totalNodes);
        dia = Math.max(dia, tempResult);
        return maxHeight + 1;
    }
}
