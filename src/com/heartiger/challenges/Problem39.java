package com.heartiger.challenges;


/*
This problem was asked by Amazon.

An sorted array of integers was rotated an unknown number of times.

Given such an array, find the index of the element in the array in faster than linear time. If the element doesn't exist in the array, return null.

For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).

You can assume all the integers in the array are unique.
 */
public class Problem39 {

    int searchInRotatedArray(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        while(l <= r){
            int m = l + (r-l)/2;

            if(nums[m] == target){
                return m;
            } else if(nums[m] >= nums[l]){ // from l to m is sorted.
                if(nums[l] <= target && target < nums[m]){ // binary search in the sorted part
                    r = m-1;
                } else {
                    l = m+1;
                }
            } else { // from l to m is unsorted, then m to r must be sorted.
                if(nums[r] >= target && nums[m] < target){ // binary search in the sorted part
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem39 problem = new Problem39();
        int[] nums = new int[]{13, 18, 25, 2, 8, 10};
        int target = 8;
        int expected = 4;

        assert expected == problem.searchInRotatedArray(nums, target): "Test 1 Failed";
    }
}
