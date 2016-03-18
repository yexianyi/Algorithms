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
package com.yxy.algorithms.array.single.num.III;

import java.util.Arrays;

/**
 * 	260. Single Number III My Submissions Question
	Total Accepted: 22236 Total Submissions: 53008 Difficulty: Medium
	Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
	
	For example:
	
	Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
	
	Note:
	The order of the result is not important. So in the above example, [5, 3] is also correct.
	Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * @author xianyiye
 * Reference:
 */

public class Solution {
	
	public static int[] singleNumber(int[] nums) {
		Arrays.sort(nums) ;
		int[] result = new int[2] ;
		for(int i=0,j=0; j<2 && i<nums.length; i+=2){
			if(i==nums.length-1){
				result[1] = nums[nums.length-1] ;
			}
			else if(i==nums.length-2){
				result[0] = nums[nums.length-1] ;
				result[1] = nums[nums.length-2] ;
			}
			else if(nums[i]!=nums[i+1]){
				result[j++] = nums[i] ;
				for(int k=i+1 ; k<=i+2; k++){
					if(nums[k]!=nums[i]){
						i = k-2 ;
						break ;
					}
				}
			}
		}
        
		return result ;
    }

	public static void main(String[] args) {
//		int[] results = singleNumber(new int[]{1,2,3,1,4,2}) ;
//		int[] results = singleNumber(new int[]{1,2,3,1,4,2,5,5,6,6}) ;
		int[] results = singleNumber(new int[]{0,1,1,2}) ;
		for(int result : results){
			System.out.print(result+" ");
		}

	}

}
