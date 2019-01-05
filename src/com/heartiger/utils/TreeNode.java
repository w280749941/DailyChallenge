package com.heartiger.utils;

public class TreeNode<T>{
    public T val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(T x) {val = x;}
    public TreeNode(T x, TreeNode left, TreeNode right){
        this.val = x;
        this.left = left;
        this.right = right;
    }
}
