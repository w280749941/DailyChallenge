package com.heartiger.challenges;


import com.heartiger.utils.ListNode;

/*
 *
 * This problem was asked by Google.
 *
 * Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.
 *
 * For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.
 *
 * In this example, assume nodes with the same value are the exact same node objects.
 *
 * Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
 */

public class Problem11 {

    /*
    The idea is to loop through two linked list to check whether they meet at a node before reach null.
    When node1 reach the end, start with node2. At the same time, do the opposite with node2.
     */
    private ListNode getIntersection(ListNode node1, ListNode node2){
        if(node1 == null || node2 == null){
            return null;
        }

        ListNode dummy1 = node1;
        ListNode dummy2 = node2;
        boolean node1Loop = false;
        boolean node2Loop = false;

        while(dummy1 != null && dummy2 != null){
            if(dummy1 == dummy2){
                return dummy1;
            }

            dummy1 = dummy1.next;
            dummy2 = dummy2.next;

            if(dummy1 == null && !node1Loop){
                node1Loop = true;
                dummy1 = node2;
            }

            if(dummy2 == null && !node2Loop){
                node2Loop = true;
                dummy2 = node1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Problem11 problem = new Problem11();

        ListNode inter1 = new ListNode(8, new ListNode(10, null));
        ListNode nodeA = new ListNode(3, new ListNode(7, inter1));
        ListNode nodeB = new ListNode(99, new ListNode(1, inter1));

        assert problem.getIntersection(nodeA, nodeB) == inter1: "Test 1 Failed";

        ListNode inter2 = new ListNode(31, new ListNode(32, new ListNode(33, null)));
        ListNode nodeC = new ListNode(1, new ListNode(2, inter2));
        ListNode nodeD = new ListNode(21, new ListNode(22, new ListNode(23, inter2)));

        assert problem.getIntersection(nodeC, nodeD) == inter2: "Test 2 Failed";

        ListNode nodeE = new ListNode(1, new ListNode(2, null));
        ListNode nodeF = new ListNode(3, new ListNode(4, null));

        assert problem.getIntersection(nodeE, nodeF) == null: "Test 3 Failed";
    }

}
