package com.heartiger.challenges;

import com.heartiger.utils.Utility;

/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

Given a string of words delimited by spaces, reverse the words in string. For example, given "hello world here", return "here world hello"

Follow-up: given a mutable string representation, can you perform this operation in-place?
*/
public class Problem77 {

    String reverseStrings(String words){
        String[] wordsArray = words.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i=wordsArray.length-1; i>=0; i--){
            sb.append(wordsArray[i]).append(" ");
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    /** Follow-up: given a mutable string representation, can you perform this operation in-place? **/
    String reverseStringsInPlace(String words){
        char[] wordArrays = words.toCharArray();

        reverseArray(wordArrays, 0, wordArrays.length-1);
        int l=0;
        int r=0;
        while(r < wordArrays.length){
            if(wordArrays[r] == ' '){
                reverseArray(wordArrays, l, r-1);
                l = r+1;
            }
            r++;
        }

        reverseArray(wordArrays, l, r-1);
        return new String(wordArrays);
    }

    private void reverseArray(char[] wordArrays, int l, int r) {
        while(l < r){
            char temp = wordArrays[l];
            wordArrays[l] = wordArrays[r];
            wordArrays[r] = temp;
            l++;
            r--;
        }
    }


    public static void main(String[] args) {
        String words = "hello world here";
        String expected = "here world hello";
        Problem77 problem = new Problem77();
        assert expected.equals(problem.reverseStrings(words)): "Test 1 Failed";
        assert expected.equals(problem.reverseStringsInPlace(words)): "Test 2 Failed";
    }
}
