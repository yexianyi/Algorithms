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
package com.yxy.algorithms.array.summary.ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * 	228. Summary Ranges My Submissions Question
	Total Accepted: 33331 Total Submissions: 149068 Difficulty: Easy
	Given a sorted integer array without duplicates, return the summary of its ranges.
	
	For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * @author xianyiye
 * 2016/1/14
 */
public class Solution {
	
	public static List<String> summaryRanges(int[] nums) {
		List<String> summary = new ArrayList<String>() ;
		
		int start = 0;
		for(int i=start; i<nums.length; i++){
			if(i+1==nums.length){
				summary.add(start==i ? ""+nums[start] : nums[start]+"->"+nums[i]) ;
				break ;
			}
			
			if(nums[i]+1!=nums[i+1]){
				summary.add(start==i ? ""+nums[start] : nums[start]+"->"+nums[i]) ;
				start = i+1 ;
			}
			
			
		}
		
		return summary ;
    }

	public static void main(String[] args) {
//		int[] array = {1,2,3,4,6,7,8} ;
//		int[] array = {1,2,3,4,6,7,9} ;
//		int[] array = {1,2} ;
		int[] array = {1,3} ;
		for(String range : summaryRanges(array)){
			System.out.println(range);
		}

	}

}
