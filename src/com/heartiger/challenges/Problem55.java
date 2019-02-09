package com.heartiger.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.heartiger.challenges.Problem38.sameList;

/*
This problem was asked by Yelp.

Given a mapping of digits to letters (as in a phone number), and a digit string, return all possible letters the number could represent. You can assume each valid number in the mapping is a single digit.

For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].

*/
public class Problem55 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return res;

        String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, res, dict, new StringBuilder(), 0);

        return res;
    }

    private void helper(String digits, List<String> res, String[] dict, StringBuilder sb, int index){
        if(digits.length() == index){
            res.add(sb.toString());
            return;
        }

        int wordIndex = Character.getNumericValue(digits.charAt(index));
        String word = dict[wordIndex];
        for(int i=0; i<word.length(); i++){
            sb.append(word.charAt(i));
            helper(digits, res, dict, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        Problem55 problem = new Problem55();
        assert sameList(expected, problem.letterCombinations(digits)): "Test 1 Failed";
    }
}
