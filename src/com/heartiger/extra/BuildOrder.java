package com.heartiger.extra;

import java.util.*;

/*
You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the second
project is dependent on the first project). All of project's dependencies must be built before the project is. Find a
build order that will allow the projects to be built. If there is no valid build order, return an error.

Input:
    project char[]: [a,b,c,d,e,f]
    dependencies:char[][] {{a, d}, {f, b}, {b, d}, {f, a}, {d, c}}

Output:
    char[] {f, e, a, b, d, c}

 */
public class BuildOrder {

    char[] buildOrder(char[] projects, char[][] dependencies){
        int[] dependencyCounter = new int[projects.length];
        Map<Character, List<Character>> dependencySolver = new HashMap<>();
        for(char[] dependency: dependencies){
            dependencySolver.putIfAbsent(dependency[0], new ArrayList<>());
            dependencySolver.get(dependency[0]).add(dependency[1]);
            dependencyCounter[dependency[1]-'a']++;
        }

        char[] result = new char[projects.length];
        int k = 0;
        Queue<Character> queue = new LinkedList<>();
        for(int i=0; i<dependencyCounter.length; i++){
            if(dependencyCounter[i] == 0){
                char temp = (char) ('a'+i);
                queue.offer(temp);
                result[k++] = temp;
            }
        }

        while(!queue.isEmpty()){
            char project = queue.poll();
            List<Character> dependenciesCanBeSolved = dependencySolver.get(project);
            if(dependenciesCanBeSolved == null)
                continue;
            for(int i=0; i<dependenciesCanBeSolved.size(); i++){
                int index = dependenciesCanBeSolved.get(i)-'a';
                dependencyCounter[index]--;
                if(dependencyCounter[index] == 0){
                    char temp = (char) ('a' + index);
                    queue.offer(temp);
                    result[k++] = temp;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BuildOrder buildOrder = new BuildOrder();
        char[] projects = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        char[][] dependencies = new char[][]{{'a', 'd'}, {'f', 'b'}, {'b', 'd'}, {'f', 'a'}, {'d', 'c'}};
        char[] result =  buildOrder.buildOrder(projects, dependencies);
        for(char item: result){
            System.out.print(item + " ");
        }
    }
}
