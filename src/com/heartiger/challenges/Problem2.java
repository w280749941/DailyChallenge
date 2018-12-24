package com.heartiger.challenges;

import com.heartiger.utils.Utility;

/*
    This problem was asked by Uber.

    Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

    For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

    Follow-up: what if you can't use division?

 */
public class Problem2 {

    public static int[] productOfNumbers(int[] arr){
        int product = 1;
        for(int i: arr){
            product *= i;
        }
        int[] result = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            result[i] = product / arr[i];
        }
        return result;
    }

    public static int[] productOfNumbersWithoutDivision(int[] arr){
        int[] leftProduct = new int[arr.length];
        int[] rightProduct = new int[arr.length];

        leftProduct[0] = arr[0];
        for(int i=1; i<leftProduct.length; i++){
            leftProduct[i] = leftProduct[i-1] * arr[i];
        }

        rightProduct[arr.length-1] = arr[arr.length-1];
        for(int i=rightProduct.length-2; i>=0; i--){
            rightProduct[i] = rightProduct[i+1] * arr[i];
        }

        int[] result = new int[arr.length];
        result[0] = rightProduct[1];
        result[result.length-1] = leftProduct[result.length-2];
        for(int i=1; i<result.length-1; i++){
            result[i] = leftProduct[i-1] * rightProduct[i+1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int[] expectedOut = new int[]{120, 60, 40, 30, 24};
        assert Utility.intArrayEqual(expectedOut, productOfNumbers(arr)) : "Failed";

        int[] arr1 = new int[]{3, 2, 1};
        int[] expectedOut2 = new int[]{2, 3, 6};
        assert Utility.intArrayEqual(expectedOut2, productOfNumbers(arr1)) : "Failed";

        assert Utility.intArrayEqual(expectedOut, productOfNumbersWithoutDivision(arr)) : "Failed";

        assert Utility.intArrayEqual(expectedOut2, productOfNumbersWithoutDivision(arr1)) : "Failed";

        System.out.println("PASSED");
    }
}
