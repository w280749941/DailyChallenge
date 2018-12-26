package com.heartiger.challenges;

/*

This problem was asked by Microsoft.

You have an N by N board. Write a function that, given N,
returns the number of possible arrangements of the board where N queens can be placed on the board without threatening each other,
i.e. no two queens share the same row, column, or diagonal.
 */
public class Problem26 {

    static class Location {
        int x;
        int y;
        Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    int result=0;

    int queensPlacement(int N){
        Location[] locations = new Location[N];
        helper(locations, N, 0);
        return result;
    }

    private void helper(Location[] locations, int size, int row) {

        if(row == size){
            result++;
            return;
        }

        for(int c=0; c<size; c++){
            if(!underAttack(locations, row, c)){
                locations[row] = new Location(row, c);
                helper(locations, size, row+1);
            }
        }
    }

    private boolean underAttack(Location[] locations, int row, int col) {
        for (int i=0; i<row; i++) {
            if (locations[i] != null && (sameCol(locations[i], col) || diagonal(locations[i], row, col)))
                return true;
        }
        return false;
    }

    private boolean diagonal(Location location, int row, int col) {
        return Math.abs(location.x - row) == Math.abs(location.y - col);
    }

    private boolean sameCol(Location location, int col) {
        return location.y == col;
    }

    public static void main(String[] args) {
        int boardSize = 4;
        Problem26 problem = new Problem26();

        assert problem.queensPlacement(boardSize)==2: "Test 1 Failed";
    }
}
