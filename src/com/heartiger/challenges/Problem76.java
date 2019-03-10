package com.heartiger.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.heartiger.challenges.Problem38.sameList;

/*
This problem was asked by Google.

Given a word W and a string S, find all starting indices in S which are anagrams of W.

For example, given that W is "ab", and S is "abxaba", return 0, 3, and 4.

*/
public class Problem76 {

    List<Integer> getAllStartIndices(String word, String dictWord){
        int[] dict = new int[26];
        for(char c: word.toCharArray()){
            dict[c-'a']++;
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<dictWord.length(); i++){
            if(isAnagram(dictWord, i, dict.clone(), word.length())){
                result.add(i);
            }
        }

        return result;
    }

    private boolean isAnagram(String dictWord, int index, int[] dict, int len) {
        if(index+len > dictWord.length())
            return false;
        for(int i=index; i<index+len; i++){
            if(--dict[dictWord.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "ab";
        String dictWord = "abxaba";

        Problem76 problem = new Problem76();
        List<Integer> expectedResult = Arrays.asList(0, 3, 4);
        assert sameList(problem.getAllStartIndices(word, dictWord), expectedResult): "Test 1 Failed";
    }
}
