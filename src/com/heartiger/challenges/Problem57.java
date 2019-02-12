package com.heartiger.challenges;

import java.util.Random;

/*
This problem was asked by Two Sigma.

Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, implement a function rand7() that returns an integer from 1 to 7 (inclusive).
*/
public class Problem57 {

    static Random rand = new Random();

    int rand7(){
        int r;
        int c;
        int i;
        do{
            r = rand5();
            c = rand5();
            i = c + (r-1)*5;
        }while (i > 21);

        return 1 + ((i - 1) % 7);
    }

    int rand5(){
        return rand.nextInt(7) + 1;
    }

    public static void main(String[] args) {
        Problem57 problem = new Problem57();
        for(int i=0; i<15; i++)
            System.out.println(problem.rand7());
    }
}
