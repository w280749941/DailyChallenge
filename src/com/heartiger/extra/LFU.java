package com.heartiger.extra;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/*
This problem was asked by Facebook.

Given a list of integers, return the largest product that can be made by multiplying any three integers.

For example, if the list is [-10, -10, 5, 2], we should return 500, since that's -10 * -10 * 5.

You can assume the list has at least three integers.

*/
class LFU {

    static class Node{
        int key;
        int val;
        int freq;
        Node(int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1; // Default frequency is 1.
        }
    }

    Map<Integer, Node> hm; // Key -> Node object mapping. For quick retrieve node.
    // Frequency -> Ordered hashSet of Node. Append new node at the end, and pop from front with the help of iterator.
    Map<Integer, LinkedHashSet<Node>> fq;
    int cap;
    int minFreq;
    public LFU(int capacity) {
        this.cap = capacity;
        hm = new HashMap<>();
        fq = new HashMap<>();
        this.minFreq = 1;
    }

    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        Node node = hm.get(key);
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(this.cap == 0){
            return;
        }
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.val = value;
            updateNode(node);
        } else {
            if(this.cap == hm.size()){
                removeMin(); // Remove the least frequent used node.
            }
            Node node = new Node(key, value);
            this.minFreq = 1;
            addNode(node);
        }
    }

    // Remove it from freq set and update freq add it to new freq set.
    private void updateNode(Node node){
        removeNode(node);
        node.freq++;
        addNode(node);
    }

    private void removeNode(Node node){
        LinkedHashSet set = fq.get(node.freq);
        set.remove(node);
        if(set.isEmpty()){
            fq.remove(node.freq);
            // update minFreq if minFreq pointed set is empty.
            // minFreq will be added when new node added and a node being get will increase minFreq
            // if the node is the last one in that set
            if(minFreq == node.freq){
                minFreq++;
            }
        }
        hm.remove(node.key);
    }

    private void addNode(Node node){
        fq.putIfAbsent(node.freq, new LinkedHashSet<>());
        LinkedHashSet<Node> set = fq.get(node.freq);
        set.add(node);
        hm.put(node.key, node);
    }

    // Find the least frequent node set with fq map, remove the oldest node from that set by using a iterator of a linkedlist.
    private void removeMin(){
        LinkedHashSet<Node> set = fq.get(minFreq);
        Iterator<Node> it = set.iterator();
        Node node = it.next();
        removeNode(node);
    }

    public static void main(String[] args) {
        LFU cache = new LFU( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.get(3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
