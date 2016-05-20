package com.yxy.algorithms.matrix.set.zeros;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public static void setZeroes(int[][] matrix) {
        Set<Integer> rowIdxs = new HashSet<Integer>() ;
        Set<Integer> colIdxs = new HashSet<Integer>() ;
        
        for(int i=0; i<matrix.length; i++){
        	for(int j=0; j<matrix[0].length; j++){
        		if(matrix[i][j]==0){
        			rowIdxs.add(i) ;
        			colIdxs.add(j) ;
        		}
        	}
        }
        
        for(int i=0; i<matrix.length; i++){
        	for(int j=0; j<matrix[0].length; j++){
        		if(matrix[i][j]!=0  && (rowIdxs.contains(i) || colIdxs.contains(j))){
        			matrix[i][j] = 0 ;
        		}
        	}
        }
        
    }

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,0},
						 {5,0,7,8},
						 {9,1,2,3}} ;
		
		setZeroes(matrix) ;
		
		 for(int i=0; i<matrix.length; i++){
        	for(int j=0; j<matrix[0].length; j++){
        		System.out.print(matrix[i][j]+" ");
        	}
        	System.out.println() ;
	     }

	}

}
