package com.yxy.algorithms.bits.bitwise.and.numbers.range;

import java.util.Arrays;

public class Solution {
	
	public int rangeBitwiseAnd(int m, int n) {
        int inc = 1;
        int[] binary = new int[64] ;
        Arrays.fill(binary, 1);
        
        for(int i=1; i<=64; i++){
        	for(int num=m; num<=n; num++){
        		if((num&inc)==0){
        			binary[i-1] = 0 ;
        			break ;
        		}
        	}
        	inc <<= 1 ;
        }
        
        return -1 ;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
