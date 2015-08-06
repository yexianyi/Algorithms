package com.yxy.algorithms.max.matrix;

import com.yxy.algorithms.max.sum.MaxSumTest_DP;
/**
 * @author xianyi ye
 * @Date 8/5/2015
 * 
 * Question:
 * Given a 2D array, find the maximum sum subarray in it. 
 * For example, in the following 2D array, 
 * 1, 2, -1, -4 -20
 * -8,-3, 4, 2, 1
 * 3 , 8, 10, 1, 3
 * -4, -1, 1, 7, -6
 * the maximum sum subarray is showing as below and sum of this subarray is 29.
 * -3, 4, 2
 * 8, 10, 1
 * -1, 1, 7
 * 
 * Solution:
 * 
 * T(n) = O(n^3)
 * 
 * Reference:
 * http://www.geeksforgeeks.org/dynamic-programming-set-27-max-sum-rectangle-in-a-2d-matrix/
 *
 */
public class MaxMatrixTest {
	
	public static int maxMatrix(int[][] matrix){
		int maxSum = 0 ;
		
		for(int m=0; m<matrix.length; m++){
			int[] b = new int[matrix[0].length] ;
			
			for(int i=m ; i<matrix.length; i++){
				for(int j=0; j<matrix[0].length; j++){
					b[j] = b[j] + matrix[i][j] ;
				}
				int subSum = MaxSumTest_DP.maxSum(b) ;
				if(subSum > maxSum){
					maxSum = subSum ;
				}
			}
		}
		
		return maxSum ;
	}
	
	public static int maxMatrix2(int[][] matrix){
		int sum = 0;
		int[] b = new int[matrix[0].length] ;
		
		for(int i=0; i<matrix.length ; i++){
//			System.out.println("-----reset-------") ;
			for(int k = 0 ; k<matrix[0].length ; k++){
				b[k] = 0 ;
			}
			for(int j=i; j<matrix.length; j++){
				for(int k=0; k<matrix[0].length; k++){
					b[k] = b[k] + matrix[j][k] ;
					
//					System.out.print("b["+k+"]+=["+j+"]["+k+"] ") ;
				}
//				System.out.println("\n---------Compare----------") ;
				int max = MaxSumTest_DP.maxSum(b) ;
				if(max > sum){
					sum = max ;
				}
			}
		}
		
		return sum ;
	}
	

	public static void main(String[] args) {
		int[][] nums = {{5,  0, 0,   -3},
						{-1, 0, 7,    6},
						{-1, -1, -1, -1}} ;
		
		System.out.println(maxMatrix(nums));
		System.out.println(maxMatrix2(nums));
	}

}
