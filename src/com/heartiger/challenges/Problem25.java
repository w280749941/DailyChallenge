package com.heartiger.challenges;

import java.util.ArrayList;
import java.util.List;

/*
This problem was asked by Google.

The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.
 */
public class Problem25 {

    private List<List<Integer>> allSubsets(int[] nums){
        if(nums == null || nums.length == 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0, result);

        return result;
    }

    private void helper(int[] nums, List<Integer> lt, int index, List<List<Integer>> result){
        result.add(new ArrayList<>(lt));

        for(int i=index; i<nums.length; i++){
            lt.add(nums[i]);
            helper(nums, lt, i+1, result);
            lt.remove(lt.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Problem25 problem = new Problem25();
        problem.allSubsets(nums).forEach(x->{x.forEach(System.out::print);
            System.out.println();});
    }
}
