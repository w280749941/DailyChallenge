package com.heartiger.challenges;

/*
This problem was asked by Microsoft.

Suppose an arithmetic expression is given as a binary tree. Each leaf is an integer and each internal node is one of '+', '−', '∗', or '/'.

Given the root to such a tree, write a function to evaluate it.

For example, given the following tree:

    *
   / \
  +    +
 / \  / \
3  2  4  5

You should return 45, as it is (3 + 2) * (4 + 5)

*/
import com.heartiger.utils.TreeNode;

public class Problem36 {

    int evalExpressionTree(TreeNode<Character> root){
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return Character.getNumericValue(root.val);

        int leftTotal = evalExpressionTree(root.left);
        int rightTotal = evalExpressionTree(root.right);

        switch (root.val){
            case '+':
                return leftTotal + rightTotal;
            case '-':
                return leftTotal - rightTotal;
            case '*':
                return leftTotal * rightTotal;
            case '/':
                return leftTotal / rightTotal;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        TreeNode<Character> root = new TreeNode<>('*');
        root.left = new TreeNode('+');
        root.right = new TreeNode('+');
        root.left.left = new TreeNode('3');
        root.left.right = new TreeNode('2');
        root.right.left = new TreeNode('4');
        root.right.right = new TreeNode('5');

        Problem36 problem = new Problem36();
        assert problem.evalExpressionTree(root)==45: "Test 1 Failed";
        System.out.println("Passed");
    }
}
