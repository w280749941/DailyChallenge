package com.heartiger.challenges;

import static com.heartiger.challenges.Problem70.sameArray;

/*
This problem was asked by Facebook.

Write a function that rotates a list by k elements.
For example, [1, 2, 3, 4, 5, 6] rotated by two becomes [3, 4, 5, 6, 1, 2].
Try solving this without creating a copy of the list.
How many swap or move operations do you need?

*/
public class Problem86 {

    int[] getShiftedArrayByK(int[] arr, int k){
        reverseArray(arr, 0, arr.length);
        reverseArray(arr, 0, arr.length-k);
        reverseArray(arr, arr.length-k, arr.length);

        return arr;
    }

    private static void reverseArray(int[] arr, int l, int r) {
        r = r-1;
        while(l < r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int k = 2;
        int[] expectedResult = new int[]{3, 4, 5, 6, 1, 2};
        Problem86 problem = new Problem86();
        int[] actualResult = problem.getShiftedArrayByK(arr, k);
        assert sameArray(expectedResult, actualResult): "Test 1 Failed";
    }
}
