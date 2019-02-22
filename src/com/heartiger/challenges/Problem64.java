package com.heartiger.challenges;

/*
This problem was asked by Palantir.

Given a number represented by a list of digits, find the next greater permutation of a number, in terms of lexicographic ordering. If there is not greater permutation possible, return the permutation with the lowest value/ordering.

For example, the list [1,2,3] should return [1,3,2]. The list [1,3,2] should return [2,1,3]. The list [3,2,1] should return [1,2,3].

Can you perform the operation without allocating extra memory (disregarding the input memory)?
*/

import com.heartiger.utils.Utility;

import java.util.Arrays;

public class Problem64 {

    int[] nextGreaterPermutation(int[] nums){

        for(int i=nums.length-2; i>=0; i--){
            for(int j=nums.length-1; j>i; j--){
                if(nums[i] < nums[j]){
                    swap(nums, i, j);
                    int a=i+1;
                    int b=j;
                    while(a < b){
                        swap(nums, a++, b--);
                    }
                    return Arrays.copyOf(nums, nums.length);
                }
            }
        }

        int[] result = new int[nums.length];
        int j=0;
        for(int i=nums.length-1; i>=0; i--){
            result[j++] = nums[i];
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Problem64 problem = new Problem64();

        int[] example = new int[]{1, 2, 3};
        int[] example2 = new int[]{1, 3, 2};
        int[] example3 = new int[]{3, 2, 1};
        int[] example4 = new int[]{2, 1, 8, 7, 6, 5};
        int[] example5 = new int[]{1, 2, 3, 4};
        int[] example6 = new int[]{5, 3, 4, 9, 7, 6};

        int[] result = new int[]{1, 3, 2};
        int[] result2 = new int[]{2, 1, 3};
        int[] result3 = new int[]{1, 2, 3};
        int[] result4 = new int[]{2, 5, 1, 6, 7, 8};
        int[] result5 = new int[]{1, 2, 4, 3};
        int[] result6 = new int[]{5, 3, 6, 4, 7, 9};


        assert Utility.intArrayEqual(result, problem.nextGreaterPermutation(example)):"Test 1 Failed";
        assert Utility.intArrayEqual(result2, problem.nextGreaterPermutation(example2)):"Test 2 Failed";
        assert Utility.intArrayEqual(result3, problem.nextGreaterPermutation(example3)):"Test 3 Failed";
        assert Utility.intArrayEqual(result4, problem.nextGreaterPermutation(example4)):"Test 4 Failed";
        assert Utility.intArrayEqual(result5, problem.nextGreaterPermutation(example5)):"Test 5 Failed";
        assert Utility.intArrayEqual(result6, problem.nextGreaterPermutation(example6)):"Test 6 Failed";
    }
}
