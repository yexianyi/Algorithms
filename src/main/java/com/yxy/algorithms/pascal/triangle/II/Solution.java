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
package com.yxy.algorithms.pascal.triangle.II;

/**
 * 	119. Pascal's Triangle II My Submissions Question
	Total Accepted: 61366 Total Submissions: 199473 Difficulty: Easy
	Given an index k, return the kth row of the Pascal's triangle.
	
	For example, given k = 3,
	Return [1,3,3,1].
 * @author xianyiye
 * 2015/12/29
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	 public static List<Integer> getRow(int rowIndex) {
		 if(rowIndex==0){
			 List<Integer> list = new ArrayList<Integer>() ;
			 list.add(1) ;
			 return list;
		 }
		 
		 int rowNum = rowIndex+1 ;
		 int[] array = new int[rowNum] ;
		 array[0] = 1;
		 array[rowIndex-1] = 1 ;
		 
		 for(int i=2; i<=rowNum; i++){
			 if(i%2==0){// even
				 for(int j=i/2-1; j>0; j--){
					array[j] = array[j-1] + array[j] ;
				 }
				 
				 for(int j=i/2, k=i/2-1; j<=i&&k>=0; j++,k--){
					 array[j] = array[k] ;
				 }
			 }else{// odd
				 for(int j=i/2; j>0; j--){
						array[j] = array[j-1] + array[j] ;
					 }
				 
				 for(int j=i/2+1, k=i/2-1; j<=i&&k>=0; j++,k--){
					 array[j] = array[k] ;
				 }
			 }
		 }
		 
		 
		 List<Integer> list = new ArrayList<Integer>() ;
		 for(int num : array){
			 list.add(num) ;
		 }
	        
		 return list ;
	 }

	public static void main(String[] args) {
		for(int num : getRow(6)){
			System.out.print(num+" ") ;
		}
		
	}

}
