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
package com.yxy.algorithms.factorial.trailing.zeroes;

/**
 * 	172. Factorial Trailing Zeroes My Submissions Question
	Total Accepted: 45545 Total Submissions: 147064 Difficulty: Easy
	Given an integer n, return the number of trailing zeroes in n!.
	
	Note: Your solution should be in logarithmic time complexity.
 * @author xianyiye
 * 2015/12/29
 */

public class Solution {
	
	public static int trailingZeroes(int n) {
		int count = 0;
		while(n>0){
			count += n/=5 ;
		}
		
		return count;
        
    }

	public static void main(String[] args) {
		System.out.println(trailingZeroes(0));
		System.out.println(trailingZeroes(1));
		System.out.println(trailingZeroes(2));
		System.out.println(trailingZeroes(3));
		System.out.println(trailingZeroes(14));
		System.out.println(trailingZeroes(24));

	}

}
