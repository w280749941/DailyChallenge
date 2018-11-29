package com.heartiger.challenges;

import com.heartiger.utils.Trie;

import java.util.List;
import java.util.Scanner;

/*

This problem was asked by Twitter.

Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.

For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.

 */
public class Problem7 {

    private Trie trie;

    private Problem7(String[] dataSource){
        trie = new Trie(dataSource);
    }

    private void printAllPossibleString(String input){
        List<String> result = this.trie.getAllWordsContainsPrefix(input);
        for(String word: result){
            System.out.println(word + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] dataSource = new String[]{"dog", "deer", "deal"};

        Problem7 problem = new Problem7(dataSource);
        Scanner scanner = new Scanner(System.in);
        while(true){
            String input = scanner.nextLine();
            problem.printAllPossibleString(input);
        }
    }
}
