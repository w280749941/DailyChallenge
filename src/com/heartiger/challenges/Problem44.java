package com.heartiger.challenges;

/*
This problem was asked by Amazon.

Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.

For example, given the following matrix:

[[1,  2,  3,  4,  5],
 [6,  7,  8,  9,  10],
 [11, 12, 13, 14, 15],
 [16, 17, 18, 19, 20]]
You should print out the following:

1
2
3
4
5
10
15
20
19
18
17
16
11
6
7
8
9
14
13
12
*/

public class Problem44 {
    void printDataInSpiralOrder(int[][] nums){
        if(nums == null || nums.length==0)
            return;

        // lower bound and upper bound
        int rl = 0;
        int cl = 0;
        int ru = nums.length-1;
        int cu = nums[0].length-1;

        while(rl <= ru && cl <= cu){
            for(int c=cl; c<=cu; c++)
                System.out.println(nums[rl][c]);
            for(int r=rl+1; r<=ru; r++)
                System.out.println(nums[r][cu]);
            if (rl < ru && cl < cu) {
                for (int c = cu - 1; c > cl; c--)
                    System.out.println(nums[ru][c]);
                for (int r = ru; r > rl; r--)
                    System.out.println(nums[r][cl]);
            }
            rl++;
            ru--;
            cl++;
            cu--;
        }
    }

    public static void main(String[] args) {
        int[][] example = new int[][]{
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        Problem44 problem = new Problem44();
        problem.printDataInSpiralOrder(example);

        int[][] example2 = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        problem.printDataInSpiralOrder(example2);

        int[][] example3 = new int[][]{
                {3},
                {2}
        };
        problem.printDataInSpiralOrder(example3);

        int[][] example4 = new int[][]{
                {6,9,7}
        };
        problem.printDataInSpiralOrder(example4);
    }
}
