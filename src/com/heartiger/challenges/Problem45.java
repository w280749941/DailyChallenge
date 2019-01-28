package com.heartiger.challenges;

import java.util.Arrays;

/*
This problem was asked by Facebook.

Given a list of integers, return the largest product that can be made by multiplying any three integers.

For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.

You can assume the list has at least three integers.
*/
public class Problem45 {
    int getMaximumProduct(int[] nums){
        if(nums == null || nums.length < 3)
            return 0;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int num: nums){
            if(num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if(num > max2){
                max3 = max2;
                max2 = num;
            } else if(num > max3){
                max3 = num;
            }

            if(num < min1){
                min2 = min1;
                min1 = num;
            } else if(num < min2){
                min2 = num;
            }
        }

        int two = Math.max(min1 * min2, max2 * max3);
        return max1*two;
    }

    public static void main(String[] args) {
        int[] example = new int[]{-10, -10, 5, 2};
        int expectedResult = 500;
        Problem45 problem = new Problem45();
        assert problem.getMaximumProduct(example)==expectedResult: "Test 1 Failed";
    }
}
