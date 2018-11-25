package com.heartiger.utils;

public class Utility {

    public static boolean arrayEqual(int[] arr, int[] arr2){
        if(arr.length != arr2.length){
            return false;
        }
        int i=0;
        while(i<arr.length){
            if(arr[i] != arr2[i]){
                return false;
            }
            i++;
        }
        return true;
    }
}
