package com.heartiger.challenges;

import java.util.Stack;

/*
    This problem was asked by Facebook.

    Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

    For example, given the string "([])[]({})", you should return true.

    Given the string "([)]" or "((()", you should return false.
 */
public class Problem18 {

    public boolean validParenthesis(String str){
        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                st.push(')');
            } else if(str.charAt(i) == '{'){
                st.push('}');
            } else if(str.charAt(i) == '['){
                st.push(']');
            } else if(st.pop() != str.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem18 problem = new Problem18();

        String test1 = "([])[]({})";
        String test2 = "([)]";
        assert problem.validParenthesis(test1): "Test 1 Failed";
        assert !problem.validParenthesis(test2): "Test 2 Failed";
    }
}
