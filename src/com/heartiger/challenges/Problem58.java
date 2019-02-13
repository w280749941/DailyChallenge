package com.heartiger.challenges;

/*
This problem was asked by Amazon.

Given a matrix of 1s and 0s, return the number of "islands" in the matrix. A 1 represents land and 0 represents water, so an island is a group of 1s that are neighboring whose perimeter is surrounded by water.

For example, this matrix has 4 islands.

1 0 0 0 0
0 0 1 1 0
0 1 1 0 0
0 0 0 0 0
1 1 0 0 1
1 1 0 0 1
*/
public class Problem58 {

    int numOfIslands(int[][] islands){
        int count = 0;
        for(int r=0; r<islands.length; r++){
            for(int c=0; c<islands[r].length; c++){
                if(islands[r][c] == 1){
                    dfs(islands, r, c);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] islands, int r, int c) {
        if(r < 0 || r >= islands.length || c < 0 || c >= islands[r].length || islands[r][c] != 1)
            return;

        islands[r][c] = 2;

        dfs(islands, r-1, c);
        dfs(islands, r, c+1);
        dfs(islands, r+1, c);
        dfs(islands, r, c-1);
    }

    public static void main(String[] args) {
        int[][] islands = new int[][]{
                {1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {1, 1, 0, 0, 1}
        };
        int expected = 4;
        Problem58 problem = new Problem58();
        assert problem.numOfIslands(islands) == expected: "Test 1 Failed";
    }
}
