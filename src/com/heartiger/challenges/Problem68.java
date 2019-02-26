package com.heartiger.challenges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
This problem was asked by Microsoft.

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.

*/
public class Problem68 {

    /** O(NlogN) solution **/
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);

        int max = 1;
        int count = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] - nums[i-1] == 1){
                count++;
                max = Math.max(max, count);
            } else if(nums[i] == nums[i-1]){
                continue;
            } else {
                count = 1;
            }
        }
        return max;
    }

    /** O(n) solution **/
    public int longestConsecutive2(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        Set<Integer> hs = new HashSet<>();
        for(int num: nums)
            hs.add(num);

        int result = 1;
        for(int num: nums){
            if(!hs.contains(num-1)){
                int currNum = num;
                int count = 1;
                while(hs.contains(currNum + 1)){
                    currNum++;
                    count++;
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] example = new int[]{100, 4, 200, 1, 3, 2};
        int expectedResult = 4;
        Problem68 problem = new Problem68();

        assert problem.longestConsecutive(example)==expectedResult: "Test 1 Failed";
        assert problem.longestConsecutive2(example)==expectedResult: "Test 2 Failed";
    }
}
