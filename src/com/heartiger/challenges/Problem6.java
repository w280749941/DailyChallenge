package com.heartiger.challenges;

/*

    This problem was asked by Airbnb.

    Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

    For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

    Follow-up: Can you do this in O(N) time and constant space?
 */

public class Problem6 {

    private static int getLargestSum(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int withPrev = nums[0];
        int noPrev = 0;

        for(int i=1; i<nums.length; i++){
            int localMax = Math.max(withPrev, noPrev);
            withPrev = nums[i] + noPrev;
            noPrev = localMax;
        }

        return Math.max(withPrev, noPrev);
    }

    public static void main(String[] args) {


        int[] example1 = new int[]{2, 4, 6, 2, 5};
        int expectedResult1 = 13;

        assert getLargestSum(example1) == expectedResult1: "Test 1 Failed";

        int[] example2 = new int[]{5, 1, 1, 5};
        int expectedResult2 = 10;

        assert getLargestSum(example2) == expectedResult2: "Test 1 Failed";

        System.out.println("PASSED");
    }
}
