package com.heartiger.challenges;

import com.heartiger.utils.leetcode.TreeNode;

/*
This question was asked by BufferBox.

Given a binary tree where all nodes are either 0 or 1, prune the tree so that subtrees containing all 0s are removed.

For example, given the following tree:

   0
  / \
 1   0
    / \
   1   0
  / \
 0   0
should be pruned to:

   0
  / \
 1   0
    /
   1
We do not remove the tree at the root or its left child because it still has a 1 as a descendant.
 */
public class Problem97 {

    TreeNode prunedTree(TreeNode root){
        if(root == null)
            return null;

        if(root.left == null && root.right == null)
            return root;

        pruneTree(root);
        return root;
    }

    int pruneTree(TreeNode root){
        if(root == null)
            return 0;

        int val = 0;
        int left = pruneTree(root.left);
        if(left == 0)
            root.left = null;
        else
            val += root.left.val;

        int right = pruneTree(root.right);
        if(right == 0)
            root.right = null;
        else
            val += root.right.val;

        return root.val + val;
    }

    public static void main(String[] args) {
        Problem97 problem = new Problem97();
        TreeNode root = new TreeNode(0, new TreeNode(1), new TreeNode(0, new TreeNode(1, new TreeNode(0), new TreeNode(0)), new TreeNode(0)));
        TreeNode actualResult = problem.prunedTree(root);

        assert actualResult.right.left.left == null: "Test 1 Failed";
        assert actualResult.right.left.right == null: "Test 2 Failed";
        assert actualResult.right.right == null: "Test 3 Failed";

        assert actualResult.left.val == 1: "Test 4 Failed";
        assert actualResult.right.left.val == 1: "Test 5 Failed";
        assert actualResult.right.val == 0: "Test 6 Failed";
    }
}
