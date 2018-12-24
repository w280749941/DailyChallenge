package com.heartiger.utils;

public class BST<T extends Comparable<T>> {

    private int size;
    private TreeNode root;

    public BST() {}

    public TreeNode rootElement(){
        return this.root;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // Add a new item to the BST and return a new root.
    public TreeNode add(T item){
        this.root = add(this.root, item);
        return this.root;
    }

    // Complexity O(logn)
    private TreeNode add(TreeNode<T> node, T item) {
        if (node == null){
            size++;
            return new TreeNode(item);
        }

        // Check right if item value greater than current node value
        // Check left if item value lesser than current node value
        if (item.compareTo(node.val) > 0) {
            node.right = add(node.right, item);
        } else if (item.compareTo(node.val) < 0) {
            node.left = add(node.left, item);
        }

        return node;
    }

    // Check whether the current tree contains such item.
    public boolean contains(T item){
        return contains(this.root, item);
    }

    // Complexity O(logn)
    private boolean contains(TreeNode<T> node, T item){
        if (node == null)
            return false;
        else if (node.val.equals(item))
            return true;
        else if (item.compareTo(node.val) > 0)
            return contains(node.right, item);

        return contains(node.left, item);
    }

    // Return the minimum of the current BST.
    // Complexity O(logn)
    public TreeNode minimum(){
        TreeNode min = this.root;
        while(min.left != null)
            min = min.left;
        return min;
    }

    // Return the maximum of the current BST.
    // Complexity O(logn)
    public TreeNode maximum(){
        TreeNode max = this.root;
        while(max.right != null)
            max = max.right;
        return max;
    }

    // Return the minimum of the current node as the root.
    public TreeNode minimum(TreeNode node){
        TreeNode min = node;
        while(min.left != null)
            min = min.left;
        return min;
    }

    // Return the maximum of the current node as the root.
    public TreeNode maximum(TreeNode node){
        TreeNode max = node;
        while(max.right != null)
            max = max.right;
        return max;
    }

    // Remove the minimum value
    // Complexity O(logn)
    public void removeMin(){
        if(this.root == null)
            return;

        TreeNode minNode = minimum();
        // If root is the minimum, then root has no left child.
        if(minNode == root){
            this.root = root.right;
            size--;
            return;
        }

        // Keep going left until we find the min node.
        TreeNode curr = root;
        while(curr.left != minNode)
            curr = curr.left;

        // If the minimum node has a right child, we use it to replace min.
        if(curr.left.right != null){
            curr.left = curr.left.right;
            curr.left.right = null;
        } else
            curr.left = null;
        this.size--;
    }

    // Remove the maximum value
    // Complexity O(logn)
    public void removeMax(){
        if(this.root == null)
            return;

        TreeNode maxNode = maximum();

        // If root is the maximum, then root has no right child.
        if(maxNode == root){
            this.root = root.left;
            size--;
            return;
        }

        // Keep going right until we find the max node.
        TreeNode curr = root;
        while(curr.right != maxNode)
            curr = curr.right;

        // If the maximum node has a left child, we use it to replace max.
        if(curr.right.left != null){
            curr.right = curr.right.left;
            curr.right.left = null;
        } else
            curr.right = null;
        this.size--;
    }

    // Find the parent of an item.
    public TreeNode parent(T item){
        if(root == null || root.val.equals(item))
            return null;

        return parent(root, item);
    }

    // Complexity O(logn)
    private TreeNode parent(TreeNode<T> node, T item){
        if(node.left.val.equals(item) || node.right.val.equals(item))
            return node;
        else if (item.compareTo(node.val) > 0)
            return parent(node.right, item);
        else if (item.compareTo(node.val) < 0)
            return parent(node.left, item);

        return null;
    }

    // Remove an item in the current BST
    public void remove(T item){
        if(root == null || !contains(item))
            return;
        else if(root.val.equals(item)){
            TreeNode<T> minNode = minimum(root.right);
            remove(minNode.val);
            root.val = minNode.val;
            return;
        }
        this.removeNode(this.root, item);
    }

    private void removeNode(TreeNode<T> node, T item){
        if(node == null)
            return;
        else if (item.compareTo(node.val) > 0){
            removeNode(node.right, item);
        } else if (item.compareTo(node.val) < 0){
            removeNode(node.left, item);
        } else {
            TreeNode parent = parent(node.val);
            // Both children are null
            if(node.left == null && node.right == null){
                if(parent.left.val.equals(item))
                    parent.left = null;
                else
                    parent.right = null;
            }// left is null
            else if(node.left == null){
                if(parent.left.val.equals(item))
                    parent.left = node.right;
                else
                    parent.right = node.right;
            }// right is null
            else if(node.right == null){
                if(parent.left.val.equals(item))
                    parent.left = node.left;
                else
                    parent.right = node.left;
            }// both are not null, find the bigger min on the right child, use it as root.
            else {
                if(parent.left.val.equals(item)){
                    TreeNode minNode = minimum(parent.right.right);
                    minNode.left = parent.left.left;
                    parent.left = minNode;

                }
                else{
                    TreeNode minNode = minimum(parent.right.right);
                    minNode.left = parent.right.left;
                    parent.right = minNode;
                }
            }
            size--;
        }
    }
}
