package com.heartiger.challenges;

import java.util.LinkedList;
import java.util.Queue;

/*
    This problem was asked by Google.

    You are given an M by N matrix consisting of booleans that represents a board. Each True boolean represents a wall. Each False boolean represents a tile you can walk on.

    Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps required to reach the end coordinate from the start. If there is no possible path, then return null. You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.

    For example, given the following board:

    [[f, f, f, f],
    [t, t, f, t],
    [f, f, f, f],
    [f, f, f, f]]

    and start = (3, 0) (bottom left) and end = (0, 0) (top left), the minimum number of steps required to reach the end is 7, since we would need to go through (1, 2) because there is a wall everywhere else on the second row.

 */
public class Problem14 {
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    /*
        The idea is to use BFS to solve this problem. As soon as we see
        the destination point, we break out loop. As we are traversing
        record the point where we come from. Use points to refer to
        the previous point and as flags to mark visited Point.
     */
    public int getShortestPath(boolean[][] walls, Point origin, Point dest){
        if(walls == null || walls.length == 0)
            return 0;

        Point[][] points = new Point[walls.length][walls[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(origin);
        points[origin.x][origin.y] = origin;
        while(!queue.isEmpty()){
            Point curr = queue.poll();
            if(curr.x == dest.x && curr.y == dest.y){
                break;
            }
            // Top
            if(curr.x > 0 && !walls[curr.x-1][curr.y] && points[curr.x-1][curr.y] == null){
                points[curr.x-1][curr.y] = curr;
                queue.offer(new Point(curr.x-1, curr.y));
            }

            // Right
            if(curr.y < walls[0].length-1 && !walls[curr.x][curr.y+1] && points[curr.x][curr.y+1] == null){
                points[curr.x][curr.y+1] = curr;
                queue.offer(new Point(curr.x, curr.y+1));
            }

            // Bottom
            if(curr.x < walls.length-1 && !walls[curr.x+1][curr.y] && points[curr.x+1][curr.y] == null){
                points[curr.x+1][curr.y] = curr;
                queue.offer(new Point(curr.x+1, curr.y));
            }

            // Left
            if(curr.y > 0 && !walls[curr.x][curr.y-1] && points[curr.x][curr.y-1] == null){
                points[curr.x][curr.y-1] = curr;
                queue.offer(new Point(curr.x, curr.y-1));
            }
        }

        // Backtracing to the origin point.
        int count = 0;
        Point point = dest;
        while(point != origin){
            point = points[point.x][point.y];
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        boolean[][] walls = new boolean[][]{
                {false,false,false,false},
                {true,true,false,true},
                {false,false,false,false},
                {false,false,false,false}
        };

        Problem14 problem = new Problem14();
        int result = problem.getShortestPath(walls, new Point(3,0), new Point(0,0));
        assert result == 7: "Test 1 Failed";

        int result2 = problem.getShortestPath(walls, new Point(3,0), new Point(0,3));
        assert result2 == 6: "Test 2 Failed";

        int result3 = problem.getShortestPath(walls, new Point(3,0), new Point(2,3));
        assert result3 == 4: "Test 3 Failed";
    }
}
