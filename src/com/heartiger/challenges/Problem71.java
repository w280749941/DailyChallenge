package com.heartiger.challenges;

/*
This problem was asked by Google.

Determine whether a doubly linked list is a palindrome. What if it’s singly linked?

For example, 1 -> 4 -> 3 -> 4 -> 1 returns True while 1 -> 4 returns False.
*/
public class Problem71 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode (int val){this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    boolean isPalindrome(ListNode head){
        if(head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = null;
        if(fast != null){
            second = reverseNode(slow.next);
        } else {
            second = reverseNode(slow);
        }

        while(second != null){
            if(head.val != second.val){
                return false;
            }
            head = head.next;
            second = second.next;
        }

        return true;
    }

    private ListNode reverseNode(ListNode root) {
        if(root == null || root.next == null) {
            return root;
        }

        ListNode prev = null;
        ListNode curr = root;
        ListNode next = root.next;

        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(4, new ListNode(1)))));
        boolean expected = true;
        Problem71 problem = new Problem71();
        ListNode head2 = new ListNode(1, new ListNode(2));
        boolean expected2 = false;
        assert problem.isPalindrome(head)==expected: "Test 1 Failed";
        assert problem.isPalindrome(head)==expected2: "Test 2 Failed";
    }
}
