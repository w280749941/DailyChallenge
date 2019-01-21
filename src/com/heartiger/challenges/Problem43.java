package com.heartiger.challenges;


/*
This problem was asked by Microsoft.

Given a 2D matrix of characters and a target word, write a function that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.

For example, given the following matrix:

[['F', 'A', 'C', 'I'],
 ['O', 'B', 'Q', 'P'],
 ['A', 'N', 'O', 'B'],
 ['M', 'A', 'S', 'S']]
and the target word 'FOAM', you should return true, since it's the leftmost column. Similarly, given the target word 'MASS', you should return true, since it's the last row.

*/
public class Problem43 {

    boolean containsWord(char[][] words, String word){
        for(int r=0; r<words.length; r++){
            for(int c=0; c<words[r].length; c++){
                if(words[r][c] == word.charAt(0)){
                    if(visitNeighbor(words, word, r, c, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean visitNeighbor(char[][] words, String word, int r, int c, int index) {
        if(index == word.length()){
            return true;
        }

        if(words[r][c] != word.charAt(index)){
            return false;
        }

        // Right
        if(c+(word.length()-index) <= words[r].length){
            if(visitNeighbor(words, word, r, c+1, index+1)){
                return true;
            }
        }

        // Down
        if(r+(word.length()-index) <= words.length){
            if(visitNeighbor(words, word, r+1, c, index+1)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] example = new char[][]{
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}
        };
        String targetWord = "FOAM";
        String targetWord2 = "MASS";
        String targetWord3 = "ABN";
        String targetWord4 = "NOQ";
        Problem43 problem = new Problem43();
        assert problem.containsWord(example, targetWord): "Test 1 Failed";
        assert problem.containsWord(example, targetWord2): "Test 2 Failed";
        assert problem.containsWord(example, targetWord3): "Test 3 Failed";
        assert !problem.containsWord(example, targetWord4): "Test 4 Failed";
    }
}
