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
package com.yxy.algorithms.range.sum.query.immutable;

/**
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

	Example:
	
	Given nums = [-2, 0, 3, -5, 2, -1]
	
	sumRange(0, 2) -> 1
	sumRange(2, 5) -> -1
	sumRange(0, 5) -> -3
	
	
	Note:
	
	1.You may assume that the array does not change.
	2.There are many calls to sumRange function.

 * 
 * @author Xianyi Ye
 * 2015/12/17
 */
public class NumArray2 {
	
	private int[] tempSums ;

    public NumArray2(int[] nums) {
    	if(nums==null){
    		tempSums = null ;
    	}
    	if(nums.length==0){
    		tempSums = new int[0] ;
    	}else{
    		tempSums = new int[nums.length] ;
    		tempSums[0] = nums[0] ;
    		for(int i=1; i<nums.length; i++){
    			tempSums[i] = nums[i] + tempSums[i-1] ;
    		}
    	}
    }

    public int sumRange(int i, int j) {
    	if(tempSums==null){
    		return 0 ;
    	}
    	
		if(i==0){
			return tempSums[j] ;
		}else{
			return tempSums[j] - tempSums[i-1] ;
		}
    }
    
    public static void main(String[] args){
    	int[] nums = {-2,0,3,-5,2,-1} ;
    	NumArray2 numArray = new NumArray2(nums);
    	 System.out.println(numArray.sumRange(0, 2));
    	 System.out.println(numArray.sumRange(2, 5));
    	 System.out.println(numArray.sumRange(0, 5));
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);