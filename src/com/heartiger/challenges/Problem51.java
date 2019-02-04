package com.heartiger.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
This problem was asked by Snapchat.

Given a list of possibly overlapping intervals, return a new list of intervals where all overlapping intervals have been merged.

The input list is not necessarily ordered in any way.

For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return [(1, 3), (4, 10), (20, 25)].
*/
public class Problem51 {
    List<int[]> mergeInterval(int[][] intervals){
        if(intervals == null || intervals.length < 2){
            return intervals == null ? new ArrayList<>() : Collections.singletonList(intervals[0]);
        }
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] > prev[1]){
                result.add(prev);
                prev = curr;
            } else if(curr[0] == prev[1]){
                prev = new int[]{prev[0], curr[1]};
            } else { // curr[0] < prev[1]
                prev = new int[]{prev[0], Math.max(prev[1], curr[1])};
            }
        }
        if(result.get(result.size()-1) != prev){
            result.add(prev);
        }
        return result;
    }

    private static boolean equalList(List<int[]> result, List<int[]> actual) {
        for(int i=0; i<result.size(); i++){
            if(result.get(i)[0] != actual.get(i)[0] || result.get(i)[1] != actual.get(i)[1])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 3},
                {5, 8},
                {4, 10},
                {20, 25}
        };

        List<int[]> result = Arrays.asList(new int[]{1, 3}, new int[]{4, 10}, new int[]{20, 25});
        Problem51 problem = new Problem51();
        List<int[]> actual = problem.mergeInterval(intervals);
        assert equalList(result, actual): "Test 1 Failed";
    }
}
