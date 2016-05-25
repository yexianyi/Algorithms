package com.yxy.algorithms.array.rotated.sorted.II;

/**
 * 81. Search in Rotated Sorted Array II My Submissions QuestionEditorial Solution
	Total Accepted: 63429 Total Submissions: 198067 Difficulty: Medium
	Follow up for "Search in Rotated Sorted Array":
	What if duplicates are allowed?
	
	Would this affect the run-time complexity? How and why?
	
	Write a function to determine if a given target is in the array.

 * @author xianyiye
 * @date 05/24/2016
 */

public class Solution {
	
	public static boolean search(int[] nums, int target) {
        
		int head = nums[0] ;
		int end = nums[nums.length-1] ;
		
		if(target>=head){
			for(int i=0; i<nums.length; i++){
				if(nums[i]==target){
					return true ;
				}
			}
		}
		
		if(target<=end){
			for(int i=nums.length-1; i>=0; i--){
				if(nums[i]==target){
					return true ;
				}
			}
		}
		
		return false ;
    }

	public static void main(String[] args) {
		System.out.println(search(new int[]{1}, 0));

	}

}
