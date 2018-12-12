package com.heartiger.utils;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> next;
    TrieNode() {
        next = new HashMap<>();
    }
}