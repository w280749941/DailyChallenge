package com.heartiger.challenges;
/*

This problem was asked by Google.

The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them.
 */
public class Problem21 {

    public int minEdit(String word1, String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<dp[0].length; i++){
            dp[0][i] = i;
        }

        for(int i=0; i<dp.length; i++){
            dp[i][0] = i;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                // If both characters are equal, then the distance would be the previous distance
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // Min among replace, insert, remove to the first word.
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "kitten";
        String word2 = "sitting";
        int expectedResult = 3;


        Problem21 problem = new Problem21();
        assert problem.minEdit(word1, word2)==expectedResult: "Test 1 Failed";
    }
}
