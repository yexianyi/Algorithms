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
package com.yxy.algorithms.string.longest.comm.prefix;

/**
 * 14. Longest Common Prefix My Submissions Question
	Total Accepted: 80957 Total Submissions: 300896 Difficulty: Easy
	Write a function to find the longest common prefix string amongst an array of strings.
 * @author xianyiye
 * 2016/1/11
 */

public class Solution {
	
	public static String longestCommonPrefix(String[] strs) {
	    if(strs==null || strs.length==0){
	    	return "" ;
	    }
		
	    int min_len = Integer.MAX_VALUE;
	    for(String str : strs){
	    	if(str.length()==0){
	    		return "" ;
	    	}else if(str.length() < min_len){
	    		min_len = str.length() ;
	    	}
	    }
	   
	    int i=0; 
	    for(;i<min_len; i++){
	    	char ch = strs[0].charAt(i) ;
	    	for(String str : strs){
	    		if(str.charAt(i) != ch){
	    			return strs[0].substring(0, i) ;
	    		}
	    	}
	    	
	    }
		
		return strs[0].substring(0, i) ;
	}

	public static void main(String[] args) {
//		String strs[] = {"abcdef","abcde","abcdk","abcjku"} ;
		String strs[] = {"a"} ;
		System.out.println(longestCommonPrefix(strs)) ;
		
	}

}
