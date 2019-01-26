package com.heartiger.challenges;

import java.util.*;

/* 

This problem was asked by Amazon.

Given a string s and an integer k, break up the string into multiple texts such that each text has a length of k or less. You must break it up so that words don't break across lines. If there's no way to break the text up, then return null.

You can assume that there are no spaces at the ends of the string and that there is exactly one space between each word.

For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. No string in the list has a length of more than 10.
*/
class Problem38
{
    List<String> getWords(String text, int len) {
        if(text == null || text.length() == 0 || len == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        String[] words = text.split(" ");
        int i = 0;
        while(i < words.length){
            int count = len;
            String temp = words[i];
            i++;
            while(i < words.length && words[i].length()+temp.length() < len){
                temp += " " + words[i];
                i++;
            }
            result.add(temp);
        }
        
        return result;
    }
    
    boolean sameList(List<String> lt1, List<String> lt2) {
        for(int i=0; i<lt1.size(); i++){
            if(!lt1.get(i).equals(lt2.get(i))){
                return false;
            }
        }
        
        return true;
    }
	public static void main (String[] args)
	{
		// your code goes here
		String example = "The quick brown fox jumps over the lazy dog";
		int len = 10;
		Problem38 problem = new Problem38();
		List<String> result = problem.getWords(example, len);
		List<String> expected = Arrays.asList("The quick", "brown fox", "jumps over", "the lazy", "dog");
		assert problem.sameList(expected, result): "Test 1 Failed";
	}
}
