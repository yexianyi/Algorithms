package com.yxy.algorithms.spiral.matrix.II;
/**
 * 59. Spiral Matrix II   My Submissions QuestionEditorial Solution
	Total Accepted: 51563 Total Submissions: 147872 Difficulty: Medium
	Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
	
	For example,
	Given n = 3,
	
	You should return the following matrix:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]
 * @author xianyiye
 * @Date 04/20/2016
 */
public class Solution {
	
	public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n] ;
        if(n==0){
        	return matrix ;
        }
        
        int counter = 1 ;
        int i = 0 ; 
        int j = 0 ;
        
		while(counter!=n*n){
			//right
			for(;j<matrix.length-1 && matrix[i][j+1]==0; j++){
				matrix[i][j] = counter++ ;
			}
			
			//down
			for(;i<matrix.length-1 && matrix[i+1][j]==0; i++){
				matrix[i][j] = counter++ ;
			}
			
			//left
			for(;j>=1 && matrix[i][j-1]==0; j--){ //i>=1 means i>=0 && i-1>=0
				matrix[i][j] = counter++ ;
			}
			
			//up
			for(;i>=1 && matrix[i-1][j]==0; i--){
				matrix[i][j] = counter++ ;
			}
			
		}
		
		if(counter==n*n){
			matrix[i][j] = counter ;
		}
		
		return matrix ;
    }
	
	public static void print(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix.length; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println() ;
		}
	}

	public static void main(String[] args) {
		int[][] matrix = generateMatrix(0) ;
		print(matrix) ;

	}

}
