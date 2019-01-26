package com.heartiger.challenges;

import java.util.*;

/*
This problem was asked by Google.

Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. If such a subset cannot be made, then return null.

Integers can appear more than once in the list. You may assume all numbers in the list are positive.

For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
 */
public class Problem29 {

    List<Integer> subSets(int[] nums, int k){
        List<Integer> result = new ArrayList<>();
        if (helper(nums, k, nums.length-1, result))
            return result;
        return null;
    }

    private boolean helper(int[] nums, int sum, int index, List<Integer> result) {
        if (sum == 0)
            return true;
        else if (sum < 0)
            return false;
        else if (index < 0)
            return false;
        else if (sum < nums[index])
            return helper(nums, sum, index-1, result);

        int size = result.size();
        result.add(nums[index]);
        if(helper(nums, sum-nums[index], index-1, result)){
            return true;
        } else {
            for(int i= size; i<result.size(); i++){
                result.remove(i);
            }
            return helper(nums, sum, index-1, result);
        }

    }

    boolean equalLists(List<Integer> lt1, List<Integer> lt2){
        if(lt1 == null && lt2 == null)
            return true;
        else if(lt1 == null || lt2 == null)
            return false;
        else if(lt1.size() != lt2.size())
            return false;

        return lt1.stream().mapToInt(x -> x).sum() == lt2.stream().mapToInt(x -> x).sum();
    }

    public static void main(String[] args) {
        Problem29 problem = new Problem29();
        int[] nums = new int[]{12, 1, 61, 5, 9, 2};
        int k = 24;
        List<Integer> expectedResult = Arrays.asList(12, 9, 2, 1);
        List<Integer> actualResult = problem.subSets(nums, k);
        assert problem.equalLists(actualResult, expectedResult): "Test 1 Failed";

        int[] nums2 = new int[]{12, 1, 61, 5, 9, 2};
        int k2 = 224;
        List<Integer> expectedResult2 = null;
        List<Integer> actualResult2 = problem.subSets(nums2, k2);
        assert problem.equalLists(actualResult2, expectedResult2): "Test 2 Failed";
    }
}
