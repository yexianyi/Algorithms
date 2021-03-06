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
public class Solution {

	private int count = 0;
	
	//timeout
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        
		travel(obstacleGrid, 0, 0) ;
	
		return count ;
	}
	
	private void travel(int[][] grid, int row, int col){
		if(row==grid.length-1 && col==grid[0].length-1){
			count++ ;
			return ;
		}
		
		if(row<grid.length-1 && grid[row+1][col]!=1){
			travel(grid, row+1, col) ;
		}
		
		if(col<grid[0].length-1 && grid[row][col+1]!=1){
			travel(grid, row, col+1) ;
		}
		
	}
	
	public static void main(String[] args) {
		int[][] obstacleGrid = {{0,0,0},
								{0,1,0},
								{0,0,0}} ;
		
		System.out.println(new Solution().uniquePathsWithObstacles(obstacleGrid)) ;
	}

}
