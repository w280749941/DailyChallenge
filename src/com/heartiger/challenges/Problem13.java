package com.heartiger.challenges;

import java.util.*;

/*
    This problem was asked by Microsoft.

    Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

    For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

    Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */
public class Problem13 {

    /*
        The idea is to use backtracking and memorization. Memorization is being built up from right side to left.
        Split target string by available strings in dictionary. Thus, we guarantee that every split is valid.
        Memorization stored with HashMap which provides constant time loop up for a particular substring.
     */
    public List<String> wordBreak(String target, List<String> wordDict){
        return helper(target, new HashSet<>(wordDict), new HashMap<>());
    }

    private List<String> helper(String target, Set<String> wordDict, Map<String, List<String>> hm){
        if(hm.containsKey(target)){
            return hm.get(target);
        }

        List<String> arr = new ArrayList<>();
        if(target.length() == 0){
            arr.add("");
            return arr;
        }

        for(String word: wordDict){
            if(target.startsWith(word)){
                List<String> subList = helper(target.substring(word.length()), wordDict, hm);
                for(String sub: subList){
                    arr.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        hm.put(target, arr);
        return arr;
    }

    public static void main(String[] args) {
        Problem13 problem = new Problem13();

        String test1 = "thequickbrownfox";
        List<String> strings1 = Arrays.asList("quick", "brown", "the", "fox");
        problem.wordBreak(test1, strings1).forEach(System.out::println);

        String test2 = "bedbathandbeyond";
        List<String> strings2 = Arrays.asList("bed", "bath", "bedbath", "and", "beyond");
        problem.wordBreak(test2, strings2).forEach(System.out::println);
    }
}
