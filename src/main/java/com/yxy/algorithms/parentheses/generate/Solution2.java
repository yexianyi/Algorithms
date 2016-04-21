package com.yxy.algorithms.parentheses.generate;

import java.util.ArrayList;
import java.util.List;
/**
 * 22. Generate Parentheses My Submissions QuestionEditorial Solution
	Total Accepted: 84755 Total Submissions: 230787 Difficulty: Medium
	Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
	
	For example, given n = 3, a solution set is:
	
	"((()))", "(()())", "(())()", "()(())", "()()()"
 * @author xianyiye
 * @date 04/13/2016
 * Copy from:
 * https://leetcode.com/discuss/71960/ms-beats-92%25-submissions-easy-java-space-optimized-solution
 */
public class Solution2 {
	
	public List<String> generateParenthesis(int n) {
	    List<String> res = new ArrayList<>();
	    char[] perm = new char[n*2];
	    perms(n, n, perm, 0, res);
	    return res;
	}

	private void perms(int open, int close, char[] perm, int i, List<String> res) {
	    if (i == perm.length) {
	        res.add(new String(perm));
	        return;
	    }
	    if (open > 0 && close >= open) {
	        perm[i] = '(';
	        perms(open - 1, close, perm, i+1, res);
	    }
	    if (close > 0) {
	        perm[i] = ')';
	        perms(open, close - 1, perm, i+1, res);
	    }
	}


}
