package com.heartiger.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
This problem was asked by Alibaba.

Given an even number (greater than 2), return two prime numbers whose sum will be equal to the given number.

A solution will always exist. See Goldbach’s conjecture.

Example:

Input: 4
Output: 2 + 2 = 4
If there are more than one solution possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d, then

[a, b] < [c, d]
If a < c OR a==c AND b < d.
*/
public class Problem70 {

    int[] getNums(int number){
        List<Integer> primes = getPrimeNums(number);
        int l=0;
        int r=primes.size()-1;
        while(l < r){
            int sum = primes.get(l) + primes.get(r);
            if(sum == number)
                return new int[]{primes.get(l), primes.get(r)};
            else if(sum > number)
                r--;
            else
                l++;
        }

        int half = number/2;
        if(primes.contains(half) && half*2 == number)
            return new int[]{half, half};

        return new int[]{-1, -1};
    }

    private List<Integer> getPrimeNums(int number) {
        boolean[] primes = new boolean[number];
        Arrays.fill(primes, true);
        for(int i=2; i*i<number; i++){
            if(primes[i]){
                for(int j=2*2; j<number; j+=i){
                    primes[i] = false;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=2; i<number; i++){
            if(primes[i])
                res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int example = 4;
        int[] expected = new int[]{2, 2};

        int example2 = 8;
        int[] expected2 = new int[]{3, 5};

        Problem70 problem = new Problem70();
        assert sameArray(problem.getNums(example), expected): "Test 1 Failed";
        assert sameArray(problem.getNums(example2), expected2): "Test 2 Failed";
    }

    private static boolean sameArray(int[] nums, int[] expected) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] != expected[i])
                return false;
        }
        return true;
    }
}
