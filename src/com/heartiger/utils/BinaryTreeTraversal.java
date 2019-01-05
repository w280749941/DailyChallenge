package com.heartiger.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal<T> {

    public void preOrderTraversal(TreeNode<T> root, boolean recursive){
        if (recursive)
            preOrderR(root);
        else
            preOrderI(root);

        System.out.println();
    }

    private void preOrderI(TreeNode<T> root) {
        Stack<TreeNode<T>> st = new Stack<>();
        st.push(root);
        while(!st.empty()){
            TreeNode curr = st.pop();
            System.out.print(curr.val + " ");
            if(curr.right != null)
                st.push(curr.right);
            if(curr.left != null)
                st.push(curr.left);
        }
    }

    private void preOrderR(TreeNode<T> root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preOrderR(root.left);
        preOrderR(root.right);
    }

    public void inOrderTraversal(TreeNode<T> root, boolean recursive){
        if (recursive)
            inOrderR(root);
        else
            inOrderI(root);

        System.out.println();
    }

    private void inOrderI(TreeNode<T> root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(!st.isEmpty() || curr != null) {
            if(curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = st.pop();
                System.out.print(node.val + " ");
                curr = node.right;
            }
        }
    }

    private void inOrderR(TreeNode<T> root) {
        if (root == null)
            return;

        inOrderR(root.left);
        System.out.print(root.val + " ");
        inOrderR(root.right);
    }

    public void postOrderTraversal(TreeNode<T> root, boolean recursive){
        if (recursive)
            postOrderR(root);
        else
            postOrderI(root);

        System.out.println();
    }

    private void postOrderI(TreeNode<T> root) {
        Stack<T> out = new Stack<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode<T> curr = root;
        while(!st.isEmpty() || curr != null) {
            if(curr != null) {
                st.push(curr);
                out.push(curr.val);
                curr = curr.right;
            } else {
                TreeNode node = st.pop();
                curr = node.left;
            }
        }
        while (!out.empty()){
            System.out.print(out.pop() + " ");
        }
    }

    private void postOrderR(TreeNode<T> root) {
        if (root == null)
            return;

        postOrderR(root.left);
        postOrderR(root.right);
        System.out.print(root.val + " ");
    }

    public void BFS(TreeNode<T> root) {
        if(root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
        System.out.println();
    }
}

