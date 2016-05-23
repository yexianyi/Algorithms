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
 */
public class Solution {
	
	public static int findPeakElement(int[] nums) {
		if(nums.length==1){
			return 0 ;
		}else if(nums.length==2){
			return nums[1]>nums[0]? 1 : 0 ;
		}
		
        int trend = nums[1]-nums[0]>0 ? 1 : -1;
        
		for(int i=1; i<nums.length-1; i++){
			int newTrend = nums[i+1]-nums[i]>0 ? 1 : -1 ; 
			if( trend != newTrend){
				return newTrend==1 ? i+1: i ; 
			}
		}
		
		return trend == 1 ? nums.length-1 : 0 ;
    }

	public static void main(String[] args) {
		System.out.println(findPeakElement(new int[]{1,2,3,1,2,3,4,2,1})) ;//2
		System.out.println(findPeakElement(new int[]{1,2,3,4})) ;//3
		System.out.println(findPeakElement(new int[]{2,1,0,-1})) ;//0
		System.out.println(findPeakElement(new int[]{2,1,2})) ; //2
	}

}
