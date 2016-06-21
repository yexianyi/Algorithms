package com.yxy.algorithms.grid.unique.paths.II;
/**
 * 63. Unique Paths II My Submissions QuestionEditorial Solution
	Total Accepted: 69280 Total Submissions: 233564 Difficulty: Medium
	Follow up for "Unique Paths":
	
	Now consider if some obstacles are added to the grids. How many unique paths would there be?
	
	An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	
	For example,
	There is one obstacle in the middle of a 3x3 grid as illustrated below.
	
	[
	  [0,0,0],
	  [0,1,0],
	  [0,0,0]
	]
	The total number of unique paths is 2.
	
	Note: m and n will be at most 100.
 * @author xianyiye
 * @date 06/21/2016
 * 
 * Copy from:
 * https://leetcode.com/discuss/29816/short-java-solution
 */
public class Solution4 {

	//1 ms
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		 int width = obstacleGrid[0].length;
		    int[] dp = new int[width];
		    dp[0] = 1;
		    for (int[] row : obstacleGrid) {
		        for (int j = 0; j < width; j++) {
		            if (row[j] == 1)
		                dp[j] = 0;
		            else if (j > 0)
		                dp[j] += dp[j - 1];
		        }
		    }
		    return dp[width - 1];
	}
	
	
	
	
	public static void main(String[] args) {
		
//		int[][] obstacleGrid = {{0,0,0},
//								{0,1,0},
//								{0,0,0}} ;
		
		int[][] obstacleGrid = {{0},{1}} ;
		
		System.out.println(new Solution4().uniquePathsWithObstacles(obstacleGrid)) ;
	}

}
