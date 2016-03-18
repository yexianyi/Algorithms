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

public class Solution3 {
	/*
	 * If N is a power of 3:
		It follows that 3^X == N
		It follows that log (3^X) == log N
		It follows that X log 3 == log N
		It follows that X == (log N) / (log 3)
		For the basis to hold, X must be an integer.
		However, due to precision issues that arise from the fact that log 3 cannot be precisely represented on a binary computer; 
		X is considered to be an integer if it's decimal component falls within a guard range of +/-0.00000000000001.
	 */
	public boolean isPowerOfThree(int n) {
		  double a = Math.log(n) / Math.log(3);
		  return Math.abs(a - Math.rint(a)) <= 0.00000000000001;
	}
	
	public static void main(String[] args) {
		
	}

}
