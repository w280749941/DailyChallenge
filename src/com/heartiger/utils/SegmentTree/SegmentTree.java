package com.heartiger.utils.SegmentTree;

public class SegmentTree<T> {

    private TreeNode<T> root;
    private Merger<T> merger;
    private int size;

    public SegmentTree(T[] arr, Merger<T> merger){
        this.merger = merger;
        this.root = buildSegmentTree(arr, 0, arr.length-1);
        this.size = arr.length;
    }

    public T findBetween(int start, int end){
        InBoundCheck(start, end);
        if(this.root == null)
            return null;

        return findBetween(this.root, start, end);
    }

    public TreeNode update(int index, T value){
        InBoundCheck(index, index);
        if(this.root == null)
            return null;

        return update(this.root, index, value);
    }

    /** Return the root element */
    public TreeNode getRoot() {
        return this.root;
    }

    /** Return the size of current segement Tree */
    public int size(){
        return this.size;
    }

    /** Build up segment Tree recursively. Split up elements by half for both children*/
    private TreeNode<T> buildSegmentTree(T[] arr, int left, int right) {
        if(left == right)
            return new TreeNode<>(arr[left], left, right);

        TreeNode<T> root = new TreeNode<>(left, right);
        int mid = left + (right-left)/2; // Get the middle index
        root.left = buildSegmentTree(arr, left, mid); // Build up left child
        root.right = buildSegmentTree(arr, mid+1, right); // Build up right child
        root.val = merger.merge(root.left.val, root.right.val); // Store the sum of both children
        return root;
    }

    private T findBetween(TreeNode<T> node, int start, int end){
        if(node.start == start && node.end == end)
            return node.val;

        int mid = node.start + (node.end - node.start)/2;
        if(end <= mid) return findBetween(node.left, start, end);
        else if(start > mid) return findBetween(node.right, start, end);
        return merger.merge(findBetween(node.left, start, mid),findBetween(node.right, mid+1, end));
    }

    private void InBoundCheck(int start, int end) {
        if(start < 0 || end >= this.size)
            throw new IndexOutOfBoundsException(String.format("Please query between %d to %d", 0, this.size));
    }

    private TreeNode<T> update(TreeNode<T> node, int index, T value){
        // If reached the leaf node.
        if(node.start == node.end && node.end== index){
            node.val = value;
            return node;
        }

        int mid = node.start + (node.end - node.start)/2;

        // Target index in the left child
        if(index <= mid){
            TreeNode<T> updatedLeftChild = update(node.left, index, value);
            node.val = merger.merge(updatedLeftChild.val, node.right.val);
            return node;
        }

        // Target index in the right child
        TreeNode<T> updatedRightChild = update(node.right, index, value);
        node.val = merger.merge(node.left.val, updatedRightChild.val);
        return node;
    }
}