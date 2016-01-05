package com.yxy.algorithms.valid.anagram;

/**
 * 
	Valid Anagram
	 My Submissions 
	Question 
	Total Accepted: 44614 Total Submissions: 113828 Difficulty: Easy 
	
	Given two strings s and t, write a function to determine if t is an anagram of s.
	
	For example,
	s = "anagram", t = "nagaram", return true.
	s = "rat", t = "car", return false. 
	
	Note:
	 You may assume the string contains only lowercase alphabets.

 * @author Xianyi Ye
 * 2015/12/18
 */

public class Solution {
	
	public boolean isAnagram(String s, String t) {
		if((s==null | t==null)!=false || s.length() != t.length()){
			return false ;
		}
		
		int[] counter = new int[27] ;
		char[] s_chars = s.toCharArray() ;
		for(char ch : s_chars){
			counter[ch-96]++ ;
		}
		
		char[] t_chars = t.toCharArray() ;
		for(char ch : t_chars){
			if(counter[ch-96]==0){
				return false ;
			}
			counter[ch-96]-- ;
		}
		
		for(int count : counter){
			if(count>0){
				return false ;
			}
		}
		
		return true;

	}

	public static void main(String[] args) {
		String s = "anagram" ;
		String t = "nagaras" ;
		
		Solution solution = new Solution() ;
		System.out.println(solution.isAnagram(s, t));

	}

}
