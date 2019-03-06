package com.heartiger.challenges;

import com.heartiger.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
This problem was asked by Microsoft.

Print the nodes in a binary tree level-wise. For example, the following should print 1, 2, 3, 4, 5.

  1
 / \
2   3
   / \
  4   5
*/
public class Problem73 {
    void levelTraverse(TreeNode<Integer> root){
        if(root == null)
            return;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);

        while(!qu.isEmpty()){
            int size = qu.size();
            while(size > 0){
                TreeNode node = qu.poll();
                System.out.print(node.val + " ");
                size--;
                if(node.left != null)
                    qu.offer(node.left);

                if(node.right != null)
                    qu.offer(node.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1, new TreeNode<>(2), new TreeNode<>(3));
        root.right.left = new TreeNode<>(4);
        root.right.right = new TreeNode<>(5);

        Problem73 problem = new Problem73();
        problem.levelTraverse(root);
    }
}
