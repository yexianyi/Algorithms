package com.yxy.algorithms.array.find.peak.elem;
/**
 * 162. Find Peak Element My Submissions QuestionEditorial Solution
	Total Accepted: 66136 Total Submissions: 200452 Difficulty: Medium
	A peak element is an element that is greater than its neighbors.
	
	Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
	
	The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
	
	You may imagine that num[-1] = num[n] = -∞.
	
	For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
	
	click to show spoilers.
	
	Note:
	Your solution should be in logarithmic complexity.


 * @author xianyiye
 * @date 05/23/2016
 * Copy from:
 * https://leetcode.com/discuss/17793/find-the-maximum-by-binary-search-recursion-and-iteration
 */
public class Solution3 {
	
	/**
	 * Lets say you have a mid number at index x, nums[x] if (num[x+1] > nums[x]), 
	 * that means a peak element HAS to exist on the right half of that array, 
	 * because (since every number is unique) 
	 * 1. the numbers keep increasing on the right side, and the peak will be the last element. 
	 * 2. the numbers stop increasing and there is a 'dip', or there exists somewhere a number such that nums[y] < nums[y-1], which means number[x] is a peak element.

		This same logic can be applied to the left hand side (nums[x] < nums[x-1]).
		
		 commented Aug 13, 2015 by BrianLuong1337
		reply
		If you are familiar to Advanced Mathematics, it is easy for you to understand it. Let D stands for the derivative, we konw that D(-1)>0, D(n-1)<0. If D(mid-1) < 0, there must be a value x between [low, mid-1] for that from left to right of it , D>0 becomes D<0.
		
	 commented Nov 3, 2015 by liaolin93
	 * @param nums
	 * @return
	 */
	
	public static int findPeakElement(int[] nums) {
		
		return findPeakElement(nums, 0, nums.length-1) ;
    }
	
	private static Integer findPeakElement(int[] nums, int start, int end){
		if(start==end){
			return start ;
		}
		
		int mid1 = start+(end-start)/2 ;
		int mid2 = mid1+1 ;
		
		if(nums[mid1] > nums[mid2])
            return findPeakElement(nums, start, mid1);
        else
            return findPeakElement(nums, mid2, end);
		
	}
	
	

	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[]{1,2,3,1,5,6,7,8})) ;//2 or 7
		System.out.println(findPeakElement(new int[]{1,2,3,1,2,3,4,2,1})) ;//2
		System.out.println(findPeakElement(new int[]{1,2,3,4})) ;//3
		System.out.println(findPeakElement(new int[]{2,1,0,-1})) ;//0
		System.out.println(findPeakElement(new int[]{2,1,2})) ; //2
	}

}
