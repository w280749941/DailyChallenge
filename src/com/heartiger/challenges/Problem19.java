package com.heartiger.challenges;

/*
This problem was asked by Facebook.

You are given an array of non-negative integers that represents a two-dimensional elevation map where each element is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
 */

public class Problem19 {

    public int waterCanHold(int[] walls){
        if(walls == null || walls.length == 0)
            return 0;

        int l = 0;
        int r = walls.length-1;
        int leftMax = walls[l];
        int rightMax = walls[r];
        int total = 0;
        while(l < r){
            if(walls[l] <= rightMax){
                if(leftMax >= walls[l]){
                    total += leftMax - walls[l];
                    l++;
                }else{
                    leftMax = walls[l];
                }
            } else {
                leftMax = walls[l];
                if(rightMax >= walls[r]){
                    total += rightMax - walls[r];
                    r--;
                } else {
                    rightMax = walls[r];
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 1, 2};
        int expectedResult1 = 1;

        int[] arr2 = new int[]{3, 0, 1, 3, 0, 5};
        int expectedResult2 = 8;

        int[] arr3 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int expectedResult3 = 6;

        Problem19 problem = new Problem19();
        assert problem.waterCanHold(arr1)==expectedResult1: "Test 1 Failed";
        assert problem.waterCanHold(arr2)==expectedResult2: "Test 2 Failed";
        assert problem.waterCanHold(arr3)==expectedResult3: "Test 3 Failed";
    }
}

