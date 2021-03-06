package com.yxy.algorithms.bits.bitwise.and.numbers.range;

/**
 * 201. Bitwise AND of Numbers Range
    My Submissions 
	Question Editorial Solution  
	
	Total Accepted: 35229 Total Submissions: 114440 Difficulty: Medium 
	
	Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
	
	For example, given the range [5, 7], you should return 4. 

 * @author xianyiye
 * @date 06/02/2016
 */
public class Solution {
	
	//timeout
	public static int rangeBitwiseAnd(int m, int n) {
        int inc = 1;
        int ret = 0 ;
        int i = 1 ;
        for(; i<=63 && inc<=n; i++){
        	boolean containsZero = false ;
        	for(int num=m; num<=n; num++){
        		if((num&inc)==0){
        			containsZero = true ;
        			break ;
        		}
        	}
        	if(!containsZero){
        		ret |= inc ;
        	}
        	inc <<= 1 ;
        }
        
        return ret ;
    }
	
	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5,7)) ;

	}

}
