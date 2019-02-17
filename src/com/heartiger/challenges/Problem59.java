package com.heartiger.challenges;

/*
This problem was asked by Google.
Given a string of parentheses, write a function to compute the minimum number of parentheses to be removed to make the string valid (i.e. each open parenthesis is eventually closed).
For example, given the string "()())()", you should return 1. Given the string ")(", you should return 2, since we must remove all of them.

 */
public class Problem59{
    int getInvalidParenthesis(String str){
        int l=0;
        int r=0;
        int count=0;

        for(char c: str.toCharArray()){
            if(c == '('){
                l++;
            } else {
                if(l <= r){
                    c++;
                } else {
                    r++;
                }
            }
        }

        return r-l+count;
    }

    public static void main(String[] args) {
        String example1 = "()())()";
        int expected1 = 1;
        String example2 = ")(";
        int expected2 = 2;

        Problem59 problem = new Problem59();

        assert problem.getInvalidParenthesis(example1) == expected1: "Test 1 Failed";
        assert problem.getInvalidParenthesis(example2) == expected2: "Test 2 Failed";
    }
}