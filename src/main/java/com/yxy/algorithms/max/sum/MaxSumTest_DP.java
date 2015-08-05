package com.yxy.algorithms.max.sum;

public class MaxSumTest_DP {
/**
 * @author xianyi ye
 * @Date 8/1/2015
 * 
 * Question:
 * The maximum subarray problem is the task of finding the contiguous subarray 
 * within a one-dimensional array of numbers (containing at least one positive number) 
 * which has the largest sum. 
 * For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; 
 * the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.
 * 
 * Solution:
 * Following program is based on Dynamic planning.
 * Suppose that an integer array is a{A,B,C,D,E,F}, and b = max sum from i to j.
 * then b[j] = max{b[j-1]+a[j], a[j]}
 *
 * 
 * T(n) = O(n)
 *
 */
	public static int maxSum(int[] a){
		
		int sum = 0 ;
		int b = 0;
		for(int i=0; i<a.length; i++){
			if(b>0){
				b = b + a[i]  ;
			}else{
				b = a[i] ;
			}
			
			if(b>sum){
				sum = b ;
			}
			
		}
		
		return sum;
		
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,11,-4,13,-5,-2} ;
		System.out.println(maxSum(nums)) ;
	}

}
