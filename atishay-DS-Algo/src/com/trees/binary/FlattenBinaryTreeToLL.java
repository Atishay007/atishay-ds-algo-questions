package com.trees.binary;

import java.util.LinkedList;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
public class FlattenBinaryTreeToLL {
    public static void main(String[] args) {

    }
/*
    class Solution {
        Queue<TreeNode> queue = new LinkedList<>();

        public void flatten(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return;
            }

            addNodeInQueue(root);
            flattenBinaryTreeIntoLL(queue);
        }

        private void flattenBinaryTreeIntoLL(Queue<TreeNode> queue) {
            TreeNode head = queue.poll();
            head.left = null;
            TreeNode prev = head;

            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                tmp.left = null;
                prev.right = tmp;
                prev = tmp;
            }
        }

        //PreOrder Traversal: Root:Business logic:->Left->Right
        private void addNodeInQueue(TreeNode root) {
            if (root == null) {
                return;
            }

            queue.add(root);
            addNodeInQueue(root.left);
            addNodeInQueue(root.right);

        }
    }
 */
}
