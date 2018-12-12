package com.heartiger.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {

    private TrieNode root;
    private int size;

    public Trie(){
        this.root = new TrieNode();
    }

    public Trie(String[] dataSource){
        this.root = new TrieNode();
        for(String data: dataSource){
            this.add(data);
        }
    }

    /** Return number of words contained */
    public int size(){
        return this.size;
    }

    /** Return the root of current Trie */
    public TrieNode getRoot(){
        return this.root;
    }

    /** Return whether current Trie contains a word */
    public boolean contains(String word){
        TrieNode node = this.getNodeContainsPrefix(word);
        return node != null && node.isWord;
    }

    /** Add a word to current Trie */
    public void add(String word){
        if(word == null) return;
        TrieNode node = this.root;

        // For each letter, if current node doesn't have a path
        // Create a new node. and move pointer to that node.
        for(int i=0; i<word.length(); i++){
            char letter = Character.toLowerCase(word.charAt(i));
            node.next.putIfAbsent(letter, new TrieNode());
            node = node.next.get(letter);
        }

        // If it's not a word, then set it to a word.
        if(!node.isWord){
            node.isWord = true;
            size++;
        }
    }

    /** Return whether current Trie contains a prefix */
    public boolean containsPrefix(String word){
        return this.getNodeContainsPrefix(word) != null;
    }

    private TrieNode getNodeContainsPrefix(String word){
        if(word == null) return null;
        TrieNode node = this.root;

        // If current node doesn't contains a path to a letter return null
        // Otherwise move pointer to next node.
        for(int i=0; i<word.length(); i++){
            char letter = Character.toLowerCase(word.charAt(i));

            if(!node.next.containsKey(letter))
                return null;
            node = node.next.get(letter);
        }
        return node;
    }

    /** A blurry search with '.' replace any letter
     *  Only return true if there is a word with the same length. */
    public boolean blurrySearch(String word){
        return this.blurrySearch(this.root, word, 0);
    }

    private boolean blurrySearch(TrieNode root, String word, int index) {
        if(word == null) return false;

        if(index == word.length() && root.isWord)
            return true;

        TrieNode node = root;
        for(int i=index; i<word.length(); i++){
            char letter = Character.toLowerCase(word.charAt(i));
            if(letter != '.'){
                if(!node.next.containsKey(letter))
                    return false;
                node = node.next.get(letter);
            } else{
                for(TrieNode item: node.next.values()){
                    if(blurrySearch(item, word, i+1)){
                        return true;
                    }
                }
            }
        }
        return node.isWord;
    }

    /** Return List of Strings are similar to target word */
    public List<String> getBlurrySearchResult(String word){
        if(word == null) return null;
        List<String> result = new ArrayList<>();
        this.getBlurrySearchResult(this.root, word, 0, result, "");
        return result;
    }

    private void getBlurrySearchResult(TrieNode root, String word, int index, List<String> lt, String s) {

        if(index == word.length() && root.isWord){
            lt.add(s);
            return;
        }

        TrieNode node = root;
        StringBuilder sb = new StringBuilder(s);
        for(int i=index; i<word.length(); i++){
            char letter = Character.toLowerCase(word.charAt(i));

            // If the path to a node is not '.', add it and move pointer to next.
            if(letter != '.'){
                if(!node.next.containsKey(letter))
                    return;
                sb.append(letter);
                node = node.next.get(letter);
            } else{
                // If current path is a '.', try out all words.
                for(Map.Entry<Character, TrieNode> item: node.next.entrySet()){
                    getBlurrySearchResult(item.getValue(), word, i+1, lt, sb.toString() + item.getKey());
                }
            }
        }
        if(node.isWord && s.length() == word.length())
            lt.add(sb.toString());
    }

    public List<String> getAllWordsContainsPrefix(String prefix){
        TrieNode node = this.getNodeContainsPrefix(prefix);
        if(node == null){
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(prefix);
        helper(sb, result, node);
        return result;
    }

    private void helper(StringBuilder sb, List<String> result, TrieNode node){
        if(node.isWord) {
            result.add(sb.toString());
        }
        for(Map.Entry<Character, TrieNode> item: node.next.entrySet())
        {
            sb.append(item.getKey());
            helper(sb, result, item.getValue());
            sb.deleteCharAt(sb.length()-1);
        }
    }
}