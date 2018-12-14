package com.heartiger.challenges;

/*
    This problem was asked by Google.

    Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.

    The list is very long, so making more than one pass is prohibitively expensive.

    Do this in constant space and in one pass.
 */
public class Problem17 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode node){
            this.val = val;
            this.next = node;
        }
    }

    /*
        The idea is to have one pointer advance k nodes ahead.
        Both fast and slow nodes start at beginning.
        Then they both move one node at a time. When the fast node reach to null.
        Then the node ahead of the slow node should be skipped(removed).
     */
    public ListNode removeKthNodeFromEnd(ListNode node, int index){
        if(node == null)
            return null;

        ListNode fast = node;
        ListNode slow = node;
        while(index > 0){
            fast = fast.next;
            index--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return node;
    }

    public int sumNodes(ListNode node){
        int sum = 0;
        while(node != null){
            sum += node.val;
            node = node.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        Problem17 problem = new Problem17();

        assert problem.sumNodes(problem.removeKthNodeFromEnd(node, 3)) == 17: "Test 1 Failed";
        node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        assert problem.sumNodes(problem.removeKthNodeFromEnd(node, 5)) == 19: "Test 2 Failed";
    }
}
