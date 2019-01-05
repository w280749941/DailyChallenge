package com.heartiger.challenges;

import com.heartiger.utils.BinaryTreeTraversal;
import com.heartiger.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
This problem was asked by Google.

Given pre-order and in-order traversals of a binary tree, write a function to reconstruct the tree.

For example, given the following pre-order traversal:

[a, b, d, e, c, f, g]

And the following inorder traversal:

[d, b, e, a, f, c, g]

You should return the following tree:

    a
   / \
  b   c
 / \ / \
d  e f  g

*/
public class Problem34 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Queue<Integer> queue = new LinkedList<>();
        for(int num: preorder)
            queue.offer(num);

        TreeNode root = buildBinaryTree(queue, inorder, 0, inorder.length);
        return root;
    }

    private TreeNode buildBinaryTree(Queue<Integer> queue, int[] inorder, int left, int right) {
        if(queue.isEmpty() || left >= right)
            return null;
        int rootVal = queue.poll();
        TreeNode<Integer> root = new TreeNode<>(rootVal);
        int index = -1;
        for(int i=left; i<right; i++){
            if(inorder[i] == rootVal){
                index = i;
                break;
            }
        }

        root.left = buildBinaryTree(queue, inorder, left, index);
        root.right = buildBinaryTree(queue, inorder, index+1, right);
        return root;
    }

    public static void main(String[] args) {
        Problem34 problem = new Problem34();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode root = problem.buildTree(preorder, inorder);
        BinaryTreeTraversal<Integer> binaryTreeTraversal = new BinaryTreeTraversal<>();
        binaryTreeTraversal.preOrderTraversal(root, true);
        binaryTreeTraversal.inOrderTraversal(root, true);
    }
}
