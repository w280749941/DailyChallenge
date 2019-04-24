package com.heartiger.challenges;

/*
This problem was asked by Facebook.

Given a positive integer n, find the smallest number of squared integers which sum to n.

For example, given n = 13, return 2 since 13 = 32 + 22 = 9 + 4.

Given n = 27, return 3 since 27 = 32 + 32 + 32 = 9 + 9 + 9.
 */
public class Problem102 {

    int getMinSquareNumbers(int num){
        int[] dp = new int[num+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        return getNum(num, dp);
    }

    private int getNum(int num, int[] dp) {
        if(num <= 3){
            return num;
        }

        if(dp[num] != 0){
            return dp[num];
        }


        for(int i=1; i<num; i++){
            int temp = i*i;

            if(temp > num){
                break;
            } else {
                dp[num] = Math.min(num, 1 + getNum(num-temp, dp));
            }
        }

        return dp[num];
    }

    public static void main(String[] args) {
        Problem102 problem = new Problem102();
        int example = 27;
        int expected = 3;

        int example2 = 13;
        int expected2 = 2;

        assert expected == problem.getMinSquareNumbers(example): "Test 1 Failed";
        assert expected2 == problem.getMinSquareNumbers(example2): "Test 2 Failed";
    }
}
