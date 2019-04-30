package com.heartiger.challenges;

/*
This problem was asked by Facebook.

Given a 32-bit integer, return the number with its bits reversed.

For example, given the binary number 1111 0000 1111 0000 1111 0000 1111 0000, return 0000 1111 0000 1111 0000 1111 0000 1111.
 */
public class Problem106 {

    String getFlippedBits(String bits){
        char[] temp = new char[bits.length()];
        for(int i=0; i<bits.length(); i++){
            temp[i] = bits.charAt(i) == '1' ? '0' : '1';
        }

        return new String(temp);
    }

    public static void main(String[] args) {
        Problem106 problem = new Problem106();
        String example = "11110000111100001111000011110000";
        String expected = "00001111000011110000111100001111";
        assert expected.equals(problem.getFlippedBits(example)): "Test 1 Failed";
    }
}
