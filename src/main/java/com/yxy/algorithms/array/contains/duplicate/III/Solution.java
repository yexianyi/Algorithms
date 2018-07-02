package com.yxy.algorithms.array.contains.duplicate.III;

/**
 * 220. Contains Duplicate III
 * 
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the absolute difference between nums[i] and nums[j] is at most t 
 * and the absolute difference between i and j is at most k.

	Example 1:
	
	Input: nums = [1,2,3,1], k = 3, t = 0
	Output: true
	Example 2:
	
	Input: nums = [1,0,1,1], k = 1, t = 2
	Output: true
	Example 3:
	
	Input: nums = [1,5,9,1,5,9], k = 2, t = 3
	Output: false
 * @author Ye Xianyi
 * @Date 2017/07/02
 */

public class Solution {
	
	// Time Limit Exceeded
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
     
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<=i+k; j++) {
				if(j==nums.length) {
					break ;
				}
				long diff = (long)nums[i] - (long)nums[j] ;
				if(Math.abs(diff)<=t) {
					return true ;
				}
				
			}
		}
		
		return false ;
    }

	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate(new int[] {-1,2147483647}, 1, 2147483647));
		System.out.println(containsNearbyAlmostDuplicate(new int[] {1,2,3,1}, 3, 0));
		System.out.println(containsNearbyAlmostDuplicate(new int[] {1,5,9,1,5,9}, 2, 3));
		System.out.println(containsNearbyAlmostDuplicate(new int[] {1,0,1,1}, 1, 2));

	}

}
