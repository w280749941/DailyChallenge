package com.heartiger.challenges;

/*
This problem was asked by Amazon.

Given a node in a binary search tree, return the next bigger element, also known as the inorder successor.

For example, the inorder successor of 22 is 30.

   10
  /  \
 5    30
     /  \
   22    35
You can assume each node has a parent pointer.
 */
public class Problem91 {
    static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;

        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode getSuccessorNode(TreeNode root, int target){
        if(root == null)
            return null;

        TreeNode node = getTarget(root, target);
        if(node == null)
            return null;
        if(node.right == null)
            return node.parent.val > node.val ? node.parent : null;

        return node.right;
    }

    private TreeNode getTarget(TreeNode root, int target) {
        if(root == null)
            return null;

        if(root.val == target)
            return root;

        if(root.val > target)
            return getTarget(root.left, target);

        return getTarget(root.right, target);
    }

    public static void main(String[] args) {
        Problem91 problem = new Problem91();
        TreeNode node5 = new TreeNode(5);
        TreeNode node22 = new TreeNode(22);
        TreeNode node35 = new TreeNode(35);
        TreeNode node30 = new TreeNode(30);
        node30.left = node22;
        node30.right = node35;
        TreeNode root = new TreeNode(10);
        root.left = node5;
        root.right = node30;
        node30.parent = root;
        node5.parent = root;
        node22.parent = node30;
        node35.parent = node30;
        assert problem.getSuccessorNode(root, 22).val == 30;
        assert problem.getSuccessorNode(root, 30).val == 35;
        assert problem.getSuccessorNode(root, 35) == null;
    }
}
