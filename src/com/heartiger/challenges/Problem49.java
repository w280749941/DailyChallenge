package com.heartiger.challenges;

/*
This problem was asked by Microsoft.

Given an array of numbers, find the length of the longest increasing subsequence in the array.
The subsequence does not necessarily have to be contiguous.

For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15],
the longest increasing subsequence has length 6: it is 0, 2, 6, 9, 11, 15.
*/

import java.util.Arrays;

public class Problem49 {

    int longestIncreasingSubsequence(int[] nums){
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem49 problem = new Problem49();
        int[] example = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        int expectedResult = 6;
        assert problem.longestIncreasingSubsequence(example)==expectedResult: "Test 1 Failed";

        int[] example2 = new int[]{10,9,2,5,3,7,101,18};
        int expectedResult2 = 4;
        assert problem.longestIncreasingSubsequence(example2)==expectedResult2: "Test 2 Failed";
    }
}
