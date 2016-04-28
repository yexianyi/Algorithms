package com.yxy.algorithms.matrix.search.II;

/**
 * 240. Search a 2D Matrix II   My Submissions QuestionEditorial Solution
	Total Accepted: 35175 Total Submissions: 102087 Difficulty: Medium
	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
	
	Integers in each row are sorted in ascending from left to right.
	Integers in each column are sorted in ascending from top to bottom.
	For example,
	
	Consider the following matrix:
	
	[
	  [1,   4,  7, 11, 15],
	  [2,   5,  8, 12, 19],
	  [3,   6,  9, 16, 22],
	  [10, 13, 14, 17, 24],
	  [18, 21, 23, 26, 30]
	]
	Given target = 5, return true.
	
	Given target = 20, return false.
 * @author xianyiye
 * @date 04/28/2016
 * Reference:
 * https://leetcode.com/discuss/48852/my-concise-o-m-n-java-solution
 */

public class Solution {
	
	
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
		 
		int row = 0 ;
		int col = matrix[0].length-1 ;
		
		while(col>=0 && row<=matrix.length-1){
			if(matrix[row][col]<target){
				row++ ;
			}else if(matrix[row][col]>target){
				col-- ;
			}else{
				return true ;
			}
			
		}
		
		return false ;
    }
	
	
	public static void main(String[] args) {
//		int[][] matrix = {
//		                  {1,   4,  7, 11, 15},
//		                  {2,   5,  8, 12, 19},
//		                  {3,   6,  9, 16, 22},
//		                  {10, 13, 14, 17, 24},
//		                  {18, 21, 23, 26, 30}
//		                  } ;
		
//		int[][] matrix = {
//                {-9,-8,-7},
//                {-5,-6,-2},
//                {-4,-3,-1}
//                } ;
		
		int[][] matrix = {
                {1,1}
                } ;
		
		System.out.println(new Solution().searchMatrix(matrix,-5));
	}

}
