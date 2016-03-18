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
package com.yxy.algorithms.array.contains.duplicate.II;

import java.util.HashMap;
import java.util.Map;

/**
 * 	219. Contains Duplicate II My Submissions Question
	Total Accepted: 40044 Total Submissions: 141195 Difficulty: Easy
	Given an array of integers and an integer k, find out whether there 
	are two distinct indices i and j in the array such that nums[i] = nums[j] and 
	the difference between i and j is at most k.
	
 * @author xianyiye
 * 2016/1/6
 */

public class Solution3 {
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k)
				return true;
			map.put(nums[i], i);
		}
		return false;
    }

	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[]{1}, 1));
	}

}
