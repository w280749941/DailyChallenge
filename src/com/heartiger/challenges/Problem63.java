package com.heartiger.challenges;

public class Problem63 {
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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);

        return max;
    }

    private int dfs(TreeNode root){
        if(root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int sum = left + root.val + right;
        max = Math.max(max, sum);
        int returnVal = root.val + Math.max(left, right);
        return (returnVal > 0) ? returnVal : 0;
    }

    public static void main(String[] args) {
        Problem63 problem = new Problem63();
        TreeNode root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        assert problem.maxPathSum(root) == 42: "Test 1 Failed";
    }
}
