package com.trees.binary;

//https://leetcode.com/problems/same-tree/description/
public class SameTreeEasy {
    public static void main(String[] args) {
    }
    //PreOrder Traversal
       /* public boolean isSameTree(TreeNode p, TreeNode q) {
            //This condition should come on first.
            if(p==null && q==null){
                return true;
            }else if(p==null||q==null){
                return false;
            }

            if(p.val!=q.val){
                return false;
            }

            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        */
}
