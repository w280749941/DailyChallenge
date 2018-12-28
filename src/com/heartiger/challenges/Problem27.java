package com.heartiger.challenges;

/*
This problem was asked by Dropbox.

Conway's Game of Life takes place on an infinite two-dimensional board of square cells. Each cell is either dead or alive, and at each tick, the following rules apply:

Any live cell with less than two live neighbours dies.
Any live cell with two or three live neighbours remains living.
Any live cell with more than three live neighbours dies.
Any dead cell with exactly three live neighbours becomes a live cell.
A cell neighbours another cell if it is horizontally, vertically, or diagonally adjacent.

Implement Conway's Game of Life. It should be able to be initialized with a starting list of live cell coordinates and the number of steps it should run for. Once initialized, it should print out the board state at each step. Since it's an infinite board, print out only the relevant coordinates, i.e. from the top-leftmost live cell to bottom-rightmost live cell.

You can represent a live cell with an asterisk (*) and a dead cell with a dot (.).
 */
public class Problem27 {

    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }

        int row = board.length;
        int col = board[0].length;

        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                int liveCells = visitAllNeighbors(board, r, c);
                updateNextState(liveCells, board, r, c);
            }
        }

        convertToNextState(board);
    }

    private int visitAllNeighbors(int[][] board, int row, int col){
        int currentLiveCells = 0;

        for(int r=Math.max(0, row-1); r<Math.min(row+2, board.length); r++){
            for(int c=Math.max(0, col-1); c<Math.min(col+2, board[r].length); c++){
                currentLiveCells += board[r][c] & 1;
            }
        }

        return currentLiveCells;
    }

    private void updateNextState(int liveCells, int[][] board, int row, int col){
        if(liveCells == 3 || liveCells-board[row][col] == 3){
            if(board[row][col] == 0){
                board[row][col] = 2;
            } else {
                board[row][col] = 3;
            }
        }
    }

    private void convertToNextState(int[][] board){
        int row = board.length;
        int col = board[0].length;

        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                board[r][c] >>= 1;
            }
        }
    }

    boolean same2DArray(int[][] arr1, int[][] arr2){
        if(arr1 == null || arr2 == null || arr1.length != arr2.length){
            return false;
        }

        for(int r=0; r<arr1.length; r++){
            for(int c=0; c<arr1[r].length; c++){
                if(arr1[r][c] != arr2[r][c])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        int[][] expectedResult = new int[][]{
                {0, 0, 0},
                {1, 0, 1},
                {0, 1, 1},
                {0, 1, 0}
        };

        Problem27 problem = new Problem27();
        problem.gameOfLife(board);
        assert problem.same2DArray(board, expectedResult): "Test 1 Failed";
    }
}
