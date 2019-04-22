package com.heartiger.challenges;

/*
Find an efficient algorithm to find the smallest distance (measured in number of words) between any two given words in a string.

For example, given words "hello", and "world" and a text content of "dog cat hello cat dog dog hello cat world",
return 1 because there's only one word "cat" in between the two words.
 */
public class Problem100 {

    int getMinDistance(String sentence, String word1, String word2){
        int prevIndex = 0;
        String[] words = sentence.split(" ");
        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(word.equals(word1) || word.equals(word2)){
                prevIndex = i;
                break;
            }
        }
        int minDistance = Integer.MAX_VALUE;

        for(int i=prevIndex; i<words.length; i++){
            String word = words[i];
            if((word.equals(word1) || word.equals(word2))){
                if(!word.equals(words[prevIndex]) && i - prevIndex < minDistance){
                    minDistance = i - prevIndex - 1;
                }
                prevIndex = i;
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        Problem100 problem = new Problem100();

        String example = "dog cat hello cat dog dog hello cat world";
        String word1 = "hello";
        String word2 = "world";
        int actualResult = problem.getMinDistance(example, word1, word2);
        int expectedResult = 1;
        assert expectedResult == actualResult: "Test 1 Failed";
    }
}
