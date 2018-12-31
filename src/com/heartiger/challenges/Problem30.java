package com.heartiger.challenges;

/*
This problem was asked by Amazon.

Implement a stack that has the following methods:

push(val), which pushes an element onto the stack
pop(), which pops off and returns the topmost element of the stack. If there are no elements in the stack, then it should throw an error or return null.
max(), which returns the maximum value in the stack currently. If there are no elements in the stack, then it should throw an error or return null.
Each method should run in constant time.
 */

public class Problem30 {

    static class MaxNode {
        int val;
        int max;
        MaxNode next;

        MaxNode(int val, int max){
            this.val = val;
            this.max = max;
        }
    }

    static class MaxStack {
        MaxNode root;

        void push(int num){
            if(root == null){
                root = new MaxNode(num, num);
            } else {
                MaxNode temp = root;
                root = new MaxNode(num, Math.max(num, temp.max));
                root.next = temp;
            }
        }

        Integer pop(){
            if(root == null)
                return null;
            int returnVal = root.val;
            root = root.next;
            return returnVal;
        }

        Integer max(){
            if(root == null)
                return null;
            int returnVal = root.max;
            root = root.next;
            return returnVal;
        }
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        int[] example = new int[]{1, 3, 2, 5, 4};
        for(int num: example)
            maxStack.push(num);

        for(int num: example)
            System.out.println(maxStack.max());
    }
}
