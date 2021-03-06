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
package com.yxy.algorithms.climbing.stairs;

/**
 *  70. Climbing Stairs My Submissions Question
	Total Accepted: 84787 Total Submissions: 238451 Difficulty: Easy
	You are climbing a stair case. It takes n steps to reach to the top.
	
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author xianyiye
 * 2015/12/22
 */

public class Solution {
	
	public static int climbStairs(int n) {
		if(n==1){
			return 1 ;
		}
		else if(n==2){
			return 2 ;
		}
		
		return climbStairs(n-1) + climbStairs(n-2) ;
	}
	

	public static void main(String[] args) {
		System.out.println(climbStairs(4));
	}

}
