package com.yxy.algorithms.majority.lement;

/**
 * 
 * 
	169. Majority Element
	 My Submissions 
	Question 
	
	Total Accepted: 80521 Total Submissions: 209437 Difficulty: Easy 
	
	Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
	
	You may assume that the array is non-empty and the majority element always exist in the array.

 * 
 * @author Administrator
 * 2015/12/19
 */
public class Solution {

	public static int majorityElement(int[] nums) {
		if(nums.length==1){
			return nums[0] ;
		}
		
		int pollNum = 0; 
		int candidate = -1 ;
		
		for(int num : nums){
			if(pollNum == 0){
				candidate = num ;
				pollNum++ ;
			}else{
				if(candidate == num){
					pollNum++ ;
				}else{
					pollNum-- ;
				}
			}
		}
		
		return candidate ;
	}
	
	
	public static void main(String[] args){
		int[] nums = {8,8,7,7,7} ;
		System.out.println(majorityElement(nums)) ;
	}

}
