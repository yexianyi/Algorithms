package com.yxy.algorithms.grid.unique.paths.II;

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
