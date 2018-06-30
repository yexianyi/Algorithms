package com.yxy.algorithms.string.is.subsequence;

/**
 * 
 * 392. Is Subsequence
	Given a string s and a string t, check if s is subsequence of t.
	
	You may assume that there is only lower case English letters in both s and t. 
	t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
	
	A subsequence of a string is a new string which is formed from the original string by deleting some 
	(can be none) of the characters without disturbing the relative positions of the remaining characters. 
	(ie, "ace" is a subsequence of "abcde" while "aec" is not).
	
	Example 1:
	s = "abc", t = "ahbgdc"
	
	Return true.
	
	Example 2:
	s = "axc", t = "ahbgdc"
	
	Return false.
	
	Follow up:
	If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, 
	and you want to check one by one to see if T has its subsequence. 
	In this scenario, how would you change your code?
 
 * @author Ye Xianyi
 * @Date 2018/6/30
 *
 */

public class Solution2 {
	
	public static boolean isSubsequence(String s, String t) {
		if(s.length()>t.length()) {
			return false ;
		}
		
		int s_len = s.length() ;
		int j_len = t.length() ;
		int i_left = 0, j_left = 0;
		int i_right = s_len-1, j_right = j_len-1 ;
		
		while( i_left<=i_right && j_left<j_right ) {
			if(s.charAt(i_left)==t.charAt(j_left++)) {
				i_left++ ;
			}
			
			if(s.charAt(i_right)==t.charAt(j_right--)) {
				i_right-- ;
			}
		}
		
		if(i_left-1==i_right) {
			return true ;
		}
		
		if(j_left==j_right) {
			return false ;
		}
		
		
		return false ;
    }

	public static void main(String[] args) {
		
		System.out.println(isSubsequence("axc", "ahbgdc"));
		System.out.println(isSubsequence("leeeeetcode", "yyyyyyyyyyyyyyyylyyyyyyyyyyyyyy"));
		System.out.println(isSubsequence("abc", "ahbgdc"));
	}

}
