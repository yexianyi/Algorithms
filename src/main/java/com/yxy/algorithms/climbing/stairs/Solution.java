package com.yxy.algorithms.climbing.stairs;

public class Solution {
	
	public static int climbStairs(int n) {
		
		if(n==1){
			return 1 ;
		}
		else if(n==2){
			return 2 ;
		}
		
		return climbStairs(n-1) + climbStairs(n-2) ;
	}
	
	public static int climbStairs2(int n) {
		if(n<=0){
			return 0 ;
		}

		return climbStairs(n-1) + climbStairs(n-2) ;
	}
	
	public static int factorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(2));

	}

}
