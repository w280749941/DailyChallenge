package com.heartiger.challenges;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*

This problem was asked by Google.

Given k sorted singly linked lists, write a function to merge all the lists into one sorted singly linked list.
*/
public class Problem52 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    ListNode mergeKLists(ListNode[] listNodes){

        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode listNode: listNodes)
            pq.offer(listNode);

        ListNode result = new ListNode(0);
        ListNode curr = result;
        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            curr.next = temp;
            curr = curr.next;
            temp = temp.next;
            if(temp != null)
                pq.offer(temp);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));
        ListNode expected = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5, new ListNode(6))))))));

        Problem52 problem = new Problem52();
        ListNode actual = problem.mergeKLists(new ListNode[]{node1, node2, node3});
        assert sameListNode(expected, actual): "Test 1 Failed";
    }

    private static boolean sameListNode(ListNode expected, ListNode actual) {
        while(expected != null){
            if(actual == null || expected.val != actual.val)
                return false;
            expected = expected.next;
            actual = actual.next;
        }

        return true;
    }
}
