package com.heartiger.challenges;

import com.heartiger.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.heartiger.challenges.Problem38.sameList;

/*
This problem was asked by Facebook.

Given a binary tree, return all paths from the root to leaves.

For example, given the tree:

   1
  / \
 2   3
    / \
   4   5
Return [[1, 2], [1, 3, 4], [1, 3, 5]].
*/
public class Problem75 {

    List<List<Integer>> getAllPathsFromRoot(TreeNode<Integer> root){
        List<List<Integer>> result = new ArrayList<>();
        if(root != null)
            dfs(root, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode<Integer> root, List<Integer> temp, List<List<Integer>> result) {
        if(root == null)
            return;

        temp.add(root.val);

        if(root.left == null && root.right == null)
            result.add(new ArrayList<>(temp));

        dfs(root.left, temp, result);
        dfs(root.right, temp, result);
        temp.remove(temp.size()-1);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1, new TreeNode<>(2),
                new TreeNode<>(3, new TreeNode<>(4), new TreeNode<>(5)));

        Problem75 problem = new Problem75();
        List<List<Integer>> actualResult = problem.getAllPathsFromRoot(root);
        List<List<Integer>> expectedResult = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(1, 3, 4),
                Arrays.asList(1, 3, 5)
        );
        assert sameList(expectedResult, actualResult): "Test 1 Failed";
    }
}
