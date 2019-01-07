package com.heartiger.challenges;

/*
This problem was asked by Amazon.

Given an array of numbers, find the maximum sum of any contiguous subarray of the array.

For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.

Given the array [-5, -1, -8, -9], the maximum sum would be 0, since we would not take any elements.

Do this in O(N) time.
 */
public class Problem35 {

    int getMaximumSubArray(int[] nums){
        int prev = 0;
        int max = 0;
        for(int num: nums){
            prev = Math.max(prev + num, num);
            max = Math.max(max, prev);
        }
        return max;
    }

    public static void main(String[] args) {
        Problem35 problem = new Problem35();

        int[] example1 = new int[]{34, -50, 42, 14, -5, 86};
        int result1 = 137;
        assert problem.getMaximumSubArray(example1) == result1: "Test 1 Failed";

        int[] example2 = new int[]{-5, -1, -8, -9};
        int result2 = 0;
        assert problem.getMaximumSubArray(example2) == result2: "Test 2 Failed";
    }
}
