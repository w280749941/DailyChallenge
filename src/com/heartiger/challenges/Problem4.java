package com.heartiger.challenges;

/*
    This problem was asked by Stripe.

    Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

    For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.

    You can modify the input array in-place.

 */
public class Problem4 {

    private static int findMissing(int[] nums){
        int i = 0;
        while(i<nums.length){
            if(nums[i] == i+1 || nums[i] <= 0 || nums[i] > nums.length){
                i++;
            } else if(nums[nums[i]-1] != nums[i]){
                swap(nums, nums[i]-1, i);
            } else {
                i++;
            }
        }
        i=0;
        for(; i<nums.length; i++){
            if(nums[i] != i+1){
                break;
            }
        }
        return i+1;
    }

    private static void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{3, -4, -1, 1};
        int expectedResult1 = 2;

        assert expectedResult1 == findMissing(arr1): "Test1 Failed";

        int[] arr2 = new int[]{1, 2, 0};
        int expectedResult2 = 3;

        assert expectedResult2 == findMissing(arr2): "Test2 Failed";

        int[] arr3 = new int[]{1, 2, 0, 2, 1, 1};
        int expectedResult3 = 3;

        assert expectedResult3 == findMissing(arr3): "Test3 Failed";

        int[] arr4 = new int[]{2,1};
        int expectedResult4 = 3;

        assert expectedResult4 == findMissing(arr4): "Test4 Failed";

        int[] arr5 = new int[]{3, 4, -1, 1};
        int expectedResult5 = 2;

        assert expectedResult5 == findMissing(arr5): "Test5 Failed";

        System.out.println("PASSED");

    }
}