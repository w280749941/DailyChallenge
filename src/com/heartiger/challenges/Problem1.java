package com.heartiger.challenges;

import java.util.HashSet;

/*
    This problem was recently asked by Google.

    Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

    Bonus: Can you do this in one pass?

 */
public class Problem1 {

    public static boolean hasSum(int[] arr, int target){
        HashSet<Integer> hs = new HashSet<>();
        for(int num: arr){
            if(hs.contains(target-num)){
                return true;
            } else {
                hs.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 15, 3, 7};
        int target = 17;
        assert hasSum(arr, target) : "Failed";

        int[] arr1 = new int[]{2, -5, 3, 8};
        int target1 = -2;
        assert hasSum(arr1, target1) : "Failed";

        System.out.println("PASSED");
    }
}
