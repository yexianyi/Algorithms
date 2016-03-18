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
package com.yxy.algorithms.string.strstr.impl;

/**
 * 	28. Implement strStr() My Submissions Question
	Total Accepted: 86396 Total Submissions: 362919 Difficulty: Easy
	Implement strStr().
	
	Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


 * @author xianyiye
 * 2016/1/12
 */
public class Solution2 {
	
    public static int strStr(String haystack, String needle) {
    	
    	if(haystack.length()>=needle.length()){
    		if(needle.length()==0){
    			return 0 ;
    		}
    		
    		for(int i=0; i<haystack.length(); i++){
        		if(haystack.charAt(i)==needle.charAt(0)){
        			if(haystack.length()-i>=needle.length()){
        				if(needle.equals(haystack.substring(i, i+needle.length()))){
        					return i ;
        				}
        				
        			}else{
        				break ;
        			}
            		
        		}
        	}
    	}
    	
    	
    	return -1 ;
    }

	public static void main(String[] args) {
		System.out.println(strStr("mississippi","issipi"));
		System.out.println(strStr("",""));
		System.out.println(strStr("a",""));
	}

}
