package com.heartiger.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
This problem was asked by Microsoft.

Given a number in the form of a list of digits, return all possible permutations.

For example, given [1,2,3], return [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]].
*/
public class Problem65 {

    List<List<Integer>> permutations(List<Integer> nums){
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>());
        return res;
    }

    private void dfs(List<Integer> nums, List<List<Integer>> res, List<Integer> lt) {
        if(lt.size() == nums.size()){
            res.add(new ArrayList<>(lt));
            return;
        }

        for(int i=0; i<nums.size(); i++){
            if(lt.contains(nums.get(i)))
                continue;
            lt.add(nums.get(i));
            dfs(nums, res, lt);
            lt.remove(lt.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> expectedResult = Arrays.asList(
          Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2), Arrays.asList(2, 1, 3), Arrays.asList(2, 3, 1), Arrays.asList(3, 1, 2), Arrays.asList(3, 2, 1)
        );

        List<Integer> example = Arrays.asList(1, 2, 3);
        Problem65 problem = new Problem65();
        List<List<Integer>> result = problem.permutations(example);
    }
}
