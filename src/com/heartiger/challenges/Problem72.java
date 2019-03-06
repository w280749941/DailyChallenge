package com.heartiger.challenges;

/*
This problem was asked by Pinterest.

Given an integer list where each number represents the number of hops you can make, determine whether you can reach to the last index starting at index 0.

For example, [2, 0, 1, 0] returns True while [1, 1, 0, 1] returns False.

*/
public class Problem72 {

    boolean canHop(int[] nums){
        int target = nums.length-1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] + i == target){
                target = i;
            }
        }

        return target == 0;
    }

    public static void main(String[] args) {
        int[] example = new int[]{2, 0, 1, 0};
        boolean expected = true;

        int[] example2 = new int[]{1, 1, 0, 1};
        boolean expected2 = false;
        Problem72 problem = new Problem72();

        assert problem.canHop(example)==expected: "Test 1 Failed";
        assert problem.canHop(example2)==expected2: "Test 2 Failed";
    }
}
