package com.heartiger.challenges;

import com.heartiger.utils.BST;
import com.heartiger.utils.TreeNode;

/*

This problem was asked by Dropbox.

Given the root to a binary search tree, find the second largest node in the tree.
 */
public class Problem24 {

    int count = 2;
    TreeNode result;

    private TreeNode<Integer> kthLargestNode(TreeNode root, int k){
        this.count = k;
        traverse(root);
        return result;
    }

    private void traverse(TreeNode root){
        if(root == null)
            return;

        traverse(root.right);
        count--;
        if(count == 0){
            result = root;
            return;
        }
        traverse(root.left);
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(5);
        bst.add(3);
        bst.add(11);
        bst.add(1);
        bst.add(4);
        bst.add(15);
        bst.add(9);
        bst.add(7);
        Problem24 problem = new Problem24();
        assert problem.kthLargestNode(bst.rootElement(), 2).val==11: "Test 1 Failed";
        assert problem.kthLargestNode(bst.rootElement(), 3).val==9: "Test 2 Failed";
    }
}
