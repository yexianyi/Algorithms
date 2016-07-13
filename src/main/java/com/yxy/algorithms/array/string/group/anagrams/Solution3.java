package com.yxy.algorithms.array.string.group.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 49. Group Anagrams  QuestionEditorial Solution  My Submissions
	Total Accepted: 82070
	Total Submissions: 286890
	Difficulty: Medium
	Given an array of strings, group anagrams together.
	
	For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
	Return:
	
	[
	  ["ate", "eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	Note: All inputs will be in lower-case.
	
 * @author xianyiye
 * @date 07/13/2016
 * Copy from:
 * https://discuss.leetcode.com/topic/45639/java-beat-100-use-prime-number
 */
public class Solution3 {
	
	public static List<List<String>> groupAnagrams(String[] strs) { 
		int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101,
				103 };// 10609 prime numbers at most

		List<List<String>> res = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (String s : strs) {
			int key = 1;
			for (char c : s.toCharArray()) {
				key *= prime[c - 'a'];
			}
			List<String> t;
			if (map.containsKey(key)) {
				t = res.get(map.get(key));
			} else {
				t = new ArrayList<>();
				res.add(t);
				map.put(key, res.size() - 1);
			}
			t.add(s);
		}
		return res;
	}

	public static void main(String[] args) {
//		System.out.println(groupAnagrams(new String[]{"",""}) );
		System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}) );
	}

}
