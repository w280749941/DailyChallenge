package com.heartiger.challenges;

/*
This problem was asked by Amazon.

Given a string, find the longest palindromic contiguous substring. If there are more than one with the maximum length, return any one.

For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The longest palindromic substring of "bananas" is "anana".
 */
public class Problem32 {

    String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";
        int l = 0;
        int r = 0;
        for(int i=0; i<s.length(); i++){
            int oddLength = getPalindromeLength(s, i, i);
            int evenLength = getPalindromeLength(s, i, i+1);
            int localMax = Math.max(oddLength, evenLength);
            if(localMax > r - l + 1){
                l = i - (localMax-1)/2 ;
                r = i + localMax/2;
            }
        }
        return s.substring(l, r+1);
    }

    private int getPalindromeLength(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        Problem32 problem = new Problem32();

        String example1 = "aabcdcb";
        String example1Result = "bcdcb";

        String example2 = "bananas";
        String example2Result = "anana";

        assert example1Result.equals(problem.longestPalindrome(example1)): "Test 1 Failed";
        assert example2Result.equals(problem.longestPalindrome(example2)): "Test 2 Failed";
    }
}
