package com.yxy.algorithms.matrix.search;
/**
 * 74. Search a 2D Matrix   My Submissions QuestionEditorial Solution
	Total Accepted: 78525 Total Submissions: 231836 Difficulty: Medium
	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
	
	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	For example,
	
	Consider the following matrix:
	
	[
	  [1,   3,  5,  7],
	  [10, 11, 16, 20],
	  [23, 30, 34, 50]
	]
	Given target = 3, return true.
 * @author xianyiye
 * @date 05/09/2016
 */
public class Solution {
	
	//1ms
	public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0 ;
        int col = 0 ;
        
        while(row<matrix.length && target>=matrix[row][col]){ //locate [row]
        	row++ ;
        }
        
        row-- ;
        
        while(row>=0 && row<matrix.length && col<matrix[0].length && target>=matrix[row][col]){ //locate [col]
        	col++ ;
        }
        
        if(col==0){
        	return false ;
        }else{
        	col-- ;
        }
        
		return matrix[row][col]==target ;
    }

	public static void main(String[] args) {
//		int[][] matrix = new int[][]{
//		                             {1,   3,  5,  7},
//		                             {10, 11, 16, 20},
//		                             {23, 30, 34, 50}
//									};
		
		int[][] matrix = new int[][]{
            {1}
			};
									
		System.out.println(searchMatrix(matrix,0));
	}

}
