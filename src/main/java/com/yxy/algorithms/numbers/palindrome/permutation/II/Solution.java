package com.yxy.algorithms.numbers.palindrome.permutation.II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 267. Palindrome Permutation II
	Medium
	Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
	
	Example 1:
	
	Input: "aabb"
	Output: ["abba", "baab"]
	Example 2:
	
	Input: "abc"
	Output: []
 * @author Ye Xianyi
 * 2020/11/15
 * 
 * Reference:
 * https://leetcode.com/problems/palindrome-permutation-ii/solution/
 *
 */
public class Solution {

	public static List<String> generatePalindromes(String s) {
		// 1. check possibility
		int[] map = new int[128] ;
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			map[s.charAt(i)] ++ ;
			if(map[s.charAt(i)] % 2 == 0) {
				count -- ;
			} else {
				count ++ ;
			}
		}
		
		if(count > 1) {
			return new ArrayList<>() ;
		}
		
		// 2. generate half palindrome string
		Map<Character, Integer> groups = new HashMap<>() ;
		// 2.1 grouping and find out the single char
		Character single = null ;
		for(int i=0; i<map.length; i++) {
			if(map[i] % 2 == 1) {
				single = (char) i ;
				map[i] -- ;
			}
			
			if(map[i] !=0 ) {
				groups.put((char) i, map[i]/2) ;
			}
			
		}
		// 2.2 generate permutation with grouped string
		return generatePermutation(groups, single) ;
	}

	private static List<String> generatePermutation(Map<Character, Integer> groups, Character single) {
		// calculate max len
		int max = groups.values().stream().reduce(Integer::sum).orElse(0) ;
		List<String> ans = new ArrayList<>() ;
		backtrack(max, new LinkedList<>(), groups, single, ans);
		return ans ;
		
	}

	private static void backtrack(int maxLen, LinkedList<Character> currList, Map<Character, Integer> groups, Character single, List<String> ans) {
		if(currList.size() == maxLen) {
			// generate left half palindrome
			StringBuilder sb = new StringBuilder();    
			
			Iterator<Character> iter = currList.iterator() ;
			while(iter.hasNext()) {
				sb.append(iter.next()) ;
			}
			
			if(single != null) {
				sb.append(single) ;
			}
			
			iter = currList.descendingIterator() ;
			while(iter.hasNext()) {
				sb.append(iter.next()) ;
			}
			
			ans.add(sb.toString()) ;
		}
		
		for(Map.Entry<Character, Integer> entry : groups.entrySet()) {
			char c = entry.getKey() ;
			int count = entry.getValue() ;
			
			if(count == 0) {
				continue ;
			}
			
			currList.addLast(c) ;
			groups.put(c, count - 1) ;
			backtrack(maxLen, currList, groups, single, ans);
			groups.put(c, count) ;
			currList.removeLast() ;
		}
		
	}


	public static void main(String[] args) {
		List<String> ans = generatePalindromes("aaaaaa") ;
//		List<String> ans = generatePalindromes("aabc") ;
//		List<String> ans = generatePalindromes("abc") ;
//		List<String> ans = generatePalindromes("aabb") ;
//		List<String> ans = generatePalindromes("aabbc") ;
		ans.forEach(s -> System.out.println(s));

	}

}
