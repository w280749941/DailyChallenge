package com.heartiger.challenges;

/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Amazon.

Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated successive characters as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

Implement run-length encoding and decoding. You can assume the string to be encoded have no digits and consists solely of alphabetic characters. You can assume the string to be decoded is valid.
 */

public class Problem20 {

    public String encode(String plainText){
        if(plainText == null || plainText.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        char letter;
        while(i<plainText.length()){
            letter = plainText.charAt(i);
            int count = 1;
            for(int j=i+1; j<plainText.length(); j++){
                if(plainText.charAt(j) == letter){
                    count++;
                } else{
                    break;
                }
            }
            i = i+count;
            sb.append(count);
            sb.append(letter);
        }
        return sb.toString();
    }

    public String decode(String encodedText){
        if(encodedText == null || encodedText.length() < 2 || encodedText.length() %2 != 0)
            return "";

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<encodedText.length(); i+=2){
            int count = Character.getNumericValue(encodedText.charAt(i));
            char letter = encodedText.charAt(i+1);
            for(int j=0; j<count; j++){
                sb.append(letter);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String plainText = "AAAABBBCCDAA";
        String encodedText = "4A3B2C1D2A";

        String plainText2 = "ABBCCCDDDDEEEEE";
        String encodedText2 = "1A2B3C4D5E";

        Problem20 problem = new Problem20();
        assert problem.encode(plainText).equals(encodedText): "Test 1 Failed";
        assert problem.decode(encodedText).equals(plainText): "Test 2 Failed";
        assert problem.encode(plainText2).equals(encodedText2): "Test 3 Failed";
        assert problem.decode(encodedText2).equals(plainText2): "Test 4 Failed";
    }
}
