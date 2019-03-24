package com.heartiger.challenges;

import com.heartiger.utils.leetcode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
This problem was asked by Google.

Given the root of a binary search tree, and a target K, return two nodes in the tree whose sum equals K.

For example, given the following tree and K of 20

    10
   /   \
 5      15
       /  \
     11    15
Return the nodes 5 and 15.
 */
public class Problem85 {
    TreeNode[] getNodesSumToTarget(TreeNode root, int k){
        Map<Integer, TreeNode> hm = new HashMap<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            TreeNode node = qu.poll();
            if(hm.containsKey(k-node.val)){
                return new TreeNode[]{node, hm.get(k-node.val)};
            }
            if(node.left != null){
                qu.offer(node.left);
            }
            if(node.right != null){
                qu.offer(node.right);
            }

            hm.put(node.val, node);
        }

        return new TreeNode[2];
    }

    public static void main(String[] args) {
        Problem85 problem = new Problem85();
        TreeNode root = new TreeNode(10, new TreeNode(5), new TreeNode(15, new TreeNode(11), new TreeNode(15)));
        int k = 20;
        TreeNode[] actualResult = problem.getNodesSumToTarget(root, k);
        assert actualResult.length == 2: "Test 1 Failed";
        assert actualResult[0].val == 5 || actualResult[1].val == 5: "Test 2 Failed";
        assert actualResult[0].val == 15 || actualResult[1].val == 15: "Test 3 Failed";
    }
}
