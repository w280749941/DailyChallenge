package com.heartiger.challenges;

import java.util.HashSet;
import java.util.Set;

/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Google.

You are given an N by M 2D matrix of lowercase letters. Determine the minimum number of columns that can be removed to ensure that each row is ordered from top to bottom lexicographically. That is, the letter at each column is lexicographically later as you go down each row. It does not matter whether each row itself is ordered lexicographically.

For example, given the following table:

cba
daf
ghi
This is not ordered because of the a in the center. We can remove the second column to make it ordered:

ca
df
gi
So your function should return 1, since we only needed to remove 1 column.

As another example, given the following table:

abcdef
Your function should return 0, since the rows are already ordered (there's only one row).

As another example, given the following table:

zyx
wvu
tsr
Your function should return 3, since we would need to remove all the columns to order it.

*/
public class Problem50 {

    int numsRowToBeRemoved(char[][] arr){
        char[] holder = arr[0];
        int result = 0;
        Set<Integer> hs = new HashSet<>();
        for(int r=1; r<arr.length; r++){
            for(int c=0; c<arr[r].length; c++){
                if(!hs.contains(c)){
                    if(arr[r][c] < holder[c]){
                        result++;
                        hs.add(c);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] example1 = new char[][]{
                {'c', 'b', 'a'},
                {'d', 'a', 'f'},
                {'g', 'h', 'i'}
        };
        int expected1 = 1;

        char[][] example2 = new char[][]{
                {'a', 'b', 'c', 'd', 'e', 'f'}
        };

        int expected2 = 0;

        char[][] example3 = new char[][]{
                {'z', 'y', 'x'},
                {'w', 'v', 'u'},
                {'t', 's', 'r'}
        };

        int expected3 = 3;

        Problem50 problem = new Problem50();
        assert problem.numsRowToBeRemoved(example1)==expected1: "Test 1 Failed";
        assert problem.numsRowToBeRemoved(example2)==expected2: "Test 2 Failed";
        assert problem.numsRowToBeRemoved(example3)==expected3: "Test 3 Failed";
    }
}
