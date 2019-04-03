package com.heartiger.challenges;

import com.heartiger.utils.leetcode.TreeNode;

/*
This question was asked by Apple.

Given a binary tree, find a minimum path sum from root to a leaf.

For example, the minimum path in this tree is [10, 5, 1, -1], which has sum 15.

  10
 /  \
5    5
 \     \
   2    1
       /
     -1

 */
public class Problem92 {

    int min = Integer.MAX_VALUE;
    int getMinimumPathSum(TreeNode root){
        dfs(root, 0);
        return min;
    }

    private void dfs(TreeNode root, int val) {
        if(root == null)
            return;

        val += root.val;
        if(root.left == null && root.right == null){
            min = Math.min(min, val);
            return;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }

    public static void main(String[] args) {
        Problem92 problem = new Problem92();
        TreeNode root = new TreeNode(10, new TreeNode(5, null, new TreeNode(2)), new TreeNode(5, null, new TreeNode(1, new TreeNode(-1), null)));
        assert problem.getMinimumPathSum(root) == 15: "Test 1 Failed";
    }
}
