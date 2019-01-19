package com.heartiger.challenges;

/*
This problem was asked by Facebook.

There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways of starting at the top-left corner and getting to the bottom-right corner. You can only move right or down.

For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to the bottom-right:

Right, then down
Down, then right
Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.

*/
public class Problem42 {

    int numWays(int[][] grid){
        if(grid == null || grid.length == 0)
            return 0;

        grid[0][0] = 1;
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[r].length; c++){
                int fromLeft = c-1 < 0 ? 0: grid[r][c-1];
                int fromUp = r-1 < 0 ? 0: grid[r-1][c];
                grid[r][c] = fromLeft + fromUp + grid[r][c];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int r = 2;
        int c = 2;
        int[][] grid1 = new int[r][c];
        int expected1 = 2;

        int r2 = 5;
        int c2 = 5;
        int[][] grid2 = new int[r2][c2];
        int expected2 = 70;

        Problem42 problem = new Problem42();
        assert problem.numWays(grid1)==expected1: "Test 1 Failed";
        assert problem.numWays(grid2)==expected2: "Test 2 Failed";
    }
}
