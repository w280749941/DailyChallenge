package com.heartiger.challenges;

import java.util.Arrays;

/*

    This problem was asked by Facebook.

    Implement regular expression matching with the following special characters:

    . (period) which matches any single character
    * (asterisk) which matches zero or more of the preceding element
    That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.

    For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return false.

    Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.
 */
public class Problem16 {

    /*
        The idea is to use dynamic programming to solve this problem.
        Initialize dp[0][0] to true when both are empty strings.
        Initialize the dp array, take into account .* case in the beginning(0 occurrence).
     */
    public boolean validRegularExpression(String word, String pattern){
        if(word == null || pattern == null)
            return false;
        boolean[][] dp = new boolean[word.length()+1][pattern.length()+1];
        dp[0][0] = true;
        for(int i=1; i<dp[0].length; i++){
            if(pattern.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int r = 1; r<=word.length(); r++){
            for(int c=1; c<=pattern.length(); c++){
                // Both have same letter or pattern is a dot.
                if(word.charAt(r-1) == pattern.charAt(c-1) || pattern.charAt(c-1) == '.'){
                    dp[r][c] = dp[r-1][c-1];
                } else if(pattern.charAt(c-1) == '*'){
                    // When * represents 0 occurrence.
                    if(dp[r][c-2]) {
                        dp[r][c] = dp[r][c - 2];
                        // When .* represents one or more occurrence.
                    } else if (pattern.charAt(c-1-1) == word.charAt(r-1) || pattern.charAt(c-1-1) == '.'){
                        dp[r][c] = dp[r-1][c]; // Check if without the last letter, both are matching
                    }
                }
            }
        }
        return dp[word.length()][pattern.length()];
    }

    public static void main(String[] args) {
        String testWord1 = "ray";
        String testWord2 = "raymond";
        String testPattern1 = "ra.";

        Problem16 problem = new Problem16();
        assert problem.validRegularExpression(testWord1, testPattern1): "Test 1 failed";
        assert !problem.validRegularExpression(testWord2, testPattern1): "Test 2 failed";

        String testWord3 = "chat";
        String testWord4 = "chats";
        String testPattern2 = ".*at";

        assert problem.validRegularExpression(testWord3, testPattern2): "Test 3 failed";
        assert !problem.validRegularExpression(testWord4, testPattern2): "Test 4 failed";
    }
}
