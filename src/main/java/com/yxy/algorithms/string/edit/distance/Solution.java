package com.yxy.algorithms.string.edit.distance;

/**
 * 72. Edit Distance
Hard

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

 * @author yexianyi
 * 2019/09/12
 * 
 * Reference from:
 * https://www.cnblogs.com/Kobe10/p/6365881.html
 */
public class Solution {

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // del the num of steps for changing from str1(len=i) to ''
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        // add the num of steps for changing from '' to str2(len=i)
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] ;
                } else {
                    int insert = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int update = dp[i-1][j-1] + 1;
                    
                    dp[i][j] = Math.min(Math.min(insert, del), update) ;
                }
                
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {

        System.out.println(minDistance("horse","ros"));
        
    }

}
