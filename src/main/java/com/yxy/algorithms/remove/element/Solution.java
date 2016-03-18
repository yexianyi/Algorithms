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
package com.yxy.algorithms.remove.element;

/**
 * 	27. Remove Element My Submissions Question
	Total Accepted: 91574 Total Submissions: 281965 Difficulty: Easy
	Given an array and a value, remove all instances of that value in place and return the new length.
	
	The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @author xianyiye
 * 2015/12/23
 */

public class Solution {
	
	public static int removeElement(int[] nums, int val) {
		if(nums==null || nums.length==0){
			return 0 ;
		}
		
		int p1 = 0 ;
		int p2 = nums.length-1 ;
		
		while(p1<=p2){
			if(nums[p1] == val){
				while(p1!=p2 && nums[p2]==val){
					p2-- ;
				}
				
				if(p1==p2){
					break ;
				}
				
				nums[p1] = nums[p1] ^ nums[p2] ;
				nums[p2] = nums[p2] ^ nums[p1] ;
				nums[p1] = nums[p1] ^ nums[p2] ;
				p2-- ;
			}
			p1++ ;
		}
		
		int count=0 ;
		for(int i=0; i<nums.length; i++){
			if(nums[i]!=val){
				count++ ;
			}else{
				break ;
			}
		}
		
		
		int[] array = new int[count] ;
		for(int i=0; i<array.length; i++){
			array[i] = nums[i] ;
		}
		nums = array ;
        return p1 ;
    }

	public static void main(String[] args) {
//		removeElement(new int[]{2,4,3,2,5,2,1},2) ;
//		removeElement(new int[]{2,3,3},3) ;
//		removeElement(new int[]{3,3},3) ;
//		removeElement(new int[]{2},3) ;
		removeElement(new int[]{4,5},4) ;

	}

}
