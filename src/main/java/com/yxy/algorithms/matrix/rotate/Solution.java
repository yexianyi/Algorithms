package com.yxy.algorithms.matrix.rotate;
/**
 * 48. Rotate Image   My Submissions QuestionEditorial Solution
	Total Accepted: 66811 Total Submissions: 192787 Difficulty: Medium
	You are given an n x n 2D matrix representing an image.
	
	Rotate the image by 90 degrees (clockwise).
	
	Follow up:
	Could you do this in-place?
 * @author xianyiye
 * @date 04/27/2016
 */
public class Solution {
	
	public static void rotate(int[][] matrix) {
		int row_size = matrix.length ;
		int col_size = matrix[0].length ;
		
		//turnover from left to right
		for(int row=0; row<row_size; row++){
			int col_start = 0 ;
			int col_end = col_size-1 ;
			while(col_start<col_end){
				int temp = matrix[row][col_start] ;
				matrix[row][col_start] = matrix[row][col_end] ;
				matrix[row][col_end] = temp ;
				col_start ++ ;
				col_end -- ;
			}
		}
		
		//turnover from bottom-right to top-left
		for(int row=0; row<col_size; row++){
			int inc = 1 ;
			for(int col=col_size-1-row-1; col>=0; col--, inc++){
				int temp = matrix[row][col] ;
				matrix[row][col] = matrix[row+inc][col+inc] ;
				matrix[row+inc][col+inc] = temp ;
			}
			
		}
    }
	

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}} ;
		rotate(matrix) ;
		
		for(int[] array : matrix){
			for(int num : array){
				System.out.print(num+" ");
			}
			System.out.println() ;
		}
	}

}
