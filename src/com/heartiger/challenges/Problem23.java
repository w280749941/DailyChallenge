package com.heartiger.challenges;

/*
This problem was asked by Microsoft.

Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2

 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem23 {

    /*
    The goal is to maintain two heaps. One maxheap and one minheap. Where maxheap contains all smaller nums,
    and minheap contains all larger nums. If the total number count is even, then take the max from maxheap and
    the min from minheap then average both. If count is odd. then just use the top element from whichever
    heap has more element.
     */
    private double[] getRunningMedianFromStream(int[] nums){

        double[] result = new double[nums.length];
        PriorityQueue<Integer> smallerMaxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> largerMinHeap = new PriorityQueue<>();

        int i=0;
        for(int num: nums){
            addToHeaps(num, smallerMaxHeap, largerMinHeap);
            balanceHeaps(smallerMaxHeap, largerMinHeap);
            result[i++] = getMedium(smallerMaxHeap, largerMinHeap);
        }

        return result;
    }

    private double getMedium(PriorityQueue<Integer> smallerMaxHeap, PriorityQueue<Integer> largerMinHeap) {
        if((smallerMaxHeap.size() + largerMinHeap.size()) % 2 == 0)
            return ((double)smallerMaxHeap.peek() + largerMinHeap.peek()) / 2;
        PriorityQueue<Integer> moreElementsHeap = largerMinHeap.size() > smallerMaxHeap.size() ? largerMinHeap: smallerMaxHeap;
        return moreElementsHeap.peek();
    }

    private void balanceHeaps(PriorityQueue<Integer> smallerMaxHeap, PriorityQueue<Integer> largerMinHeap) {
        PriorityQueue<Integer> moreElementsHeap = largerMinHeap.size() > smallerMaxHeap.size() ? largerMinHeap: smallerMaxHeap;
        PriorityQueue<Integer> lessElementsHeap = smallerMaxHeap.size() < largerMinHeap.size() ? smallerMaxHeap: largerMinHeap;
        while(moreElementsHeap.size() - lessElementsHeap.size() > 1){
            lessElementsHeap.offer(moreElementsHeap.poll());
        }
    }

    private void addToHeaps(int num, PriorityQueue<Integer> smallerMaxHeap, PriorityQueue<Integer> largerMinHeap) {
        if(smallerMaxHeap.size() == 0 || num < smallerMaxHeap.peek())
            smallerMaxHeap.offer(num);
        else
            largerMinHeap.offer(num);
    }

    private boolean doubleArrayEqual(double[] nums1, double[] nums2){
        if(nums1.length != nums2.length)
            return false;

        for(int i=0; i<nums1.length; i++){
            if(nums1[i] != nums2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] example = new int[]{2, 1, 5, 7, 2, 0, 5};
        double[] result = new double[]{2, 1.5, 2, 3.5, 2, 2, 2};
        Problem23 problem = new Problem23();
        assert problem.doubleArrayEqual(problem.getRunningMedianFromStream(example), result): "Test 1 Failed";
    }
}
