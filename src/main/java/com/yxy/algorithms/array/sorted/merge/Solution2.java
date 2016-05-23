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
package com.yxy.algorithms.array.sorted.merge;

/**
 * 	88. Merge Sorted Array My Submissions Question
	Total Accepted: 81040 Total Submissions: 274699 Difficulty: Easy
	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
	
	Note:
	You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * @author xianyiye
 * 2015/12/31
 */

public class Solution2 {
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if(nums2.length == 0){
			return ;
		}
		
		if(nums1.length==1 && nums1[0] ==0){
			nums1[0] = nums2[0] ;
			return ;
		}
		
		
       int p1 = 0 ;
       int p2 = 0 ;
       
       while(nums1[p1]<nums2[p2] && p1<m){
    	   p1++ ;
       }
       
       if(p1>0){
    	   p1-- ;
       }
       
       while(p1<m && p2<n){
    	   if(nums1[p1]>=nums2[p2]){
    		   for(int i=m; i>p1;i--){
    			   nums1[i] = nums1[i-1] ;
    		   }
    		   nums1[p1++] = nums2[p2++] ;
    		   m++ ;
    	   }else{
    		   p1++ ;
    	   }
    	   
       }
       
       while(p2<n){
    	   nums1[p1++] = nums2[p2++] ;
       }
      
       
    }

	public static void main(String[] args) {
//		int[] nums1 = {1,3,5,7,9,0,0,0,0,0,0,0,0,0} ;
//		int[] nums2 = {2,3,4,6,8,10,12,14,16} ;
		int[] nums1 = {2,0} ;
		int[] nums2 = {1} ;
		merge(nums1, 1, nums2, 1) ;
		
		for(int num : nums1){
			System.out.print(num+" ") ;
		}
	}

}
