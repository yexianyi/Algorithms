package com.yxy.algorithms.array.search.range;
/**
 * 	34. Search for a Range My Submissions QuestionEditorial Solution
	Total Accepted: 87836 Total Submissions: 297731 Difficulty: Medium
	Given a sorted array of integers, find the starting and ending position of a given target value.
	
	Your algorithm's runtime complexity must be in the order of O(log n).
	
	If the target is not found in the array, return [-1, -1].
	
	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].
 * @author xianyiye
 * @date 06/23/2016
 * 
 */
public class Solution {
	
	public static int[] searchRange(int[] nums, int target) {
        
		if(target<nums[0] || target>nums[nums.length-1]){
			return new int[]{-1,-1} ;	
		}
		
		int pos = binarySearch(nums, target, 0, nums.length-1) ;
		if(pos!=-1){
			int left = pos ;
			int right = pos ;
			
			while(--left>=0 && nums[left]==target) ;
			while(++right<nums.length && nums[right]==target) ;
			
			return new int[]{left+1, right-1} ;
			
		}
		
		return new int[]{-1,-1} ;
		
    }
	
	
	private static int binarySearch(int[] nums, int target, int start, int end){
		if(start>=end){
			if(target == nums[start]){
				return start ;
			}else{
				return -1 ;
			}
		}
		
		int mid = start+(end-start)/2 ;
		if(target<nums[mid]){
			return binarySearch(nums, target, start, mid) ;
		}else if(target>nums[mid]){
			return binarySearch(nums, target, mid+1, end) ;
		}else{
			return mid ;
		}
		
	}	

	public static void main(String[] args) {
		int[] range = searchRange(new int[]{5, 7, 7, 8, 8, 10},8) ;
		System.out.println(range[0]+","+range[1]);

	}

}
