package com.heartiger.challenges;
import com.heartiger.challenges.Problem12.Interval;

/*
This problem was asked by Google.

Given a set of closed intervals, find the smallest set of numbers that covers all the intervals.
If there are multiple smallest sets, return any of them.

For example, given the intervals [0, 3], [2, 6], [3, 4], [6, 9], one set of numbers that covers all these intervals is {3, 6}.
*/
public class Problem88 {

    /** What if minEndTime > maxStartTime */
    Interval getMinCoverInterval(Interval[] intervals){
        int minEndTime = Integer.MAX_VALUE;
        int maxStartTime = Integer.MIN_VALUE;
        for(Interval interval: intervals){
            minEndTime = Math.min(minEndTime, interval.end);
            maxStartTime = Math.max(maxStartTime, interval.start);
        }
        return new Interval(minEndTime, maxStartTime);
    }

    public static void main(String[] args) {
        Problem88 problem = new Problem88();
        Interval[] intervals = new Interval[]{
                new Interval(0, 3),
                new Interval(2, 6),
                new Interval(3, 4),
                new Interval(6, 9)
        };
        Interval expectedResult = new Interval(3, 6);
        Interval actualResult = problem.getMinCoverInterval(intervals);
        assert expectedResult.start == actualResult.start && expectedResult.end == actualResult.end: "Test 1 Failed";
    }
}
