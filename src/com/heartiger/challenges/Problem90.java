package com.heartiger.challenges;

import java.util.HashMap;
import java.util.Map;

/*

This question was asked by Snapchat.

Given the head to a singly linked list,
where each node also has a “random” pointer that points to anywhere in the linked list,
deep clone the list.


*/
public class Problem90 {
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        Node returnNode = new Node();
        Node curr = returnNode;

        Map<Integer, Node> hm = new HashMap<>();

        while(head != null){

            copyNode(head, curr, hm);

            if(head.next != null)
                copyNode(head.next, curr.next, hm);

            if(head.random != null){
                if(hm.containsKey(head.random.val)){
                    curr.next.random = hm.get(head.random.val);
                } else {
                    curr.next.random = new Node(head.random.val, null, null);
                    hm.put(head.random.val, curr.next.random);
                }
            }

            head = head.next;
            curr = curr.next;
        }

        return returnNode.next;
    }

    private void copyNode(Node head, Node curr, Map<Integer, Node> hm) {
        if (hm.containsKey(head.val)) {
            curr.next = hm.get(head.val);
        } else {
            curr.next = new Node(head.val, null, null);
            hm.put(head.val, curr.next);
        }
    }

    public static void main(String[] args) {
        Problem90 problem = new Problem90();
        Node next = new Node(2, null, null);
        next.random = next;
        Node node = new Node(1, next, next);
        Node actualResult = problem.copyRandomList(node);
        assert actualResult.val == 1: "Test 1 Failed";
        assert actualResult.next.val == 2: "Test 2 Failed";
        assert actualResult.random.val == 2: "Test 3 Failed";
        assert actualResult.next.random.val == 2: "Test 4 Failed";
    }
}
