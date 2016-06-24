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
 * https://leetcode.com/discuss/24431/my-java-solution-with-fifo-queue
 */
public class Solution2 {
	
	
	public static List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (digits.length() == 0) {
			return ans;
		}

		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = digits.charAt(i) - '0';
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}

		return ans;
    }


	public static void main(String[] args) {
		for(String combination : letterCombinations("23")){ //"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
			System.out.print(combination+" ") ;
		}

	}

}
