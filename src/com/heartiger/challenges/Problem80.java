package com.heartiger.challenges;

import com.heartiger.utils.leetcode.TreeNode;

/*
This problem was asked by Google.

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
A subtree of s is a tree consists of a node in s and all of this node's descendants.
The tree s could also be considered as a subtree of itself.
*/
public class Problem80 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;

        if(s == null || t == null)
            return false;

        return sameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean sameTree(TreeNode a, TreeNode b){
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;

        return a.val == b.val && sameTree(a.left, b.left) && sameTree(a.right, b.right);
    }

    public static void main(String[] args) {
        Problem80 problem = new Problem80();
        TreeNode s = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode t = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        assert problem.isSubtree(s, t): "Test 1 Failed";
    }
}