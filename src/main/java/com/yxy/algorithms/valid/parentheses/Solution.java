/**
 * Copyright (c) 2016, Xianyi Ye
 *
 * This project includes software developed by Xianyi Ye
 * yexianyi@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
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
