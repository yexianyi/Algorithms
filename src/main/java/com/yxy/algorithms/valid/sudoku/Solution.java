package com.yxy.algorithms.valid.sudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public static boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<Character>() ;
        //check each row
        for(int i=0; i<9; i++){
        	for(int j=0; j<9; j++){
        		if(board[i][j]!='.'){
        			if(set.contains(board[i][j])){
            			return false ;
            		}else{
            			set.add(board[i][j]) ;
            		}
        		}
        		
        	}
        	set.clear();
        }
		
        
        //check each column
        for(int i=0; i<9; i++){
        	for(int j=0; j<9; j++){
        		if(board[j][i]!='.'){
        			if(set.contains(board[j][i])){
            			return false ;
            		}else{
            			set.add(board[j][i]) ;
            		}
        		}
        	}
        	set.clear();
        }
        
        //check each square
        int row = 0 ;
        int col = 0 ;
        for(int i=row; i<=row+2 && row<=8; i++){
        	for(int j=col; j<=col+2 && col<=8; j++){
            	System.out.println(i+""+j);
            }
        	col+=2 ;
        	row+=2 ;
        	System.out.println() ;
        }
        
        
		return true ;
    }


	public static void main(String[] args) {
		char[][] board = new char[9][9] ;
		for(int i=0; i<9 ;i++){
			for(int j=0; j<9; j++){
				board[i][j] = '.' ;
			}
		}
		
		isValidSudoku(board) ;
		

	}

}
