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
package com.yxy.algorithms.pascal.triangle;

/**
 * 	118. Pascal's Triangle My Submissions Question
	Total Accepted: 67941 Total Submissions: 214490 Difficulty: Easy
	Given numRows, generate the first numRows of Pascal's triangle.
	
	For example, given numRows = 5,
	Return
	
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
 * @author xianyiye
 * 2015/12/29
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	 public static List<List<Integer>> generate(int numRows) {
		 if(numRows<1){
			 return new ArrayList<List<Integer>>() ;
		 }
		 
		 List<List<Integer>> list = new ArrayList<List<Integer>>() ;
		 List<Integer> subList = new ArrayList<Integer>() ;
		 subList.add(1) ;
		 list.add(subList) ;
		 
		 for(int i=2; i<=numRows; i++){
			 List<Integer> preList = list.get(i-2) ;
			 subList = new ArrayList<Integer>() ;
			 subList.add(1) ;
			 
			 for(int j=0; j<preList.size()/2; j++){
				 int num = preList.get(j)+preList.get(j+1) ;
				 subList.add(num) ;
			 }
			 
			 if(i%2==0){// even
				 for(int j=i/2-1; j>=0; j--){
					 subList.add(subList.get(j));
				 }
				
			 }else{// odd
				 for(int j=i/2-1; j>=0; j--){
					 subList.add(subList.get(j));
				 }
			 }
			 
			 list.add(subList) ;
			 
		 }
	        
		 return list ;
	 }

	public static void main(String[] args) {
		for(List<Integer> list : generate(6)){
			for(Integer num : list){
				System.out.print(num+" ") ;
			}
			System.out.println() ;
		}
		

	}

}
