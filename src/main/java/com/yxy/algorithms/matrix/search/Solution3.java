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
 * Copy from:
 * https://leetcode.com/discuss/15379/binary-search-on-an-ordered-matrix
 */

public class Solution3 {
	
	//1ms
	public static boolean searchMatrix(int[][] matrix, int target) {
		int row_num = matrix.length;
	    int col_num = matrix[0].length;

	    int begin = 0, end = row_num * col_num - 1;

	    while(begin <= end){
	        int mid = (begin + end) / 2;
	        int mid_value = matrix[mid/col_num][mid%col_num];

	        if( mid_value == target){
	            return true;

	        }else if(mid_value < target){
	            //Should move a bit further, otherwise dead loop.
	            begin = mid+1;
	        }else{
	            end = mid-1;
	        }
	    }

	    return false;
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
									
									
		System.out.println(searchMatrix(matrix,2));
	}

}
