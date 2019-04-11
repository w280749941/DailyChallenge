package com.heartiger.challenges;

/*
This problem was asked by Google.

You're given a string consisting solely of (, ), and *. * can represent either a (, ), or an empty string.
Determine whether the parentheses are balanced.

For example, (()* and (*) are balanced. )*( is not balanced.
 */
public class Problem95 {

    private boolean hasResult;
    boolean isBalancedParenthesis(String word){
        hasResult = false;
        helper(word, 0, 0);
        return hasResult;
    }

    // left +1, right -1, empty 0
    private void helper(String word, int index, int count){
        if(count < 0)
            return;

        if(word.length() == index && count == 0){
            hasResult = true;
            return;
        }

        for(int i=index; i<word.length(); i++){
            if(count < 0)
                return;
            char letter = word.charAt(i);
            if(letter == '*'){
                helper(word, i+1, count+1); // left
                helper(word, i+1, count-1); // right
            } else if(letter == '('){
                count += 1; // left
            } else if(letter == ')'){
                count -= 1; // right
            }
        }

        if(count == 0){
            hasResult = true;
        }
    }

    public static void main(String[] args) {
        Problem95 problem = new Problem95();
        String example1 = "(()*";
        boolean expected1 = true;
        assert problem.isBalancedParenthesis(example1) == expected1: "Test 1 Failed";

        String example2 = ")*(";
        boolean expected2 = false;
        assert problem.isBalancedParenthesis(example2) == expected2: "Test 2 Failed";

        String example3 = "(*)";
        boolean expected3 = true;
        assert problem.isBalancedParenthesis(example3) == expected3: "Test 3 Failed";
    }
}
