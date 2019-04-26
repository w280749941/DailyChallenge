package com.heartiger.challenges;

/*
This problem was asked by Slack.

You are given an N by M matrix of 0s and 1s. Starting from the top left corner, how many ways are there to reach the bottom right corner?

You can only move right and down. 0 represents an empty space while 1 represents a wall you cannot walk through.

For example, given the following matrix:

[[0, 0, 1],
 [0, 0, 1],
 [1, 0, 0]]
Return two, as there are only two ways to get to the bottom right:

Right, down, down, right
Down, right, down, right
The top left corner and bottom right corner will always be 0.
 */
public class Problem104 {

    private int ways = 0;
    int waysToDestination(boolean[][] board, int x, int y){
        dfs(board, x, y);
        return ways;
    }

    private void dfs(boolean[][] board, int x, int y) {
        if(x < 0 || y < 0 || x == board.length || y == board[x].length || board[x][y])
            return;

        if(x == board.length-1 && y == board[x].length-1){
            ways++;
            return;
        }

        dfs(board, x+1, y);
        dfs(board, x, y+1);
    }

    public static void main(String[] args) {
        Problem104 problem = new Problem104();
        boolean[][] board = new boolean[][]{
                new boolean[]{false, false, true},
                new boolean[]{false, false, true},
                new boolean[]{true, false, false}
        };
        int expected = 2;
        assert expected == problem.waysToDestination(board, 0, 0);
    }
}
