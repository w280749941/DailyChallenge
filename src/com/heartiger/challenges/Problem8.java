package com.heartiger.challenges;

/*

This problem was asked by Amazon.
There's a staircase with N steps, and you can climb 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

For example, if N is 4, then there are 5 unique ways:

1, 1, 1, 1
2, 1, 1
1, 2, 1
1, 1, 2
2, 2
What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time. Generalize your function to take in X.

*/

public class Problem8 {

    private int climb(int stair, int[] steps){
        int dp[] = new int[stair+1];
        for(int step: steps){
            if(step <= stair)
                dp[step-1] = 1;
        }

        return climbdp(stair, dp, steps);
    }

    private int climbdp(int stair, int[] map, int[] steps){

        if(map[stair] != 0){
            return map[stair];
        }

        int result = 0;
        for(int step: steps){
            if(stair >= step)
                result += climbdp(stair-step, map, steps);
        }
        map[stair] = result;
        return result;
    }

    public static void main(String[] args) {
        Problem8 climbStairs = new Problem8();

        int stairs = 4;
        assert climbStairs.climb(stairs, new int[]{1,2}) == 5: "Test";
    }
}
