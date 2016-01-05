package com.yxy.algorithms.ugly.number;

/**
 * 263. Ugly Number My Submissions Question
	Total Accepted: 35284 Total Submissions: 100762 Difficulty: Easy
	Write a program to check whether a given number is an ugly number.
	
	Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
	
	Note that 1 is typically treated as an ugly number.
 * @author xianyiye
 * 2015/12/22
 */

public class Solution {
	
	public static boolean isUgly(int num) {
		if(num==0){
			return false ;
		}
		if(num==1){
			return true ;
		}
		
		int[] factors = {2,3,5} ;
		
		for(int i=0; i<factors.length;){
			if(num%factors[i]!=0){
				i++ ;
				continue ;
			}
			
			num = num/factors[i] ;
			i = 0 ;
			if(num==0 || num==1){
				return true ;
			}
		}
		
		return false;
        
    }
	
	public static boolean isUgly2(int num) {
		if(num==0){
			return false ;
		}
		
		while(num%2==0){
			num/=2 ;
		}
		
		while(num%3==0){
			num/=3 ;
		}
		
		while(num%5==0){
			num/=5 ;
		}
		
		if(num==1){
			return true ;
		}
		
		return false;
        
    }

	public static void main(String[] args) {
		System.out.println(isUgly2(1));

	}

}
