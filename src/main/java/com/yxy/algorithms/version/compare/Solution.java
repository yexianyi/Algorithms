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
package com.yxy.algorithms.version.compare;

/**
 * 	165. Compare Version Numbers My Submissions Question
	Total Accepted: 42636 Total Submissions: 257225 Difficulty: Easy
	Compare two version numbers version1 and version2.
	If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
	
	You may assume that the version strings are non-empty and contain only digits and the . character.
	The . character does not represent a decimal point and is used to separate number sequences.
	For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
	
	Here is an example of version numbers ordering:
	
	0.1 < 1.1 < 1.2 < 13.37
 * @author xianyiye
 * 2016/1/19
 */

public class Solution {

	public static int compareVersion(String version1, String version2) {
        String[] array_1 = version1.split("\\.") ;
        String[] array_2 = version2.split("\\.") ;
        
        for(int i=0; i<array_1.length && i<array_2.length; i++){
        	int diff = Integer.valueOf(array_1[i]) - Integer.valueOf(array_2[i]) ;
        	if(diff!=0){
        		return diff > 0 ? 1 : -1 ; 
        	}
        	
        }
        
        int sum_1 = 0;
        int sum_2 = 0 ;
        for(String num : array_1){
        	sum_1 += Integer.valueOf(num) ;
        }
        
        for(String num : array_2){
        	sum_2 += Integer.valueOf(num) ;
        }
        
        
		if(sum_1 == sum_2){
			return 0 ;
		}
        
		return sum_1 > sum_2 ? 1 : -1 ;
    }

	public static void main(String[] args) {
		System.out.println(compareVersion("1","1.0"));
		System.out.println(compareVersion("01","1"));
		System.out.println(compareVersion("1.3","1.3"));
		System.out.println(compareVersion("1.3","1.2.3"));
		System.out.println(compareVersion("1.1","1.2.3"));
		System.out.println(compareVersion("1.1","1.1.1"));

	}

}
