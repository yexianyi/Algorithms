package com.yxy.algorithms.valid.parentheses;

import java.util.Stack;

/**
 * 	20. Valid Parentheses My Submissions Question
	Total Accepted: 85883 Total Submissions: 306611 Difficulty: Easy
	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	
	The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author xianyiye
 * 2016/1/7
 */

public class Solution {
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>() ;
		stack.push('.') ;
		char[] array = s.toCharArray() ;
		for(char ch : array){
			switch(ch){
				case '{' : stack.push(ch) ; break ;
				case '[' : stack.push(ch) ; break ;
				case '(' : stack.push(ch) ; break ;
				
				case '}' : if(stack.pop() != '{'){return false;} break ;
				case ']' : if(stack.pop() != '['){return false;} break ;
				case ')' : if(stack.pop() != '('){return false;} break ;
			}
		}
        
		return stack.size()==1 ? true : false ;
    }

	public static void main(String[] args) {
		System.out.println(isValid("a(bc)d{ef[gh(ijkl]m}n"));

	}

}
