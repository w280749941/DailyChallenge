package com.heartiger.challenges;

import java.security.InvalidParameterException;

/*
This problem was asked by Amazon.

Implement a bit array.

A bit array is a space efficient array that holds a value of 1 or 0 at each index.

init(size): initialize the array with size
set(i, val): updates index at i with val where val is either 1 or 0.
get(i): gets the value at index i.
 */
public class Problem93 {

    static class BitArray{
        boolean[] array;
        BitArray(int size){
            array = new boolean[size];
        }

        void set(int i, int val) throws InvalidParameterException {
            if(i < 0 || i >= array.length)
                throw new IndexOutOfBoundsException();
            if(val < 0 || val > 1)
                throw new InvalidParameterException("Value can only be 0 or 1");
            array[i] = val == 1;
        }

        int get(int i){
            if(i < 0 || i >= array.length)
                throw new IndexOutOfBoundsException();
            return array[i] ? 1 : 0;
        }
    }

    public static void main(String[] args) throws InvalidParameterException {
        BitArray bitArray = new BitArray(5);
        bitArray.set(2, 1);
        bitArray.set(4, 1);
        assert bitArray.get(0) == 0: "Test 1 Failed";
        assert bitArray.get(2) == 1: "Test 2 Failed";
        assert bitArray.get(4) == 1: "Test 3 Failed";
    }
}
