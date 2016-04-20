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
public class Solution4 {
	
	public int minPathSum(int[][] grid) {
	    int height=grid.length;
	    int width=grid[0].length;

	    int[][] dp=new int[height][width];

	    //first column
	    dp[0][0]=grid[0][0];

	    for(int i=1;i<height;i++){
	        dp[i][0]= dp[i-1][0]+ grid[i][0];
	    }

	    //top row
	    for(int i=1;i<width;i++){
	        dp[0][i]= dp[0][i-1]+ grid[0][i];
	    }

	    for(int i=1;i<height;i++){
	        for(int j=1;j<width;j++){    
	            dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
	        }
	    }
	    return dp[height-1][width-1];
	}

	public static void main(String[] args) {
		int[][] grid = new int[3][3] ;
		int counter = 1 ;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				grid[i][j] = counter++ ;
			}
		}
				
		Solution4 s = new Solution4() ;
		System.out.println(s.minPathSum(grid)) ;

	}

}
