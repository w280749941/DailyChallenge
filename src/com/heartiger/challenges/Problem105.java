package com.heartiger.challenges;

/*
This problem was asked by Google.

Given a string, return the first recurring character in it, or null if there is no recurring character.

For example, given the string "acbbac", return "b". Given the string "abcdef", return null.
 */
public class Problem105 {

    Character getFirstRecurringLetter(String word){
        int[] table = new int[26];
        for(char c: word.toCharArray()){
            int index = c-'a';
            int result = ++table[index];
            if(result > 1){
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Problem105 problem = new Problem105();
        String example1 = "acbbac";
        Character expected1 = 'b';

        String example2 = "abcdef";
        Character expected2 = null;

        assert expected1.equals(problem.getFirstRecurringLetter(example1)): "Test 1 Failed";
        assert expected2 == problem.getFirstRecurringLetter(example2): "Test 2 Failed";
    }
}
