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
package com.yxy.algorithms.happy.number;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 	202. Happy Number My Submissions Question
	Total Accepted: 46197 Total Submissions: 133330 Difficulty: Easy
	Write an algorithm to determine if a number is "happy".
	
	A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
	
	Example: 19 is a happy number
	
	12 + 92 = 82
	82 + 22 = 68
	62 + 82 = 100
	12 + 02 + 02 = 1
 * @author xianyiye
 * 2015/12/22
 */

public class Solution {
	
	private static Set<Integer> resultSet = new HashSet<Integer>() ;
	
	public static boolean isHappy(int n) {
		if(n==1){
			return true ;
		}
		
		if(resultSet.contains(n)){
			return false ;
		}
		resultSet.add(n) ;
		System.out.println(n);
		
        int sum =0 ;
        while(n > 0){
        	int remainder = n%10 ;
        	sum += remainder * remainder ;
        	n /= 10 ;
        }
        
    	return isHappy(sum) ;
        
    }
	
	public boolean isHappy2(int n) {
        if(n==1){
			return true ;
		}
		
		if(resultSet.contains(n)){
			return false ;
		}
		resultSet.add(n) ;
		
        List<Integer> list = new ArrayList<Integer>() ;
        while(n > 0){
        	list.add(n%10) ;
        	n /= 10 ;
        }
        
    	n = 0 ;
    	for (int num : list) {  
    		n += num*num ; 
    	}  
    	return isHappy(n) ;
    }

	public static void main(String[] args) {
		System.out.println(isHappy(1)) ;

	}

}
