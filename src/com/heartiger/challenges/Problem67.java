package com.heartiger.challenges;

/*
This problem was asked by Coursera.

Given a 2D board of characters and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example, given the following board:

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
exists(board, "ABCCED") returns true, exists(board, "SEE") returns true, exists(board, "ABCB") returns false.

*/
public class Problem67 {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[r].length; c++){
                if(board[r][c] == word.charAt(0)){
                    boolean result = dfs(board, r, c, word, 0, visited);
                    if(result)
                        return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int index, boolean[][] visited){
        if(index == word.length())
            return true;

        if(r < 0 || r >=board.length || c<0 || c>=board[r].length || board[r][c] != word.charAt(index) || visited[r][c])
            return false;

        visited[r][c] = true;
        // Top
        if(dfs(board, r-1, c, word, index+1, visited))
            return true;

        // Right
        if(dfs(board, r, c+1, word, index+1, visited))
            return true;

        // Bot
        if(dfs(board, r+1, c, word, index+1, visited))
            return true;

        // Left
        if(dfs(board, r, c-1, word, index+1, visited))
            return true;

        visited[r][c] = false;
        return false;
    }

    public static void main(String[] args) {
        Problem67 problem = new Problem67();
        char[][] board = new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'}
        };

        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";

        boolean expectedResult1 = true;
        boolean expectedResult2 = true;
        boolean expectedResult3 = false;

        assert problem.exist(board, word1)==expectedResult1: "Test 1 Failed";
        assert problem.exist(board, word2)==expectedResult2: "Test 2 Failed";
        assert problem.exist(board, word3)==expectedResult3: "Test 3 Failed";
    }
}
