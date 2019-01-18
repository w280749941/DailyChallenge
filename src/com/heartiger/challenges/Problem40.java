package com.heartiger.challenges;

import java.util.Arrays;

/*
This problem was asked by Facebook.

Given a multiset of integers, return whether it can be partitioned into two subsets whose sums are the same.

For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, it would return true, since we can split it up into {15, 5, 10, 15, 10} and {20, 35}, which both add up to 55.

Given the multiset {15, 5, 20, 10, 35}, it would return false, since we can't split it up into two subsets that add up to the same sum.
*/
public class Problem40 {

    boolean canPartition(int[] nums){
        int sum = 0;
        for(int num: nums){
            sum+= num;
        }
        if(sum % 2 != 0) {
            return false;
        }
        Arrays.sort(nums);
        if(sum/2 < nums[nums.length-1])
            return false;

        return helper(nums, nums.length-1, sum/2);
    }

    private boolean helper(int[] nums, int index, int target){
        if(target < 0){
            return false;
        }

        if(target == 0){
            return true;
        }

        for(int i=index; i>=0; i--){
            if(helper(nums, i-1, target-nums[i]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] example = new int[]{15, 5, 20, 10, 35, 15, 10};
        boolean expected = true;

        int[] example2 = new int[]{15, 5, 20, 10, 35};
        boolean expected2 = false;

        Problem40 problem = new Problem40();
        assert problem.canPartition(example)==expected: "Test 1 Failed";
        assert problem.canPartition(example2)==expected2: "Test 2 Failed";
    }
}
