package com.heartiger.challenges;

import java.util.HashSet;
import java.util.Set;

/*

This problem was asked by Amazon.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

 */
public class Problem9 {

    private String longestSubString(String s, int k){
        String result = "";
        for(int i=0; i<s.length(); i++){
            int end = i+k;
            if(!result.equals("")){
                end = i+result.length();
            }

            while(true){
                // Early stop if no longer substring available
                if((s.length() - i <= result.length())){
                    return result;
                }
                if(isValidSubstring(s, i, end, k)) {
                    if(result.length() < end - i){
                        result = s.substring(i, end);
                    }
                    end++;
                    continue;
                }
                break;
            }
        }
        return result;
    }

    private boolean isValidSubstring(String s, int left, int right, int total) {
        if(right > s.length()){
            return false;
        }

        Set<Character> hs = new HashSet<>();

        for(int i=left; i<right; i++){
            hs.add(s.charAt(i));
            if(hs.size() > total){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Problem9 problem = new Problem9();

        String example = "abcba";
        int k = 2;
        assert problem.longestSubString(example, k).equals("bcb"): "Test Failed";

        String example2 = "aebabaccddddeee";
        int k2 = 3;
        assert problem.longestSubString(example2, k2).equals("ccddddeee"): "Test2 Failed";

        String example3 = "aabbcc";
        int k3 = 1;
        assert problem.longestSubString(example3, k3).equals("aa"): "Test3 Failed";

        String example4 = "aabbcc";
        int k4 = 2;
        assert problem.longestSubString(example4, k4).equals("aabb"): "Test4 Failed";

        String example5 = "aabbcc";
        int k5 = 3;
        assert problem.longestSubString(example5, k5).equals("aabbcc"): "Test5 Failed";

        String example6 = "aaabbb";
        int k6 = 3;
        assert problem.longestSubString(example6, k6).equals("aaabbb"): "Test6 Failed";
    }
}
