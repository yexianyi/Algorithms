package com.yxy.algorithms.string.longest.common.prefix;

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
