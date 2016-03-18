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
package com.yxy.algorithms.integer.power.of.three;
/**
 * 326. Power of Three My Submissions Question
	Total Accepted: 9973 Total Submissions: 28215 Difficulty: Easy
	Given an integer, write a function to determine if it is a power of three.
	
	Follow up:
	Could you do it without using any loop / recursion?
 * @author xianyiye
 * 2016/1/19
 */

public class Solution2 {
	public boolean isPowerOfThree(int n) {
		return (n == 1 || n == 3 || n == 9 || n == 27 || n == 81 || n == 243 
				|| n == 729 || n == 2187 || n == 6561 || n == 19683 || n == 59049
				|| n == 177147 || n == 531441 || n == 1594323 || n == 4782969 
				|| n == 14348907 || n == 43046721 || n == 129140163 || n == 387420489 
				|| n == 1162261467);
	}
	
	public static void main(String[] args) {
		
	}

}
