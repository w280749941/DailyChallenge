package com.heartiger.extra;

import java.util.HashMap;
import java.util.Map;

public class LRU {

    static class Node{
        Node prev;
        Node next;
        int key;
        int val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int cap;

    private Map<Integer, Node> hm;

    public LRU(int size){
        this.hm = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        this.cap = size;
    }

    private int get(int key){
        Node node = hm.get(key);
        if(node == null){
            return -1;
        }

        updateQueue(node);
        return node.val;
    }

    private void updateQueue(Node node) {
        deleteOldNode(node);
        addNewNode(node);
    }

    private void addNewNode(Node node) {
        Node next = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next = next;
        next.prev = node;
        this.cap--;
    }

    private void deleteOldNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        this.cap++;
    }

    private void put(int key, int val){
        if(this.hm.containsKey(key)){
            deleteOldNode(this.hm.get(key));
        }
        Node node = new Node(key, val);
        this.hm.put(key, node);
        addNewNode(node);
        if(this.cap < 0){
            removeTheLeastUsedOne();
        }
    }

    private void removeTheLeastUsedOne() {
        Node nodeToRemove = this.tail.prev;
        hm.remove(nodeToRemove.key);
        deleteOldNode(nodeToRemove);
    }

    public static void main(String[] args) {
        LRU cache = new LRU(2);

        cache.put(1,1);
        cache.put(2,2);

        assert cache.get(1) == 1: "Test 1 failed";
        cache.put(3, 3);
        assert cache.get(2) == -1: "Test 2 failed";
        cache.put(4, 4);
        assert cache.get(1) == -1: "Test 3 failed";
        assert cache.get(3) == 3: "Test 4 failed";
        assert cache.get(4) == 4: "Test 5 failed";

        System.out.println("Passed");
    }
}

/* Recent version.
class LRUCache {

    static class ListNode{
        int key;
        int val;
        ListNode prev;
        ListNode next;
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }


    Map<Integer, ListNode> hm;
    ListNode head;
    ListNode tail;
    int cap;
    public LRUCache(int capacity) {
        hm = new HashMap<>();
        head = new ListNode(0, 0);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.cap = capacity;
    }

    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }

        ListNode node = hm.get(key);
        removeNode(node);
        addNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(hm.containsKey(key)){
            ListNode node = hm.get(key);
            removeNode(node);
            node.val = value;
            addNode(node);
        } else {
            if(this.cap == this.hm.size()){
                removeTail();
            }
            ListNode node = new ListNode(key, value);
            addNode(node);
        }
    }

    private void removeNode(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        hm.remove(node.key);
    }

    private void addNode(ListNode node){
        ListNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        hm.put(node.key, node);
    }

    private void removeTail(){
        ListNode nodeToBeRemoved = tail.prev;
        removeNode(nodeToBeRemoved);
    }
}
*/