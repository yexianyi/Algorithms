package com.yxy.algorithms.array.contains.duplicate;

/**
 * 
	217. Contains Duplicate
	 My Submissions 
	Question 
	
	Total Accepted: 56112 Total Submissions: 143442 Difficulty: Easy 
	Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct. 

 * @author Administrator
 *	2015/12/19
 */

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public boolean containsDuplicate(int[] nums) {
		if(nums==null || nums.length==0){
			return false ;
		}
		
		Set set = new HashSet() ;
		for(int num : nums){
			if(set.contains(num)){
				return true ;
			}
			set.add(num) ;
		}
		
		return false;

	}


}
