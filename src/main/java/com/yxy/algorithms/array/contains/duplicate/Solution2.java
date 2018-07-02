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

import java.util.Arrays;
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

 * @author Administrator
 * @Date 2018/07/02
 */

public class Solution2 {
	/**
	 * Complexity Analysis
		Time complexity : O(nlogn). 
						  Sorting is O(nlogn) and the sweeping is O(n). 
						  The entire algorithm is dominated by the sorting step, which is O(nlogn).
		
		Space complexity : O(1). Space depends on the sorting implementation which, 
						   usually, costs O(1) auxiliary space if heapsort is used.
	 * @param nums
	 * @return
	 */
	
	public boolean containsDuplicate(int[] nums) {
	    Arrays.sort(nums);
	    for (int i = 0; i < nums.length - 1; ++i) {
	        if (nums[i] == nums[i + 1]) return true;
	    }
	    return false;
	}


}
