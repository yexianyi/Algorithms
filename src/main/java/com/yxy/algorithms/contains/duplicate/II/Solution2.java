package com.yxy.algorithms.contains.duplicate.II;

/**
 * 	219. Contains Duplicate II My Submissions Question
	Total Accepted: 40044 Total Submissions: 141195 Difficulty: Easy
	Given an array of integers and an integer k, find out whether there 
	are two distinct indices i and j in the array such that nums[i] = nums[j] and 
	the difference between i and j is at most k.
	
 * @author xianyiye
 * 2016/1/6
 */

public class Solution2 {
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length && j<=i+k; j++){
				if(nums[j]==nums[i]){
					return true ;
				}
			}
		}
		
		return false;
    }

	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[]{1}, 1));
	}

}
