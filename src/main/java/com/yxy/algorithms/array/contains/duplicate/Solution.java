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
package com.yxy.algorithms.array.contains.duplicate;

/**
 * 
 * 217. Contains Duplicate
	Given an array of integers, find if the array contains any duplicates.

	Your function should return true if any value appears at least twice in the array, 
	and it should return false if every element is distinct.
	
	Example 1:
	
	Input: [1,2,3,1]
	Output: true
	Example 2:
	
	Input: [1,2,3,4]
	Output: false
	Example 3:
	
	Input: [1,1,1,3,3,4,3,2,4,2]
	Output: true

 * @author Ye Xianyi
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
