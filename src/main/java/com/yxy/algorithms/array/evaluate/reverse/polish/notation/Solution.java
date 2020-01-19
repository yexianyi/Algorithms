package com.yxy.algorithms.array.evaluate.reverse.polish.notation;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
	Medium
	
	Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	
	Valid operators are +, -, *, /. Each operand may be an integer or another expression.
	
	Note:
	
	Division between two integers should truncate toward zero.
	The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
	Example 1:
	
	Input: ["2", "1", "+", "3", "*"]
	Output: 9
	Explanation: ((2 + 1) * 3) = 9
	Example 2:
	
	Input: ["4", "13", "5", "/", "+"]
	Output: 6
	Explanation: (4 + (13 / 5)) = 6
	Example 3:
	
	Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
	Output: 22
	Explanation: 
	  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
	= ((10 * (6 / (12 * -11))) + 17) + 5
	= ((10 * (6 / -132)) + 17) + 5
	= ((10 * 0) + 17) + 5
	= (0 + 17) + 5
	= 17 + 5
	= 22

 * @author Ye Xianyi
 * 2020/01/19
 *
 */
public class Solution {

	public static int evalRPN(String[] tokens) {
		if(tokens.length == 1) {
			return Integer.parseInt(tokens[0]) ;
		}
		
		int res = 0 ;
		Stack<Integer> stack = new Stack<>() ;
		int p = 0 ;
		while(p != tokens.length) {
			if(tokens[p].equals("+") || tokens[p].equals("-") || tokens[p].equals("*") || tokens[p].equals("/")) {
				int right = stack.pop() ;
				int left = stack.pop() ;
				res = calExp(left, right, tokens[p]) ;
				stack.push(res) ;
			} else {
				stack.push(Integer.parseInt(tokens[p])) ;
			}
			p++ ;
		}
		
		return res ;
	}
	
	private static int calExp(int left, int right, String op) {
		
		switch(op) {
			case "+": return left + right ;
			case "-": return left - right ;
			case "*": return left * right ;
			case "/": return left / right ;
			default: 
				return 0 ;
		}
	}

	public static void main(String[] args) {
		System.out.println(evalRPN(new String[] {"18"})); // 18
		System.out.println(evalRPN(new String[] {"2", "1", "+", "3", "*"})); // 9
		System.out.println(evalRPN(new String[] {"4", "13", "5", "/", "+"})); // 6
		System.out.println(evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})); // 22
	}

}
