package com.yxy.algorithms.ugly.number;

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
