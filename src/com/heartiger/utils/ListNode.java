package com.heartiger.utils;

import java.util.HashMap;
import java.util.Map;

public class ListNode{
    boolean isWord;
    Map<Character, ListNode> next;
    ListNode() {
        next = new HashMap<>();
    }
}