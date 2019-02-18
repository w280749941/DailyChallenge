package com.heartiger.challenges;

import java.util.*;

import static com.heartiger.challenges.Problem38.sameList;

/*
This problem was asked by Airbnb.

We're given a hashmap associating each courseId key with a list of courseIds values, which represents that the prerequisites of courseId are courseIds. Return a sorted ordering of courses such that we can finish all courses.

Return null if there is no such ordering.

For example, given {'CSC300': ['CSC100', 'CSC200'], 'CSC200': ['CSC100'], 'CSC100': []}, should return ['CSC100', 'CSC200', 'CSCS300'].
*/
public class Problem61 {

    List<String> coursesDependency(Map<String, List<String>> courses){
        Map<String, Set<String>> hm = new HashMap<>();
        Queue<String> qu = new LinkedList<>();
        List<String> res = new LinkedList<>();
        for(Map.Entry<String, List<String>> entry: courses.entrySet()){
            if(entry.getValue().size() == 0){
                qu.offer(entry.getKey());
                res.add(entry.getKey());
            }
            hm.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }

        while(!qu.isEmpty()){
            String course = qu.poll();
            for(Map.Entry<String, Set<String>> entry: hm.entrySet()){
                Set<String> dep = entry.getValue();
                if(dep.contains(course)){
                    dep.remove(course);
                    if(dep.size() == 0){
                        qu.offer(entry.getKey());
                        res.add(entry.getKey());
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Problem61 problem = new Problem61();
        Map<String, List<String>> hm = new HashMap<>();
        hm.put("CSC300", Arrays.asList("CSC100", "CSC200"));
        hm.put("CSC200", Collections.singletonList("CSC100"));
        hm.put("CSC100", Collections.emptyList());
        List<String> expected = Arrays.asList("CSC100", "CSC200", "CSC300");
        assert sameList(problem.coursesDependency(hm), expected): "Test 1 Failed";
    }
}
