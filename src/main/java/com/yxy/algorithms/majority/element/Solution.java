/**
 * Copyright (c) 2016, Xianyi Ye
 *
 * This project includes software developed by Xianyi Ye
 * yexianyi@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.yxy.algorithms.majority.element;

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
public class Solution {

	public static int majorityElement(int[] nums) {
		if(nums.length==1){
			return nums[0] ;
		}
		
		int pollNum = 0; 
		int candidate = -1 ;
		
		for(int num : nums){
			if(pollNum == 0){
				candidate = num ;
				pollNum++ ;
			}else{
				if(candidate == num){
					pollNum++ ;
				}else{
					pollNum-- ;
				}
			}
		}
		
		return candidate ;
	}
	
	
	public static void main(String[] args){
		int[] nums = {8,8,7,7,7} ;
		System.out.println(majorityElement(nums)) ;
	}

}
