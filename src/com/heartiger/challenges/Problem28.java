package com.heartiger.challenges;

import java.util.*;

/*

This problem was asked by Facebook.

Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, and a starting airport, compute the person's itinerary. If no such itinerary exists, return null. If there are multiple possible itineraries, return the lexicographically smallest one. All flights must be used in the itinerary.

For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].

Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.

Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', you should return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary. However, the first one is lexicographically smaller.
 */
public class Problem28 {

    /*
    The idea is to use HashMap provide constant checking start location.
    And sorted queue to get lexicographically smallest destination in log(n).
    Total time complexity would be nlogn.
     */
    public List<String> findItinerary(String[][] tickets, String start) {
        Map<String, Queue<String>> hm = new HashMap<>();

        for (String[] ticket : tickets) {
            if (hm.containsKey(ticket[0])) {
                hm.get(ticket[0]).offer(ticket[1]);
            } else {
                PriorityQueue<String> queue = new PriorityQueue<>();
                queue.offer(ticket[1]);
                hm.put(ticket[0], queue);
            }
        }

        List<String> result = new ArrayList<>();
        result.add(start);
        while(hm.containsKey(start)){
            start = hm.get(start).poll();
            if(start == null)
                break;
            result.add(start);
        }
        return result;
    }

    private boolean equalList(List<String> lt1, List<String> lt2){
        if(lt1.size() != lt2.size())
            return false;

        for(int i=0; i<lt1.size(); i++){
            if(!lt1.get(i).equals(lt2.get(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem28 problem = new Problem28();
        String[][] example = new String[][]{
                {"A", "B"},
                {"A", "C"},
                {"B", "C"},
                {"C", "A"}
        };

        String start = "A";

        List<String> expectedResult = Arrays.asList("A", "B", "C", "A", "C");
        List<String> actualResult = problem.findItinerary(example, start);
        assert problem.equalList(actualResult, expectedResult): "Test 1 Failed";

        String[][] example2 = new String[][]{
                {"SFO", "HKO"},
                {"YYZ", "SFO"},
                {"YUL", "YYZ"},
                {"HKO", "ORD"}
        };

        String start2 = "YUL";

        List<String> expectedResult2 = Arrays.asList("YUL", "YYZ", "SFO", "HKO", "ORD");
        List<String> actualResult2 = problem.findItinerary(example2, start2);
        assert problem.equalList(actualResult2, expectedResult2): "Test 2 Failed";
    }
}
