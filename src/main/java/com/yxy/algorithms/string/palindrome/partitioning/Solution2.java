package com.yxy.algorithms.string.palindrome.partitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning QuestionEditorial Solution My Submissions Total
 * Accepted: 69521 Total Submissions: 245358 Difficulty: Medium Given a string
 * s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 * @author xianyiye
 * @date 07/19/2016
 * 
 * Copy from:
 * https://discuss.leetcode.com/topic/50118/java-solution-with-preliminary-indexation-beats-95
 */
public class Solution2 {

	// beats 95%
	public static List<List<String>> partition(String s) {
	    boolean[][] palindromes = findAllPalindromes(s);
	    List<List<String>> result = new ArrayList<List<String>>();
	    partition(s, 0, palindromes, new ArrayList<String>(), result);
	    return result;
	}

	public static boolean[][] findAllPalindromes(String s) {
	    if (s.length() == 1) {
	        return new boolean[][]{{true, true}};
	    }
	    boolean[][] palindromes = new boolean[s.length()][s.length()];
	    for (int idx = 0; idx < s.length(); idx++) {
	        // Case 1: the character is at the center of palindrome
	        for (int i = idx, p = idx; i >= 0 && p < s.length(); i--, p++) {
	            if (s.charAt(i) != s.charAt(p))
	                break;
	            palindromes[i][p] = true;
	        }

	        // Case 2: character is the same as its neighbour
	        if (idx < s.length() - 1) {
	            for (int i = idx, p = idx + 1; i >= 0 && p < s.length(); i--, p++) {
	                if (s.charAt(i) != s.charAt(p))
	                    break;
	                palindromes[i][p] = true;
	            }
	        }
	    }

	    return palindromes;
	}

	public static void partition(String s, int idx, boolean[][] p, List<String> current, List<List<String>> result) {
	    if (idx == s.length()) {
	        result.add(new ArrayList<>(current));
	        return;
	    }
	    for (int i = idx; i < s.length(); i++) {
	        if (p[idx][i]) {
	            current.add(s.substring(idx, i + 1));
	            partition(s, i + 1, p, current, result);
	            current.remove(current.size() - 1);
	        }
	    }
	}
	
	

	public static void main(String[] args) {
		List<List<String>> ret = partition("caaab");
		System.out.println("================");
		for (List<String> list : ret) {
			for (String str : list) {
				System.out.print(" " + str);
			}
			System.out.println();
		}
	}

}
