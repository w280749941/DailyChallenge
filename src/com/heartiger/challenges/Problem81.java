package com.heartiger.challenges;

import com.heartiger.utils.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
This problem was asked by Facebook.

Given a binary tree, return the level of the tree with minimum sum.

 */
public class Problem81 {

    int levelWithMinimumSum(TreeNode root){
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        int level = -1;
        int sum = Integer.MAX_VALUE;
        int currentLevel = -1;
        while(!qu.isEmpty()){
            int size = qu.size();
            int localSum = 0;
            currentLevel++;
            while(size > 0){
                TreeNode node = qu.poll();
                localSum += node.val;
                size--;
                if(node.left != null)
                    qu.offer(node.left);
                if(node.right != null)
                    qu.offer(node.right);
            }
            if(sum > localSum){
                sum = localSum;
                level = currentLevel;
            }
        }
        return level;
    }

    public static void main(String[] args) {
        Problem81 problem = new Problem81();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(-1), new TreeNode(3)), new TreeNode(-5, new TreeNode(-2), new TreeNode(6)));
        assert problem.levelWithMinimumSum(root) == 1: "Test 1 Failed";
    }
}
