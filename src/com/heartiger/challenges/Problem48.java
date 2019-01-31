package com.heartiger.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.heartiger.challenges.Problem38.sameList;

/*
This problem was asked by Google.

Given the head of a singly linked list, reverse it in-place.
*/
public class Problem48 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    ListNode reverseLinkedListRecursively(ListNode node){
        if(node == null || node.next == null)
            return node;

        ListNode returnNode = reverseLinkedListRecursively(node.next);
        node.next.next = node;
        node.next = null;
        return returnNode;
    }

    ListNode reverseLinkedListIteratively(ListNode node){
        if(node == null || node.next == null)
            return node;
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }


    public static void main(String[] args) {
        Problem48 problem = new Problem48();
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        List<Integer> expected = Arrays.asList(4, 3, 2, 1);
        List<Integer> actualRecursiveResult = new ArrayList<>();
        ListNode recursiveResult = problem.reverseLinkedListRecursively(root);
        while(recursiveResult != null){
            actualRecursiveResult.add(recursiveResult.val);
            recursiveResult = recursiveResult.next;
        }

        root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode iterativeResult = problem.reverseLinkedListIteratively(root);
        List<Integer> actualIterativeResult = new ArrayList<>();
        while(iterativeResult != null){
            actualIterativeResult.add(iterativeResult.val);
            iterativeResult = iterativeResult.next;
        }

        assert(sameList(expected, actualRecursiveResult)): "Test 1 Failed";
        assert(sameList(expected, actualIterativeResult)): "Test 2 Failed";
    }
}
