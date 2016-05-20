package com.yxy.algorithms.array.increasing.triplet.subsequence;
/**
 * 334. Increasing Triplet Subsequence My Submissions QuestionEditorial Solution
	Total Accepted: 13747 Total Submissions: 40966 Difficulty: Medium
	Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
	
	Formally the function should:
	Return true if there exists i, j, k 
	such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
	Your algorithm should run in O(n) time complexity and O(1) space complexity.
	
	Examples:
	Given [1, 2, 3, 4, 5],
	return true.
	
	Given [5, 4, 3, 2, 1],
	return false.
 * @author xianyiye
 * @date 05/20/2016
 */
public class Solution {
	
	public static boolean increasingTriplet(int[] nums) {
        
        for(int i=0; i<nums.length-2; i++){
        	if(find(nums,i,1)){
        		return true ;
        	}
        }
		
		return false ;
    }

	private static boolean find(int[] nums, int start, int currCount) {
		for(int i=start; i<nums.length; i++){
			if(nums[i]>nums[start]){
				if(currCount+1==3){
					return true ;
				}
				
				if(find(nums,i,currCount+1)){
					return true ;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
//		System.out.println(increasingTriplet(new int[]{1,2,3,4,5}));
//		System.out.println(increasingTriplet(new int[]{5,4,3,2,1}));
//		System.out.println(increasingTriplet(new int[]{5,1,5,5,2,5,4}));
		System.out.println(increasingTriplet(new int[]{0,4,2,1,0,-1,-3}));
	}

}
