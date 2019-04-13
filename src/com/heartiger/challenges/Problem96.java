package com.heartiger.challenges;

import com.heartiger.utils.ListNode;

/*
This problem was asked by Google.

Given the head of a singly linked list, swap every two nodes and return its head.

For example, given 1 -> 2 -> 3 -> 4, return 2 -> 1 -> 4 -> 3.
 */
public class Problem96 {

    ListNode swapEveryTwoNodes(ListNode head){

        ListNode curr = new ListNode(0, null);
        ListNode next = new ListNode(0, head);
        ListNode start = next;
        curr.next = next;
        while(next.next != null && next.next.next != null){
            curr = next.next;
            next = next.next.next;
            int temp = curr.val;
            curr.val = next.val;
            next.val = temp;
        }
        return start.next;
    }

    public static void main(String[] args) {
        Problem96 problem = new Problem96();
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode actualResult = problem.swapEveryTwoNodes(node);
        assert actualResult.val == 2: "Test 1 Failed";
        actualResult = actualResult.next;
        assert actualResult.val == 1: "Test 2 Failed";
        actualResult = actualResult.next;
        assert actualResult.val == 4: "Test 3 Failed";
        actualResult = actualResult.next;
        assert actualResult.val == 3: "Test 4 Failed";
    }
}
