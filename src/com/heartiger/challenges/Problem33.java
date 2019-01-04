package com.heartiger.challenges;

/*
This problem was asked by Facebook.

Given a array of numbers representing the stock prices of a company in chronological order, write a function that calculates the maximum profit you could have made from buying and selling that stock once. You must buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.
 */
public class Problem33 {

    int maxProfit(int[] stocks){
        int minEle = stocks[0];
        int result = 0;
        for(int i=1; i<stocks.length; i++){
            if(stocks[i] < minEle){
                minEle = stocks[i];
            } else {
                result = stocks[i] - minEle;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem33 problem = new Problem33();
        int[] example = new int[]{9, 11, 8, 5, 7, 10};
        int result = 5;
        assert problem.maxProfit(example) == result: "Test 1 Failed";
    }
}
