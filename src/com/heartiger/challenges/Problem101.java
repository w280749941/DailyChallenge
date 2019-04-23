package com.heartiger.challenges;

/*
This problem was asked by MongoDB.

Given a list of elements, find the majority element, which appears more than half the time (> floor(len(lst) / 2.0)).

You can assume that such element exists.

For example, given [1, 2, 1, 1, 3, 4, 1, 0], return 1.
 */
public class Problem101 {

    int getNumber(int[] array){
        int candidate = Integer.MIN_VALUE;
        int count = 0;
        for(int num: array){
            if(candidate == num){
                count++;
            } else {
                count--;
                if(count < 0){
                    candidate = num;
                    count = 1;
                }
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        Problem101 problem = new Problem101();
        int[] array = new int[]{1, 2, 1, 1, 3, 4, 1, 0};
        int expected = 1;
        int actual = problem.getNumber(array);

        assert expected == actual: "Test 1 Failed";
    }
}
