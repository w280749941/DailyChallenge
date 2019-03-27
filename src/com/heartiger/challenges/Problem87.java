package com.heartiger.challenges;

import com.heartiger.utils.ListNode;

/*
This problem was asked by Microsoft.

Let's represent an integer in a linked list format by having each node represent a digit in the number.
The nodes make up the number in reversed order.

For example, the following linked list:

1 -> 2 -> 3 -> 4 -> 5
is the number 54321.

Given two linked lists in this format, return their sum in the same linked list format.

For example, given

9 -> 9
5 -> 2
return 124 (99 + 25) as:

4 -> 2 -> 1
*/
public class Problem87 {
    ListNode sumUpTwoLinkedList(ListNode one, ListNode two){
        if(one == null && two == null)
            return null;

        if(one == null)
            return two;
        if(two == null)
            return one;

        ListNode result = new ListNode(0, null);
        ListNode dummy = result;
        int carry = 0;
        while(one != null && two != null){
            int total = one.val + two.val + carry;
            result.next = new ListNode(total % 10, null);
            carry = total / 10;
            one = one.next;
            two = two.next;
            result = result.next;
        }

        while(one != null){
            int total = carry + one.val;
            result.next = new ListNode(total % 10, null);
            carry = total / 10;
            one = one.next;
            result = result.next;
        }

        while(two != null){
            int total = carry + two.val;
            result.next = new ListNode(total % 10, null);
            carry = total / 10;
            two = two.next;
            result = result.next;
        }

        if(carry > 0){
            result.next = new ListNode(1, null);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Problem87 problem = new Problem87();
        ListNode one = new ListNode(9, new ListNode(9, null));
        ListNode two = new ListNode(5, new ListNode(2, null));
        ListNode expectedResult = new ListNode(4, new ListNode(2, new ListNode(1, null)));
        assert sameLinkedList(expectedResult, problem.sumUpTwoLinkedList(one, two));
    }

    private static boolean sameLinkedList(ListNode one, ListNode two) {
        if(one == null && two == null)
            return true;

        if(one == null || two == null)
            return false;

        while(one != null && two != null){
            if(one.val != two.val)
                return false;

            one = one.next;
            two = two.next;
        }

        return one == null && two == null;
    }
}
