package com.heartiger.challenges;

import java.util.*;

/*
This problem was asked by Google.

You are in an infinite 2D grid where you can move in any of the 8 directions:

 (x,y) to
    (x+1, y),
    (x - 1, y),
    (x, y+1),
    (x, y-1),
    (x-1, y-1),
    (x+1,y+1),
    (x-1,y+1),
    (x+1,y-1)
You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

Example:

Input: [(0, 0), (1, 1), (1, 2)]
Output: 2
It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
*/
public class Problem69 {
    int numOfSteps(List<int[]> points){
        int count = 0;
        for(int i=1; i<points.size(); i++){
            int steps = minDistance(points.get(i-1), points.get(i));
            count+=steps;
        }
        return count;
    }

    private int minDistance(int[] source, int[] dest) {
        return Math.max(dest[0]-source[0], dest[1]-source[1]);
    }

    public static void main(String[] args) {
        List<int[]> example = Arrays.asList(new int[]{0,0}, new int[]{1,1}, new int[]{1,2});
        int result = 2;
        Problem69 problem = new Problem69();
        assert problem.numOfSteps(example)==result: "Test 1 Failed";
    }
}
