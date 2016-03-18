/**
 * Copyright (c) 2016, Xianyi Ye
 *
 * This project includes software developed by Xianyi Ye
 * yexianyi@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.yxy.algorithms.max.sum;
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
 * Following program is based on Divide-and-conquer.
 * Suppose that an integer array is {A,B,C,D,E,F}.
 * We can divide the arry into 2 parts, {A,B,C} and {D,E,F}.
 * The max sum value only can be obtained by following 3 cases:
 * 1. Max sum of {A,B,C}
 * 2. Max sum of {D,E,F}
 * 3. Max sum of {..,C,D,..}
 * 
 * For first 2 cases, the max sum can be got easily. But for 3), two loop statements
 * must be invoked from reverse direction. One is calling from CENTER to LEFT, another 
 * is calling from CENTER+1 to RIGHT. Only in this way, both C and D can be included 
 * in the array {..,C,D,..}.
 * 
 * Once we get above 3 max sum values, the max sum eventually can be get through
 * compare these 3 values.
 * 
 * T(n) = O(nlogn)
 *
 */
public class MaxSumTest {
	
	public static int maxSum(int[] nums, int leftPos, int rightPos){
		int sum =0 ;
		if(leftPos==rightPos){
			sum = nums[leftPos] ;
		}else{
			int centerPos = (leftPos+rightPos)/2 ;
			int leftMaxSum = maxSum(nums, leftPos, centerPos) ;
			int rightMaxSum = maxSum(nums, centerPos+1, rightPos) ;
			
			int s1 = 0 ;
			int leftSum = 0 ;
			for(int i=centerPos; i>=leftPos; i--){
				leftSum += nums[i] ;
				if(leftSum>s1){
					s1 = leftSum ;
				}
			}
			
			int s2 = 0 ;
			int rightSum = 0 ;
			for(int j=centerPos+1 ; j<=rightPos; j++){
				rightSum += nums[j] ;
				if(rightSum>s2){
					s2 = rightSum ;
				}
			}
			
			sum = s1+s2 ;
			if(sum<leftMaxSum){
				sum = leftMaxSum ;
			}
			if(sum<rightMaxSum){
				sum = rightMaxSum ;
			}
		}
		
		return sum ;
	}
	

	public static void main(String[] args) {
//		int[] nums = {1, -2, 3, 10, -4, 7, 2, -5} ;
		int[] nums = {-2,11,-4,13,-5,-2} ;
		System.out.println(maxSum(nums,0,nums.length-1)) ;

	}

}
