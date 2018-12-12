package com.heartiger.challenges;


/*
    This problem was asked by Snapchat.

    Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

    For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem12 {

    static class Interval {
        int start;
        int end;

        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    /*
        The idea is to sort by start time. If there is an overlap(the next start time smaller than previous end time).
        Add a new room, also add end time to the schedule. This algorithm fills room by earliest time available in
        all rooms.
     */
    public int getRequiredRooms(Interval[] intervals){
        if(intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(intervals[0].end);

        int count = 1;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i].start < priorityQueue.peek()){
                count++;
            } else {
                priorityQueue.poll();
            }

            priorityQueue.offer(intervals[i].end);
        }

        return count;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{
                new Interval(30, 75),
                new Interval(0, 50),
                new Interval(60, 150)
        };

        Problem12 problem = new Problem12();
        assert problem.getRequiredRooms(intervals) == 2: "Test 1 Failed";

        Interval[] intervals2 = new Interval[]{
                new Interval(1, 3),
                new Interval(2, 4),
                new Interval(1, 4),
                new Interval(5, 10)
        };

        assert problem.getRequiredRooms(intervals2) == 3: "Test 2 Failed";

    }
}
