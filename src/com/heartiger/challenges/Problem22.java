package com.heartiger.challenges;

public class Problem22 {

    public void threeWaysSort(char[] letters){
        int lt = 0;
        int gt = letters.length;
        int i = 1;
        while(i < gt){
            if(letters[i] == 'R'){
                swap(letters, i, lt+1);
                lt++;
                i++;
            } else if(letters[i] == 'B'){
                swap(letters, i, gt-1);
                gt--;
            } else {
                i++;
            }
        }
        swap(letters,0, lt);
    }

    private void swap(char[] letters, int l, int r){
        char temp = letters[l];
        letters[l] = letters[r];
        letters[r] = temp;
    }

    private boolean sameArray(char[] arr1, char[] arr2){
        if(arr1.length != arr2.length)
            return false;

        for(int i=0; i<arr1.length; i++){
            if(arr1[i] != arr2[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        char[] letters = new char[]{'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        char[] expectedResult = new char[]{'R', 'R', 'R', 'G', 'G', 'B', 'B'};

        Problem22 problem = new Problem22();
        problem.threeWaysSort(letters);
        assert problem.sameArray(letters, expectedResult): "Test 1 Failed";
    }
}
