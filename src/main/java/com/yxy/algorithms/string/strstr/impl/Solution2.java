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
