package com.yxy.algorithms.climbing.stairs;

/**
 *  70. Climbing Stairs My Submissions Question
	Total Accepted: 84787 Total Submissions: 238451 Difficulty: Easy
	You are climbing a stair case. It takes n steps to reach to the top.
	
	Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author xianyiye
 * 2015/12/22
 */

public class Solution3 {
	
	public static int climbStairs(int n){
		if(n==1){
			return 1 ;
		}
		
		if(n==2){
			return 2 ;
		}
		
		int a = 1 ;
		int b = 2 ;
		int ways = 0; 
		for(int i=3; i<=n ; i++){
			ways = a + b ;
			a = b ;
			b = ways ;
		}
		
		return ways ;
	}
	
	
	

	public static void main(String[] args) {
		System.out.println(climbStairs(4));

	}

}
