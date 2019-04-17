package com.heartiger.utils.SegmentTree;

public class TreeNode<T> {
        public T val;
        int start;
        int end;
        public TreeNode<T> left;
        public TreeNode<T> right;
        TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
        TreeNode(T val, int start, int end) {
            this.val = val;
            this.start = start;
            this.end = end;
        }
}
