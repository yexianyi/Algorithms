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
package com.yxy.algorithms.hamming.weight;

/**
 * 	191. Number of 1 Bits My Submissions Question
	Total Accepted: 65561 Total Submissions: 173200 Difficulty: Easy
	Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
	
	For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * @author xianyiye
 * 2015/12/21
 */

public class Solution {
	
	 // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int counter = 0 ;
    	while(n!=0){
    		if((n & 1) ==1){
    			counter++ ;
    		}
        	n = n>>1 ;
        }
    	
    	return counter ;
    }
    
    public int hammingWeight2(int n) {
    	int counter = 0 ;
        for(; n!=0 ; ++counter){
        	n = n & (n-1) ;
        }
    	
    	return counter ;
    }


}
