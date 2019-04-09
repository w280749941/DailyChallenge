package com.heartiger.challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
This problem was asked by Facebook.

Given an array of integers in which two elements appear exactly once and all other elements appear exactly twice, find the two elements that appear only once.

For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.

Follow-up: Can you do this in linear time and constant space?
 */
public class Problem94 {

    int[] getTwoSignleOccurrence(int[] arr){
        Map<Integer, Integer> hm = new HashMap<>();
        for(int num: arr){
            hm.putIfAbsent(num, 0);
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[2];
        int i=0;
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if(entry.getValue() == 1){
                result[i++] = entry.getKey();
            }
        }

        return result;
    }

    // Follow-up: Can you do this in linear time and constant space? (ANS)
    int[] getTwoSignleOccurrence2(int[] arr){

        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }

        xor &= -xor;

        int[] rets = {0, 0};
        for (int num : arr)
            if ((num & xor) == 0)
                rets[0] ^= num;
            else
                rets[1] ^= num;
        return rets;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 8, 10, 2, 6, 10};
        Problem94 problem = new Problem94();
        int[] result = problem.getTwoSignleOccurrence(arr);
        Arrays.sort(result);
        assert result[0] == 4: "Test 1 Failed";
        assert result[1] == 8: "Test 2 Failed";

        int[] result2 = problem.getTwoSignleOccurrence2(arr);
        Arrays.sort(result2);
        assert result2[0] == 4: "Test 3 Failed";
        assert result2[1] == 8: "Test 4 Failed";
    }
}
