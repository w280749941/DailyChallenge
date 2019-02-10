package com.heartiger.challenges;

import com.heartiger.utils.TreeNode;

/*
This problem was asked by Google.

Invert a binary tree.

For example, given the following tree:

    a
   / \
  b   c
 / \  /
d   e f
should become:

  a
 / \
 c  b
 \  / \
  f e  d
*/
public class Problem56 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;

        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);

        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        Problem56 problem = new Problem56();
        TreeNode<Integer> root = new TreeNode<>(4, new TreeNode<>(2, new TreeNode<>(1), new TreeNode<>(3)), new TreeNode<>(7, new TreeNode<>(6), new TreeNode<>(9)));
        TreeNode<Integer> expected = new TreeNode<>(4, new TreeNode<>(7, new TreeNode<>(9), new TreeNode<>(6)), new TreeNode<>(2, new TreeNode<>(3), new TreeNode<>(1)));
        TreeNode actual = problem.invertTree(root);
        assert sameTree(expected, actual): "Test 1 Failed";
    }

    public static boolean sameTree(TreeNode<Integer> expected, TreeNode actual) {
        if(expected == null && actual == null)
            return true;

        if(expected == null || actual == null)
            return false;

        return expected.val.equals(actual.val) && sameTree(expected.left, actual.left) && sameTree(expected.right, actual.right);
    }
}
