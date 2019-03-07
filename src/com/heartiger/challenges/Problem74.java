package com.heartiger.challenges;

/*
This problem was asked by Google.

Given two strings A and B, return whether or not A can be shifted some number of times to get B.

For example, if A is abcde and B is cdeab, return true. If A is abc and B is acb, return false.
*/
public class Problem74 {

    boolean canShift(String source, String target){
        if(source.length() != target.length())
            return false;

        String doubledLength = target+target;
        return doubledLength.contains(source);
    }

    public static void main(String[] args) {
        String example = "abcde";
        String target = "cdeab";

        String example2 = "abc";
        String target2 = "acb";

        Problem74 problem = new Problem74();
        assert problem.canShift(example, target)==true: "Test 1 Failed";
        assert problem.canShift(example2, target2)==false: "Test 2 Failed";
    }
}
