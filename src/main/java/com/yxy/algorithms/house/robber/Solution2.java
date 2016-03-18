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
package com.yxy.algorithms.house.robber;

/**
 * 	198. House Robber My Submissions Question
	Total Accepted: 46542 Total Submissions: 144410 Difficulty: Easy
	You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
	
	Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * @author xianyiye
 * 2015/12/25
 * Reference:
 * http://www.programcreek.com/2014/03/leetcode-house-robber-java/
 */

public class Solution2 {

	public static int rob(int[] nums) {
		if(nums==null || nums.length==0){
			return 0 ;
		}
		
		int even = 0;
		int odd = 0;
	 
		for (int i = 0; i < nums.length; i++) {
			if (i % 2 == 0) {
				even += nums[i];
				even = even > odd ? even : odd;
			} else {
				odd += nums[i];
				odd = even > odd ? even : odd;
			}
		}
	 
		return even > odd ? even : odd;
	}

	public static void main(String[] args) {
//		System.out.println(rob(new int[]{1,2,5,4,5}));
		System.out.println(rob(new int[]{1,2}));
		System.out.println(rob(new int[]{2}));
//		System.out.println(rob(new int[]{2,1,1,2}));
		System.out.println(rob(new int[]{4,1,2,7,5,3,1,0,0}));

	}

}
