package com.yxy.algorithms.string.last.word.length;

/**
 * 	58. Length of Last Word My Submissions Question
	Total Accepted: 77433 Total Submissions: 273522 Difficulty: Easy
	Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
	
	If the last word does not exist, return 0.
	
	Note: A word is defined as a character sequence consists of non-space characters only.
	
	For example, 
	Given s = "Hello World",
	return 5.
 * @author xianyiye
 * 2016/1/6
 */

public class Solution {
	
	public static int lengthOfLastWord(String s) {
		if(s!=null){
			s = s.trim() ;
		}
		
        int start = s.lastIndexOf(' ');
        if(start==-1){
        	return s.length() ;
        }
        
		return s.length() - start -1 ;
    }

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("hello world "));

	}

}
