package com.heartiger.challenges;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static com.heartiger.challenges.Problem77.reverseArray;

/*
This problem was asked by Facebook.

Given a string and a set of delimiters, reverse the words in the string while maintaining the relative order of the delimiters. For example, given "hello/world:here", return "here/world:hello"

Follow-up: Does your solution work for the following cases: "hello/world:here/", "hello//world:here"
*/

public class Problem79 {

    public String reverseStringWithDelimiters(String word, Set<Character> delimiters){
        Queue<String> delimiterQueue = new LinkedList<>();
        for(int i=0; i<word.length(); i++) {
            if (delimiters.contains(word.charAt(i))) {
                StringBuilder temp = new StringBuilder();
                temp.append(word.charAt(i));
                while (i + 1 < word.length() && delimiters.contains(word.charAt(i + 1))) {
                    temp.append(word.charAt(i + 1));
                    i++;
                }
                delimiterQueue.offer(temp.toString());
            }
        }
        char[] charArray = word.toCharArray();
        reverseArray(charArray,0, word.length()-1);
        StringBuilder sb = new StringBuilder();
        int l=0;
        int r=0;
        while(r < charArray.length){
            if(delimiters.contains(charArray[r])){
                if(l != r){
                    reverseArray(charArray, l, r-1);
                    for(int i=l; i<r; i++)
                        sb.append(charArray[i]);
                    sb.append(delimiterQueue.poll());
                }
                l = r+1;
            }
            r++;
        }
        reverseArray(charArray, l, r-1);
        for(int i=l; i<r; i++)
            sb.append(charArray[i]);
        while(!delimiterQueue.isEmpty())
            sb.append(delimiterQueue.poll());
        return sb.toString();
    }

    public static void main(String[] args) {
        String example = "hello/world:here";
        String expected = "here/world:hello";
        Set<Character> st = new HashSet<>();
        st.add('/');
        st.add(':');
        Problem79 problem = new Problem79();

        String example2 = "hello/world:here/";
        String expected2= "here/world:hello/";


        String example3 = "hello//world:here";
        String expected3 = "here//world:hello";

        assert expected.equals(problem.reverseStringWithDelimiters(example, st)): "Test 1 Failed";
        assert expected2.equals(problem.reverseStringWithDelimiters(example2, st)): "Test 2 Failed";
        assert expected3.equals(problem.reverseStringWithDelimiters(example3, st)): "Test 3 Failed";

    }
}
