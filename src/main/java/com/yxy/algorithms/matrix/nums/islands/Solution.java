package com.yxy.algorithms.matrix.nums.islands;
/**
 * 200. Number of Islands  QuestionEditorial Solution  My Submissions
	Total Accepted: 51714
	Total Submissions: 179649
	Difficulty: Medium
	Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
	
	Example 1:
	
	11110
	11010
	11000
	00000
	Answer: 1
	
	Example 2:
	
	11000
	11000
	00100
	00011
	Answer: 3
	
 * @author xianyiye
 * @date 07/11/2016
 * 
 * Reference:
 * http://blog.csdn.net/ljiabin/article/details/44975717
 */
public class Solution {
	
	 public static int numIslands(char[][] grid) {
		 if(grid==null || grid.length==0){
			 return 0 ;
		 }
		 
		 int rowSize = grid.length ;
		 int colSize = grid[0].length ;
		 
		 int ans = 0;
		 
		 for(int row=0; row<rowSize; row++){
			 for(int col=0; col<colSize; col++){
				 if(grid[row][col]!='1'){
					 continue ;
				 }
				 
				 //else
				 ans++ ;
				 checkSurround(grid, row, col) ;
			 }
		 }
		 
		 
		 return ans ;
	 }
	 
	 
	 

	private static void checkSurround(char[][] grid, int row, int col) {
		if(row<0 || row>grid.length-1 || col<0 || col>grid[0].length-1){
			return ;
		}
		
		if(grid[row][col]=='1'){
			grid[row][col] = '2' ;
			checkSurround(grid, row-1, col) ;//up
			checkSurround(grid, row+1, col) ;//down
			checkSurround(grid, row, col-1) ;//left
			checkSurround(grid, row, col+1) ;//right
		}
	}




	public static void main(String[] args) {
		char[][] map= {{'1','1','1','1','0'},
					   {'1','1','0','1','0'},
					   {'1','1','0','0','0'},
					   {'0','0','0','0','0'}} ;
		
		System.out.println(numIslands(map)) ;
		
	}

}
