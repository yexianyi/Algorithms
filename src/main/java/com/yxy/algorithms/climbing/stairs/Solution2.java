package com.yxy.algorithms.climbing.stairs;

/**
 *  70. Climbing Stairs My Submissions Question
	Total Accepted: 84787 Total Submissions: 238451 Difficulty: Easy
	You are climbing a stair case. It takes n steps to reach to the top.
	
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author xianyiye
 * 2015/12/22
 */

public class Solution2 {
	
	public static int climbStairs(int n){
		int ways = 0 ;
		
		for(int k=0; k<=n/2; k++){
			ways += combination(n-k,k) ; 
		}
		
		return ways ;
	}
	
	
	public static int combination(int n, int k){
		if(k==0){
			return 1 ;
		}
		
		return factorial(n) / (factorial(k)*factorial(n-k)) ;
	}
	
	public static int factorial(int n) {
		if (n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(38));

	}

}
