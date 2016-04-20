package com.yxy.algorithms.grid.min.path.sum;
/**
 * 64. Minimum Path Sum   My Submissions QuestionEditorial Solution
	Total Accepted: 69073 Total Submissions: 198693 Difficulty: Medium
	Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	
	Note: You can only move either down or right at any point in time.
 * @author xianyiye
 * @date 04/20/2016
 * Copy from:
 * https://leetcode.com/discuss/17111/my-java-solution-using-dp-and-no-extra-space
 */
public class Solution3 {
	
	public int minPathSum(int[][] grid) {
	    int[][] memo = new int[grid.length][grid[0].length];
	    return minPathSumHelper(grid, 0, 0, memo);
	}

	public int minPathSumHelper(int[][] grid, int row, int col, int[][] memo) {
	    if(row == grid.length-1 && col == grid[0].length-1) 
	    	return grid[row][col];
	    
	    if(memo[row][col] != 0) 
	    	return memo[row][col];

	    int rowInc = Integer.MAX_VALUE, colInc = Integer.MAX_VALUE;
	    
	    if(row < grid.length-1) 
	    	rowInc = minPathSumHelper(grid, row+1, col, memo);
	    if(col < grid[0].length-1) 
	    	colInc = minPathSumHelper(grid, row, col+1, memo);
	    
	    memo[row][col] = Math.min(rowInc, colInc) + grid[row][col];
	    
	    return memo[row][col];
	}

	public static void main(String[] args) {
		int[][] grid = new int[3][3] ;
		int counter = 1 ;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				grid[i][j] = counter++ ;
			}
		}
				
		Solution3 s = new Solution3() ;
		System.out.println(s.minPathSum(grid)) ;

	}

}
