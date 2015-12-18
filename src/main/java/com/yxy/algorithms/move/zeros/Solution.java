package com.yxy.algorithms.move.zeros;

/**
 * 	Move Zeroes My Submissions Question
	Total Accepted: 38897 Total Submissions: 91826 Difficulty: Easy
	Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
	
	For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
	
	Note:
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.
 * @author xianyiye
 * 2015/12/18
 */

public class Solution {
	
	public void moveZeroes(int[] nums) {
		if(nums == null || nums.length<2){
			return ;
		}
		
		int p1 = 0 ;
		int p2 = p1 ;
		
		while(p2!=nums.length){
			while(p1<nums.length && nums[p1]!=0){//find 1st ZERO num index
				p1++ ;
			}
			
			if(p1==nums.length){
				return ;
			}
			
			p2 = p1+1 ;
			while(p2<nums.length && nums[p2]==0){//find 1st Non-ZERO num index
				p2++ ;
			}
			
			if(p2==nums.length){
				return ;
			}
			
			nums[p1] = nums[p2] ;
			nums[p2] = 0 ;
			p1++ ;
			p2++ ;
		}
		
	}

	public static void main(String[] args) {
//		int[] nums = {0,1,0,3,12} ;
//		int[] nums = {0,0} ;
		int[] nums = {4,2,4,0,0,3,0,5,1,0} ;
		
		Solution s = new Solution() ;
		s.moveZeroes(nums) ;

	}

}
