package com.heartiger.challenges;

/*
This problem was asked by Facebook.

Given an array of integers, write a function to determine whether the array could become non-decreasing by modifying at most 1 element.

For example, given the array [10, 5, 7], you should return true, since we can modify the 10 into a 1 to make the array non-decreasing.

Given the array [10, 5, 1], you should return false, since we can't modify any one element to get a non-decreasing array.

*/
public class Problem54 {

    public boolean checkPossibility(int[] nums) {
        boolean found = false;

        for(int i=1; i<nums.length; i++){
            if(nums[i-1] > nums[i]){
                if(found)
                    return false;

                found = true;
                if(i > 1){
                    if(nums[i] >= nums[i-2]){ // 2 4 2 7
                        nums[i-1] = nums[i];
                    } else {                  // 3 4 4 2 7
                        nums[i] = nums[i-1];
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] example = new int[]{10, 5, 1};
        int[] example2 = new int[]{10, 5, 7};
        boolean result = false;
        boolean result2 = true;

        Problem54 problem = new Problem54();
        assert problem.checkPossibility(example)==result: "Test 1 Failed";
        assert problem.checkPossibility(example2)==result2: "Test 2 Failed";
    }
}
