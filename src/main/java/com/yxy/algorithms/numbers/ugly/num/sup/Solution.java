package com.yxy.algorithms.numbers.ugly.num.sup;

public class Solution {

	//timeout
	public static int nthSuperUglyNumber(int n, int[] primes) {
        int count = 1 ;
		int min = primes[0] ;
		
		for(int num=min; num<Long.MAX_VALUE && count<n; num++){
			int copyNum = num ;
			for(int i=0; i<primes.length; i++){
				if(copyNum==1){
					count++ ;
					break ;
				}else if(copyNum%primes[i]==0){
					copyNum /= primes[i] ;
					i = -1 ;
				}
			}
			
			if(count==n){
				return num ;
			}
		}
		
		return 1 ;
    }
	
	public static void main(String[] args) {
		System.out.println(nthSuperUglyNumber(1,new int[]{2, 7, 13, 19}));
	}

}
