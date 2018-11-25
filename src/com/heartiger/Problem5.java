package com.heartiger;

/*

    This problem was asked by Facebook.

    Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

    For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

    You can assume that the messages are decodable. For example, '001' is not allowed.
 */

public class Problem5 {

    private static int decodeMessage(String message){
        if(message == null){
            return 0;
        }

        int size = message.length();
        int[] dp = new int[size+1];
        dp[size] = 1;
        if(message.charAt(size-1) != '0'){
            dp[size-1] = 1;
        }

        for(int i=size-2; i>=0; i--){
            if(message.charAt(i) == '0'){
                continue;
            } else {
                if(Integer.parseInt(message.substring(i, i+2)) <= 26){
                    dp[i] = dp[i+1] + dp[i+2];
                } else {
                    dp[i] = dp[i+1];
                }
            }
        }

        return dp[0];
    }

    private static int decodeMessageRecursive(String message){
        int[] memo = new int[message.length()+1];
        return helper(message, message.length(), memo);
    }

    private static int helper(String message, int size, int[] memo) {
        if(message == null || size == 0){
            return 1;
        }
        int len = message.length() - size;
        if(message.charAt(len) == '0'){
            return 0;
        }
        if(memo[size] != 0){
            return memo[size];
        }

        int result = helper(message.substring(len+1), size - 1, memo);
        if(size >= 2 && Integer.parseInt(message.substring(len, len+2)) <= 26){
            result += helper(message.substring(len+1), size-2, memo);
        }
        memo[size] = result;
        return result;
    }

    public static void main(String[] args) {
        String message = "111";
        int expectedResult = 3;

        String message2 = "1111";
        int expectedResult2 = 5;

        assert decodeMessage(message) == expectedResult: "Test 1 Failed";

        assert decodeMessageRecursive(message2) == expectedResult2: "Test 2 Failed";
        System.out.println("PASSED");

    }
}
