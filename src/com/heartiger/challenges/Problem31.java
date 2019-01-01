package com.heartiger.challenges;

/*
This problem was asked by Google.

We can determine how "out of order" an array A is by counting the number of inversions it has. Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. That is, a smaller element appears after a larger element.

Given an array, count the number of inversions it has. Do this faster than O(N^2) time.

You may assume each element in the array is distinct.

For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3). The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.
 */

public class Problem31 {
    private int countingInversion(int[] nums){
        int[] result = new int[1];
        modifiedMergeSort(nums, 0, nums.length-1, result);
        return result[0];
    }

    private void modifiedMergeSort(int[] nums, int left, int right, int[] result) {
        if(left >= right)
            return;

        int mid = left + (right - left)/2;
        modifiedMergeSort(nums, left, mid, result);
        modifiedMergeSort(nums, mid+1, right, result);
        // Modification part
        int j = mid+1;
        for(int i=left; i<=mid; i++){
            while(j <= right && nums[i] > nums[j])
                j++;

            result[0] += j - (mid+1);
        }
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int subArrayASize = mid - left + 1;
        int[] subArrayA = new int[subArrayASize];
        System.arraycopy(nums, left, subArrayA, 0, subArrayASize);

        int subArrayBSize = right - mid;
        int[] subArrayB = new int[subArrayBSize];
        System.arraycopy(nums, mid+1, subArrayB, 0, subArrayBSize);

        int i = left;
        int a = 0;
        int b = 0;
        while (i<subArrayASize && i<subArrayBSize){
            if(subArrayA[i] < subArrayB[i]){
                nums[i++] = subArrayA[a++];
            } else {
                nums[i++] = subArrayB[b++];
            }
        }

        while(a<subArrayASize){
            nums[i++] = subArrayA[a++];
        }

        while(b<subArrayBSize){
            nums[i++] = subArrayB[b++];
        }
    }

    public static void main(String[] args) {
        Problem31 problem = new Problem31();

        int[] example1 = new int[]{2, 4, 1, 3, 5};
        int expectedResult1 = 3;

        int[] example2 = new int[]{5, 4, 3, 2, 1};
        int expectedResult2 = 10;

        assert problem.countingInversion(example1) == expectedResult1: "Test 1 failed";
        assert problem.countingInversion(example2) == expectedResult2: "Test 2 failed";
    }
}
