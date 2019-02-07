package com.heartiger.challenges;

/*
This problem was asked by Google.

Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.

    a
   / \
  b   c
 /
d
*/
public class Problem53 {
    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char x) { val = x; }
    }

    private TreeNode maxNode;
    private int max=0;
    TreeNode maxNode(TreeNode root){
        dfs(root, 1);
        return maxNode;
    }

    private void dfs(TreeNode root, int depth){
        if(root == null)
            return;

        if(depth > max){
            max = depth;
            maxNode = root;
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode('a');
        node.left = new TreeNode('b');
        node.right = new TreeNode('c');
        node.left.left = new TreeNode('d');

        Problem53 problem = new Problem53();
        TreeNode result = problem.maxNode(node);
        assert result.val == 'd': "Test 1 Failed";
    }
}
