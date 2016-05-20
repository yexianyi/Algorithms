package com.yxy.algorithms.matrix.set.zeros;

import java.util.HashSet;
import java.util.Set;
/**
 * 73. Set Matrix Zeroes My Submissions QuestionEditorial Solution
	Total Accepted: 66514 Total Submissions: 198163 Difficulty: Medium
	Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
	
	click to show follow up.
	
	Follow up:
	Did you use extra space?
	A straight forward solution using O(mn) space is probably a bad idea.
	A simple improvement uses O(m + n) space, but still not the best solution.
	Could you devise a constant space solution?
 * @author xianyiye
 * @date 05/20/2016
 */
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
