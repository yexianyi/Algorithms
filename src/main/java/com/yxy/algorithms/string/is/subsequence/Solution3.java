package com.yxy.algorithms.string.is.subsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
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
 * @Date 2018/6/29
 */

public class Solution3 {
	
	/**
	 * Follow-up
	 * If we check each sk in this way, then it would be O(kn) time where k is the number of s and t is the length of t. 
	 * This is inefficient. 
	 * Since there is a lot of s, it would be reasonable to preprocess t to generate something that is easy to search for if a character of s is in t. 
	 * Sounds like a HashMap, which is super suitable for search for existing stuff. 
	 */
	public static boolean isSubsequence(String s, String t) {
	    if (s == null || t == null) return false;
	    
	    Map<Character, List<Integer>> map = new HashMap<>(); //<character, index>
	    
	    //preprocess t
	    for (int i = 0; i < t.length(); i++) {
	        char curr = t.charAt(i);
	        if (!map.containsKey(curr)) {
	            map.put(curr, new ArrayList<Integer>());
	        }
	        map.get(curr).add(i);
	    }
	    
	    int prev = -1;  //index of previous character
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        
	        if (map.get(c) == null)  {
	            return false;
	        } else {
	            List<Integer> list = map.get(c);
	            prev = binarySearch(prev, list, 0, list.size() - 1);
	            if (prev == -1) {
	                return false;
	            }
	            prev++;
	        }
	    }
	    
	    return true;
	}

	//find the first element of list that is greater than or equal to the index that is passed in
	private static int binarySearch(int index, List<Integer> list, int start, int end) {
	    while (start <= end) {
	        int mid = start + (end - start) / 2;
	        if (list.get(mid) < index) {
	            start = mid + 1;
	        } else {
	            end = mid - 1;
	        }
	    }
	    
	    return start == list.size() ? -1 : list.get(start);
	}
	
	public static void main(String[] args) {
		
		System.out.println(isSubsequence("abc", "ahbgdcahbgdcahbgdc"));
		System.out.println(isSubsequence("leeeeetcode", "yyyyyyyyyyyyyyyylyyyyyyyyyyyyyy"));
		System.out.println(isSubsequence("axc", "ahbgdc"));
	}

}
