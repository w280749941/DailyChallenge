package com.heartiger.challenges;

import static com.heartiger.challenges.Problem70.sameArray;

/*
This problem was asked by Google.

Given a sorted list of integers, square the elements and give the output in sorted order.

For example, given [-9, -2, 0, 2, 3], return [0, 4, 4, 9, 81].
 */
public class Problem82 {

    public int[] getSquaredArray(int[] arr){
        int[] result = new int[arr.length];
        int breakPoint = 0;
        for(int i=1; i<arr.length; i++){
            if(Math.abs(arr[i]) > Math.abs(arr[i-1])){
                breakPoint = i-1;
                break;
            }
        }
        int l = breakPoint-1;
        int r = breakPoint;
        int index = 0;
        while(l >=0 && r<arr.length){
            if(Math.abs(arr[l]) < Math.abs(arr[r])){
                result[index] = arr[l] * arr[l];
                l--;
            } else {
                result[index] = arr[r] * arr[r];
                r++;
            }
            index++;
        }

        while(l >= 0){
            result[index] = arr[l] * arr[l];
            index++;
            l--;
        }

        while(r < arr.length){
            result[index] = arr[r] * arr[r];
            index++;
            r++;
        }

        return result;
    }

    public static void main(String[] args) {
        Problem82 problem = new Problem82();
        int[] arr = new int[]{-9, -2, 0, 2, 3};
        int[] expected = new int[]{0, 4, 4, 9, 81};
        assert sameArray(expected, problem.getSquaredArray(arr)): "Test 1 Failed";
    }
}
