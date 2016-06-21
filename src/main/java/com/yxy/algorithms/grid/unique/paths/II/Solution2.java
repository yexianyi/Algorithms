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
 * @date 06/14/2016
 * 
 */
public class Solution2 {

	//1 ms
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length] ;
		
		//init col
		int i=0 ;
		for(; i<obstacleGrid[0].length; i++){
			if(obstacleGrid[0][i]==0){
				dp[0][i] = 1 ;
			}else{
				break ;
			}
		}
		
		for(; i<obstacleGrid[0].length; i++){
			dp[0][i] = 0 ;
		}
		
		//init row
		int j=0 ;
		for(; j<obstacleGrid.length; j++){
			if(obstacleGrid[j][0]==0){
				dp[j][0] = 1 ;
			}else{
				break ;
			}
		}
		
		for(; j<obstacleGrid.length; j++){
			dp[j][0] = 0 ;
		}
		
		//calculate remaining
		for(int row=1; row<obstacleGrid.length; row++){
			for(int col=1; col<obstacleGrid[0].length; col++){
				if(obstacleGrid[row][col]==0){
					dp[row][col] = dp[row][col-1] + dp[row-1][col] ;
				}else{
					dp[row][col] = 0 ;
				}
			}
		}
	
		return dp[dp.length-1][dp[0].length-1] ;
	}
	
	
	
	
	public static void main(String[] args) {
//		int[][] obstacleGrid = {{0,0,0},
//								{0,1,0},
//								{0,0,0}} ;
		
		int[][] obstacleGrid = {{0,0,0},
								{1,0,0},
								{0,0,0}} ;
		
		System.out.println(new Solution2().uniquePathsWithObstacles(obstacleGrid)) ;
	}

}
