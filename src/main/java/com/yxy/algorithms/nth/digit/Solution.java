package com.yxy.algorithms.nth.digit;

import java.util.Stack;

public class Solution {

	//Time Limit Exceeded
	public static int findNthDigit(int n) {
		Stack<Integer> stack = new Stack<>() ;
		int counter = 0 ;
		
		for(int num=1; num<=Integer.MAX_VALUE; num++) {
			int copy = num ;
			while(copy>0) {
				int remain = copy % 10 ;
				copy = copy / 10 ;
				stack.push(remain) ;
			}
			
			while(!stack.isEmpty()) {
				if(++counter == n) {
					return stack.pop() ;
				}
				
				stack.pop() ;
			}
		}
		
	
		return -1 ;
	}

	public static void main(String[] args) {
		System.out.println(findNthDigit(11)); //0
		System.out.println(findNthDigit(10)); //1
		System.out.println(findNthDigit(3)); //3
		System.out.println(findNthDigit(9)); //9
	}

}
