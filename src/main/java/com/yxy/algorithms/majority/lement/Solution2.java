package com.yxy.algorithms.majority.lement;

/**
 * 
 * 
	169. Majority Element
	 My Submissions 
	Question 
	
	Total Accepted: 80521 Total Submissions: 209437 Difficulty: Easy 
	
	Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
	
	You may assume that the array is non-empty and the majority element always exist in the array.

 * 
 * @author Administrator
 * 2015/12/19
 */

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

	public static int majorityElement(int[] nums) {
		if(nums.length==1){
			return nums[0] ;
		}
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>() ;
		for(int num : nums){
			if(map.containsKey(num)){
				int count = map.get(num) ;
				if(count+1 > nums.length/2){
					return num ;
				}
				map.put(num, count+1) ;
			}else{
				map.put(num, 1) ;
			}
		}
		
		
		return -1 ;
	}
	
	
	public static void main(String[] args){
		int[] nums = {8,8,7,7,7} ;
		System.out.println(majorityElement(nums)) ;
	}

}
