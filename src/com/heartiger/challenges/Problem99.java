package com.heartiger.challenges;

/*
Given a 2-D matrix representing an image, a location of a pixel in the screen and a color C, replace the color of the given pixel and all adjacent same colored pixels with C.

For example, given the following matrix, and location pixel of (2, 2), and 'G' for green:

B B W
W W W
W W W
B B B
Becomes

B B G
G G G
G G G
B B B
 */
public class Problem99 {

    void floodFill(char[][] array, int x, int y, char color){
        dfs(array, x, y, color, array[x][y]);
    }

    private void dfs(char[][] array, int x, int y, char color, char prev){
        if(x < 0 || y < 0 || x >= array.length || y >= array[0].length || array[x][y] != prev)
            return;

        array[x][y] = color;

        // left
        dfs(array, x, y-1, color, prev);

        // right
        dfs(array, x, y+1, color, prev);

        // up
        dfs(array, x-1, y, color, prev);

        // down
        dfs(array, x+1, y, color, prev);
    }

    private boolean same2DArray(char[][] expected, char[][] actual){
        for(int i=0; i<expected.length; i++){
            for(int j=0; j<expected[i].length; j++){
                if(expected[i][j] != actual[i][j])
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] array = new char[][]{
                new char[]{'B', 'B', 'W'},
                new char[]{'W', 'W', 'W'},
                new char[]{'W', 'W', 'W'},
                new char[]{'B', 'B', 'B'}
        };

        char[][] expected = new char[][]{
                new char[]{'B', 'B', 'G'},
                new char[]{'G', 'G', 'G'},
                new char[]{'G', 'G', 'G'},
                new char[]{'B', 'B', 'B'}
        };

        Problem99 problem = new Problem99();
        problem.floodFill(array, 2, 2, 'G');

        assert problem.same2DArray(expected, array): "Test 1 Failed";
    }
}
