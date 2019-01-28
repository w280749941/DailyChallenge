package com.heartiger.challenges;

/*
This problem was asked by Microsoft.

A number is considered perfect if its digits sum up to exactly 10.

Given a positive integer n, return the n-th perfect number.

For example, given 1, you should return 19. Given 2, you should return 28.
*/

public class Problem47 {

    int getSumEqulsTen(int count){
        for(int i=19; ; i+=9){
            if(isValid(19)){
                count --;
                if(count == 0)
                    return i;
            }
        }
    }

    private boolean isValid(int i) {
        int sum = 0;
        while(i > 0){
            sum += i%10;
            i /= 10;
        }

        return sum == 10;
    }

    public static void main(String[] args) {
        int example = 1;
        int result = 19;
        int example2 = 2;
        int result2 = 28;
        Problem47 problem = new Problem47();
        assert problem.getSumEqulsTen(example) == result: "Test 1 Failed";
        assert problem.getSumEqulsTen(example2) == result2: "Test 2 Failed";
    }
}
