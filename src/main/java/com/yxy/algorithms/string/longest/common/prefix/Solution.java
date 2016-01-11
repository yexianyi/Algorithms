package com.yxy.algorithms.string.longest.common.prefix;

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
