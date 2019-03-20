package com.heartiger.challenges;

import com.heartiger.utils.leetcode.TreeNode;

import java.util.*;

/*
This problem was asked by Twitter.

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree. Assume that each node in the tree also has a pointer to its parent.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants
(where we allow a node to be a descendant of itself).”

 */
public class BinaryTreeLCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null)
            return null;

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        Map<TreeNode, TreeNode> hm = new HashMap<>();
        hm.put(root, null);
        while(!qu.isEmpty()){
            TreeNode curr = qu.poll();
            if(curr.left != null){
                hm.put(curr.left, curr);
                qu.offer(curr.left);
            }
            if(curr.right != null){
                hm.put(curr.right, curr);
                qu.offer(curr.right);
            }
        }

        Set<TreeNode> path = new HashSet<>();
        while(p != null){
            path.add(p);
            p = hm.get(p);
        }

        while(!path.contains(q)){
            q = hm.get(q);
        }

        return q;
    }

    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if(root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestorRecursive(root.left, p, q);
        TreeNode right = lowestCommonAncestorRecursive(root.right, p, q);

        if(left != null && right != null)
            return root;

        return left == null ? right : left;
    }

    public static void main(String[] args) {
        BinaryTreeLCA binaryTreeLCA = new BinaryTreeLCA();
        TreeNode p = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode q = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root = new TreeNode(3, p, q);
        assert binaryTreeLCA.lowestCommonAncestor(root, p, q).val == 3: "Test 1 Failed";
        assert binaryTreeLCA.lowestCommonAncestorRecursive(root, p, q).val == 3: "Test 2 Failed";
    }

}
