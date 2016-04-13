package com.yxy.algorithms.generate.parentheses;

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
 */
public class Solution {
	
	public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>() ;
        if(n>0){
        	generate(list, "", n , n) ;
        }
        
		return list ;
    }

	private static void generate(List<String> list, String parenthesis, int left, int right) {
		if(right==0){
			list.add(parenthesis) ;
		}
		
		if(left>0){
			generate(list, parenthesis+"(", left-1 , right) ;
		}
		
		if(right>left){ //This is very crucial! 
						//The right part could be added to current parenthesis if and only if there is available ")".
						//Additionally, if ")" could be added, there must be a "(" on the left, 
						//which means that the vacancy of "(" will be less than right for 1 at least.
			generate(list, parenthesis+")", left , right-1) ;
		}
		
	}

	public static void main(String[] args) {
		List<String> list = generateParenthesis(3) ;
		
		for(String parenthesis : list){
			System.out.println(parenthesis);
		}

	}

}
