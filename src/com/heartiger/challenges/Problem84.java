package com.heartiger.challenges;

/*
This question was asked by Zillow.

You are given a 2-d matrix where each cell represents number of coins in that cell. Assuming we start at matrix[0][0], and can only move right or down, find the maximum number of coins you can collect by the bottom right corner.

For example, in this matrix

0 3 1 1
2 0 0 4
1 5 3 1
The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.

*/
public class Problem84 {

    int getMaxCoins(int[][] coins){
        for(int r=0; r<coins.length; r++){
            for(int c=0; c<coins[r].length; c++){
                int left = c == 0 ? 0 : coins[r][c-1];
                int up = r == 0 ? 0 : coins[r-1][c];
                int currMax = coins[r][c] + Math.max(left, up);
                coins[r][c] = currMax;
            }
        }

        return coins[coins.length-1][coins[0].length-1];
    }

    public static void main(String[] args) {
        Problem84 problem = new Problem84();
        int[][] coins = new int[][]{
                {0, 3, 1, 1},
                {2, 0, 0, 4},
                {1, 5, 3, 1}
        };
        int expectedCoins = 12;
        assert expectedCoins == problem.getMaxCoins(coins): "Test 1 Failed";
    }
}
