package com.yxy.algorithms.array.three.sum.closest;
/**
 * 16. 3Sum Closest My Submissions QuestionEditorial Solution
	Total Accepted: 81876 Total Submissions: 277713 Difficulty: Medium
	Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
	
	    For example, given array S = {-1 2 1 -4}, and target = 1.
	
	    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author xianyiye
 * @date 06/22/2016
 */
public class Solution {
	
	private int sum = 0 ;
	private int diff = Integer.MAX_VALUE ;
	
	//14ms
	public int threeSumClosest(int[] nums, int target) {
        
		travel(nums, target, 0, 0, 0) ;
		
		return sum ;
    }
	
	
	private void travel(int[] nums, int target, int start, int currSum, int currSize){
		if(currSize==3){
			int newDiff = Math.abs(target-currSum) ;
			if(newDiff<diff){
				diff = newDiff ;
				sum = currSum ;
			}
			
			return ;
		}
		
		if(start==nums.length || diff==0){
			return ;
		}
		
		for(int i=start; i<nums.length; i++){
			travel(nums, target, i+1, currSum+nums[i], currSize+1) ;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution() ;
		System.out.println(s.threeSumClosest(new int[]{0, 1, 2}, 3)) ;
	}

}
