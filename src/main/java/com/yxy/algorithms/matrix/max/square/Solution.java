package com.yxy.algorithms.matrix.max.square;

/**
 * 221. Maximal Square
Medium
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 * @author Ye Xianyi
 * 2020/07/02
 *
 *  Copy from:
 *  https://leetcode.com/problems/maximal-square/solution/
 */
public class Solution {

    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) {
            return 0 ;
        }
        
        
        int maxLen = 0 ;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        
        for(int i=1; i<=matrix.length; i++) {
            for(int j=1; j<=matrix[0].length; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1 ;
                    maxLen = Math.max(maxLen, dp[i][j]) ;
                }
            }
        }
        
        return maxLen * maxLen ;
    }
    

    public static void main(String[] args) {
//        int[][] matrix = { {1,2,3,4},
//                            {12,13,14,5},
//                            {11,16,15,6},
//                            {10,9,8,7}} ;
        
//        char[][] matrix = { 
//                {'1','2','3','4'},
//                {'2','3','4','5'},
//                {'1','6','5','6'},
//                {'0','9','8','7'}} ;
        
      char[][] matrix = { 
      {'1', '0', '1', '0', '0'},
      {'1', '0', '1', '1', '1'},
      {'1', '1', '1', '1', '1'},
      {'1', '0', '0', '1', '0'}} ;
      
       System.out.print(maximalSquare(matrix));
    }

}
