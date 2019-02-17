package com.heartiger.challenges;

/*
This problem was asked by LinkedIn.
Determine whether a tree is a valid binary search tree.
A binary search tree is a tree with two children, left and right, and satisfies the constraint that the key in the left child must be less than or equal to the root and the key in the rightchild must be greater than or equal to the root.
*/

public class Problem60 {
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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max){
        if(root == null)
            return true;

        if(root.val >= max || root.val <= min)
            return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        Problem60 problem = new Problem60();
        assert problem.isValidBST(root2): "Test 1 Failed";
        assert problem.isValidBST(root) == false: "Test 2 Failed";
    }
}
