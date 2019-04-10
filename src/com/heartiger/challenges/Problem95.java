package com.heartiger.challenges;

/*
This problem was asked by Google.

You're given a string consisting solely of (, ), and *. * can represent either a (, ), or an empty string. Determine whether the parentheses are balanced.

For example, (()* and (*) are balanced. )*( is not balanced.
 */
public class Problem95 {

    boolean isBalancedParenthesis(String word){
        return false;
    }

    public static void main(String[] args) {
        Problem95 problem = new Problem95();
        String example1 = "(()*";
        boolean expected1 = true;
        assert problem.isBalancedParenthesis(example1) == expected1: "Test 1 Failed";

        String example2 = ")*(";
        boolean expected2 = false;
        assert problem.isBalancedParenthesis(example2) == expected2: "Test 2 Failed";
    }
}
