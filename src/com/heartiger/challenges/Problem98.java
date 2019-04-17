package com.heartiger.challenges;

import com.heartiger.utils.BinaryTreeTraversal;
import com.heartiger.utils.SegmentTree.Merger;
import com.heartiger.utils.SegmentTree.SegmentTree;
import com.heartiger.utils.SegmentTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
This problem was asked by Goldman Sachs.

Given a list of numbers L, implement a method sum(i, j) which returns the sum from the sublist L[i:j] (including i, excluding j).

For example, given L = [1, 2, 3, 4, 5], sum(1, 3) should return sum([2, 3]), which is 5.

You can assume that you can do some pre-processing. sum() should be optimized over the pre-processing step.
 */
public class Problem98 {

    private SegmentTree<Integer> segmentTree;

    Problem98(Integer[] array){
        this.segmentTree = new SegmentTree<>(array, Integer::sum);
    }

    int getValByRange(int start, int end){
        return this.segmentTree.findBetween(start, end-1);
    }


    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        Problem98 problem98 = new Problem98(array);
        assert problem98.getValByRange(1, 3) == 5: "Test 1 Failed";
        assert problem98.getValByRange(3, 4) == 4: "Test 2 Failed";
    }
}
