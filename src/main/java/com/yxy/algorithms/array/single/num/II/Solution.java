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
package com.yxy.algorithms.array.single.num.II;

/**
 * 	137. Single Number II My Submissions Question
	Total Accepted: 72923 Total Submissions: 199354 Difficulty: Medium
	Given an array of integers, every element appears three times except for one. Find that single one.
	
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @author xianyiye
 * 2016/1/22
 */

public class Solution {

	public static int singleNumber(int[] nums) {
	    int[] digits = new int[32];
	    for(int i=0; i<nums.length; i++){
	        int mask = 1;
	        for(int j=31; j>=0; j--){
	            if((mask & nums[i])!=0)
	                digits[j] ++;
	            mask <<= 1;
	        }
	    }
	    int res = 0;
	    for(int i=0; i<32; i++){
	        if(digits[i]%3>0)
	            res += 1;
	        if(i==31)
	            continue;
	        res <<= 1;
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,1,1,2}));
		System.out.println(singleNumber(new int[]{1,3,4,1,3,4,5,5,1,3,4}));
		System.out.println(singleNumber(new int[]{1,1,1}));

	}

}
