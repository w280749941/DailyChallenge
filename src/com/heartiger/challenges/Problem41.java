package com.heartiger.challenges;

/*
This problem was asked by Google.

Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.

Do this faster than the naive method of repeated multiplication.

For example, pow(2, 10) should return 1024.

*/

import java.util.PriorityQueue;

public class Problem41 {
    int pow(int base, int power){
        if(power == 0)
            return 1;

        int result = (int) Math.pow(base, power /2);
        if(power % 2 == 0)
            return result*result;

        return base * result * result;
    }

    public static void main(String[] args) {
        int base = 2;
        int pow = 10;
        int expect = 1024;

        Problem41 problem = new Problem41();
        assert problem.pow(base, pow)==expect: "Test 1 Failed";

        int base2 = 3;
        int pow2 = 3;
        int expect2 = 27;
        assert problem.pow(base2, pow2)==expect2: "Test 2 Failed";
    }
}
