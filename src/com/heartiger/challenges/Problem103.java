package com.heartiger.challenges;

/*
This problem was asked by Amazon.

Given a string, determine whether any permutation of it is a palindrome.

For example, carrace should return true, since it can be rearranged to form racecar, which is a palindrome.
daily should return false, since there's no rearrangement that can form a palindrome.

*/
public class Problem103 {

    boolean hasPalindromePermutation(String carrace){
        int[] table = new int[26];
        for(char c: carrace.toCharArray()){
            int index = c-'a';
            table[index]++;
        }

        int count = 0;
        for(int num: table){
            if(num % 2 > 0){
                count++;
            }
        }

        return count < 2;
    }

    public static void main(String[] args) {
        Problem103 problem = new Problem103();
        String example = "carrace";
        boolean expected = true;

        String example2 = "daily";
        boolean expected2 = false;

        assert expected == problem.hasPalindromePermutation(example): "Test 1 Failed";
        assert expected2 == problem.hasPalindromePermutation(example2): "Test 2 Failed";
    }
}
