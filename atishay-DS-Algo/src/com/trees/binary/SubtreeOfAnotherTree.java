package com.trees.binary;

//https://leetcode.com/problems/subtree-of-another-tree/description/
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {

    }

    /*
    class Solution {
    //PreOrder traversal
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }

        //Possibility when both root and same root are same.
        if(isSameTree(root,subRoot)){
            return true;
        }

        //Possibility given subroot is present on left or right side.
        //IN QUESTION: The tree could also be considered as a subtree of itself.
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    //PreOrder Traversal
    private boolean isSameTree(TreeNode root, TreeNode subRoot){
        //This condition should come on first.
        if(root==null && subRoot==null){
            return true;
        }else if((root==null || subRoot==null)){
            return false;
        }

         if(root.val!=subRoot.val){
             return false;
         }

        return isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right);
    }
}
     */
}
