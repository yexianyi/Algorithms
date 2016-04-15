package com.yxy.algorithms.gray.code;

import java.util.ArrayList;
import java.util.List;
/**
 * 89. Gray Code My Submissions QuestionEditorial Solution
	Total Accepted: 58635 Total Submissions: 162009 Difficulty: Medium
	The gray code is a binary numeral system where two successive values differ in only one bit.
	
	Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
	
	For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
	
	00 - 0
	01 - 1
	11 - 3
	10 - 2
	Note:
	For a given n, a gray code sequence is not uniquely defined.
	
	For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
	
	For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.

 * @author xianyiye
 * @Date 04/15/2016
 * Copy from:
 * https://leetcode.com/discuss/86617/6-line-java-solution-very-concise
 */
public class Solution {
	
	//All we need to do is to add an '1' to the top digit of the binary 
	//string and reversely added the new number to the list.
	public List<Integer> grayCode(int n) {
	    List<Integer> ans = new ArrayList<>();
	    ans.add(0);

	    for(int i = 0; i < n ; i++)
	        for(int j = ans.size()-1; j>=0; j--)
	            ans.add(ans.get(j)+(1<<i));

	    return ans;
	}

	public static void main(String[] args) {

	}

}
