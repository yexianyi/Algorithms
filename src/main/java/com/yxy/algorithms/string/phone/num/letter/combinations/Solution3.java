package com.yxy.algorithms.string.phone.num.letter.combinations;

import java.util.LinkedList;
import java.util.List;
/**
 * 17. Letter Combinations of a Phone Number My Submissions QuestionEditorial Solution
	Total Accepted: 84959 Total Submissions: 288900 Difficulty: Medium
	Given a digit string, return all possible letter combinations that the number could represent.
	
	A mapping of digit to letters (just like on the telephone buttons) is given below.
	
	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	Note:
	Although the above answer is in lexicographical order, your answer could be in any order you want.
 * @author xianyiye
 * @date 06/24/2016
 * 
 * Copy from:
 * https://leetcode.com/discuss/19516/my-recursive-solution-using-java
 */
public class Solution3 {
	
	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<String>();
        if (digits.length() == 0) {
		return ret;
	    }
	
        combination("", digits, 0, ret);
        return ret;
    }

    private static void combination(String prefix, String digits, int offset, List<String> ret) {
        if (offset >= digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }


	public static void main(String[] args) {
		for(String combination : letterCombinations("23")){ //"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
			System.out.print(combination+" ") ;
		}

	}

}
