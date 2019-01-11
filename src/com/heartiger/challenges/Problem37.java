package com.heartiger.challenges;

/*
This problem was asked by Apple.

Implement a queue using two stacks.
Recall that a queue is a FIFO (first-in, first-out) data structure with the following methods:
enqueue, which inserts an element into the queue, and dequeue,
which removes it.

*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem37 {

    static class StackQueue<T> {
        Stack<T> inS = new Stack<>();
        Stack<T> outS = new Stack<>();

        void enqueue(T item){
            inS.push(item);
        }

        T dequeue(){
            if(outS.isEmpty()){
                while(!inS.isEmpty()){
                    outS.push(inS.pop());
                }
            }

            return outS.pop();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        StackQueue<Integer> sq = new StackQueue<>();
        for(int i=0; i<5; i++){
            queue.offer(i);
            sq.enqueue(i);
        }
        assert sameQueues(queue, sq): "Test 1 Failed";
    }

    private static boolean sameQueues(Queue<Integer> queue, StackQueue<Integer> sq) {
        while(!queue.isEmpty()){
            if(!queue.poll().equals(sq.dequeue()))
                return false;
        }
        return true;
    }
}
