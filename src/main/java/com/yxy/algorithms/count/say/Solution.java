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
package com.yxy.algorithms.count.say;

/**
 * 	38. Count and Say My Submissions Question
	Total Accepted: 66543 Total Submissions: 244222 Difficulty: Easy
	The count-and-say sequence is the sequence of integers beginning as follows:
	1, 11, 21, 1211, 111221, ...
	
	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.
	Given an integer n, generate the nth sequence.
	
	Note: The sequence of integers will be represented as a string.
 * @author xianyiye
 * 2016/1/8
 */

public class Solution {
	
	public static String countAndSay(int n) {
		
		int[] hashTable = new int[10] ;
        String nums = "1" ;
        
        while(n-->1){
//        	String newNums = "" ;
        	StringBuffer sb = new StringBuffer();
        	
        	char target = nums.charAt(0) ;
        	for(int i=0; i<nums.length();){

        		if(nums.charAt(i)==target){
        			hashTable[nums.charAt(i)-'0']++ ;
        			if(i==nums.length()-1){
        				//collect current num
        				sb.append(hashTable[target-'0']).append(target-'0') ;
            			//reset recorder
            			hashTable[target-'0'] = 0 ;
        			}
        			
        			i++ ;
        			continue ;
        		}else{
        			//collect current num
        			sb.append(hashTable[target-'0']).append(target-'0') ;
        			//reset recorder
        			hashTable[target-'0'] = 0 ;
        			//switch target
        			target = nums.charAt(i) ;
        		}
        		
        	
        	}//end for
        	
        	nums = sb.toString() ;
        }
        
		
		return nums ;
    }
	
	
	public static void main(String[] args) {
		
		System.out.println(countAndSay(1)) ;
		System.out.println(countAndSay(2)) ;
		System.out.println(countAndSay(3)) ;
		System.out.println(countAndSay(4)) ;
		System.out.println(countAndSay(5)) ;

	}

}
