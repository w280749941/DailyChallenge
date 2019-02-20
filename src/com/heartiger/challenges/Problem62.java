package com.heartiger.challenges;

/*
This problem was asked by Apple.

Given a tree, find the largest tree/subtree that is a BST.

Given a tree, return the size of the largest tree/subtree that is a BST.
*/
public class Problem62 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode left, TreeNode right){
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    int maxBSTSize(TreeNode root){
        if(root == null)
            return 0;

        if(isValid(root))
            return sizeOf(root);

        return Math.max(maxBSTSize(root.left), maxBSTSize(root.right));
    }

    private int sizeOf(TreeNode root) {
        if(root == null)
            return 0;

        return sizeOf(root.left) + sizeOf(root.right) + 1;
    }

    private boolean isValid(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int minValue, int maxValue) {
        if(root == null)
            return true;

        if(root.val > maxValue || root.val < minValue)
            return false;

        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }

    public static void main(String[] args) {
        Problem62 problem = new Problem62();
        TreeNode root = new TreeNode(5, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(4));
        TreeNode root2 = new TreeNode(50, new TreeNode(30, new TreeNode(5), new TreeNode(20)), new TreeNode(60, new TreeNode(45), new TreeNode(70, new TreeNode(65), new TreeNode(80))));
        assert problem.maxBSTSize(root)==3: "Test 1 Failed";
        assert problem.maxBSTSize(root2)==5: "Test 2 Failed";
    }
}
