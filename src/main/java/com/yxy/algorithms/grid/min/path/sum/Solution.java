package com.yxy.algorithms.grid.min.path.sum;
/**
 * 64. Minimum Path Sum   My Submissions QuestionEditorial Solution
	Total Accepted: 69073 Total Submissions: 198693 Difficulty: Medium
	Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	
	Note: You can only move either down or right at any point in time.
 * @author xianyiye
 * @date 04/20/2016
 */
public class Solution {
	private int min = -1 ;
	
	//Execution timeout!!
	public int minPathSum(int[][] grid) {
		travel(grid, 0, 0, 0) ;
		
		return min ;
    }
	
	//forward direction
	private void travel(int[][] grid, int row, int col, int sum){
		sum += grid[row][col] ;
		if(sum>min && min!=-1){
			return ;
		}
		
		if(row==grid.length-1 && col==grid[0].length-1){
			if(sum<min || min==-1){
				min = sum ;
			}
			
			return ;
		}
		
		if(row<grid.length-1){
			travel(grid, row+1, col, sum) ;
		}
		
		if(col<grid[0].length-1){
			travel(grid, row, col+1, sum) ;
		}
	}

	public static void main(String[] args) {
		int[][] grid = new int[3][3] ;
		int counter = 1 ;
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				grid[i][j] = counter++ ;
			}
		}
		int[][] grid2 = {{4,8,2,9,5,8,5,0,8,4,7,4,0,4,2},{4,9,5,4,9,3,4,8,6,3,7,3,7,9,9},{4,4,7,6,5,4,6,2,4,6,6,2,0,7,8},{4,3,7,9,0,6,5,4,6,1,0,4,6,7,5},{5,3,9,4,1,6,1,7,9,5,5,7,9,5,6},{8,9,0,5,1,0,4,6,6,2,7,6,6,3,5},{2,0,0,3,6,1,2,7,0,1,5,5,0,4,2},{7,2,4,7,0,7,9,6,3,7,8,2,4,7,7},{1,1,7,2,4,5,3,6,5,6,9,0,3,2,4},{8,9,9,2,8,1,9,7,9,4,4,7,6,0,6},{3,2,7,2,6,2,9,1,0,4,7,2,4,1,4},{1,1,5,2,3,3,3,4,0,2,8,6,1,6,9},{8,9,1,5,3,7,9,2,8,2,7,8,6,3,1},{2,4,2,7,6,7,0,1,1,2,5,1,8,7,7},{7,7,8,0,2,1,9,4,5,0,8,2,0,4,6},{1,6,2,5,3,1,2,3,2,5,7,8,6,5,7}};
				
		Solution s = new Solution() ;
		System.out.println(s.minPathSum(grid2)) ;

	}

}
