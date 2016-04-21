package com.yxy.algorithms.parentheses.add;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. Different Ways to Add Parentheses   My Submissions QuestionEditorial Solution
	Total Accepted: 20562 Total Submissions: 59323 Difficulty: Medium
	Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
	
	
	Example 1
	Input: "2-1-1".
	
	((2-1)-1) = 0
	(2-(1-1)) = 2
	Output: [0, 2]
	
	
	Example 2
	Input: "2*3-4*5"
	
	(2*(3-(4*5))) = -34
	((2*3)-(4*5)) = -14
	((2*(3-4))*5) = -10
	(2*((3-4)*5)) = -10
	(((2*3)-4)*5) = 10
	Output: [-34, -14, -10, -10, 10]
 * @author xianyiye
 * @date 04/21/2016
 */

public class Solution {
	
	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> results = new ArrayList<Integer>() ;
		if(input==null || input.length()==0){
			return results ;
		}
		
		results = compute(input, 0, input.length()-1) ;
		
		return results ;
    }

	//recursion
	private static List<Integer> compute(String input, int start, int end) {
		List<Integer> result = new ArrayList<Integer>() ;
		int operator = -1 ;
		for(int i=start; i<=end; i++){
			if(input.charAt(i)<'0' || input.charAt(i)>'9'){
				operator = i ;
				
				List<Integer> leftResultSet = compute(input, start, i-1) ;
				List<Integer> rightResultSet = compute(input, i+1, end) ;
				for(int left : leftResultSet){
					for(int right : rightResultSet){
						if(input.charAt(operator)=='+'){
							result.add(left + right) ;
						}else if(input.charAt(operator)=='-'){
							result.add(left - right) ;
						}else if(input.charAt(operator)=='*'){
							result.add(left * right) ;
						}
					}
				}
				
			}
		}//end for
		
		if(operator==-1) {// no operator
			result.add(Integer.valueOf(input.substring(start, end+1))) ;
		}
		
		return result;
	}

	public static void main(String[] args) {
		List<Integer> results = diffWaysToCompute("11") ;//2*3-4*5
		for(Integer result : results){
			System.out.println(result);
		}
	}

}
