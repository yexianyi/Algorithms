package com.yxy.algorithms.array.word.breaks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
	Medium
	Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
	
	Note:
	
	The same word in the dictionary may be reused multiple times in the segmentation.
	You may assume the dictionary does not contain duplicate words.
	Example 1:
	
	Input: s = "leetcode", wordDict = ["leet", "code"]
	Output: true
	Explanation: Return true because "leetcode" can be segmented as "leet code".
	Example 2:
	
	Input: s = "applepenapple", wordDict = ["apple", "pen"]
	Output: true
	Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
	             Note that you are allowed to reuse a dictionary word.
	Example 3:
	
	Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
	Output: false
 * @author Ye Xianyi
 * 2019/12/16
 * 
 * Reference:
 * https://leetcode.com/problems/word-break/discuss/452977/Java-solution-1-ms-faster-than-99.51-(35.7-MB-less-than-96.38)
 *
 */
public class Solution {

	
	public static boolean wordBreak(String s, List<String> wordDict) {
		return wordBreak(s, wordDict, new HashSet<>()) ;
	}
	
	public static boolean wordBreak(String s, List<String> wordDict, Set<String> mismatchesCache) {
		if (s.length() < 1) {
            return true;
        }
		
		if(mismatchesCache.contains(s)) {
			return false ;
		}
		
		for(String replace : wordDict) {
			if(s.startsWith(replace) && wordBreak(s.substring(replace.length()), wordDict, mismatchesCache)) {
				return true ;
			} 
		}
		
		mismatchesCache.add(s) ;
		return false ;
	}
	
	

	public static void main(String[] args) {
		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));	
		System.out.println(wordBreak("ccaccc", Arrays.asList("cc", "ac")));
		System.out.println(wordBreak("dogs", Arrays.asList("dog", "s", "gs")));
		System.out.println(wordBreak("ccbb", Arrays.asList("bc", "cb")));
		System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
		System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
		System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
	}

}
