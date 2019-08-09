package com.yxy.algorithms.matrix.word.search;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Time Limit Exceeded
    public static boolean exist(char[][] board, String word) {
        Set<String> path = new HashSet<>(word.length()) ;
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(search(board, i, j, word, 0, path) == true){
                    return true ;
                }
            }
        }
        
        return false ;
            
    }
    
    public static boolean search(char[][] board, int row, int col, String word, int curr, Set<String> path) {
        String pos = row + "" + col ;
        if(row < 0 || row > board.length-1 || col < 0 || col > board[0].length-1 || curr == word.length() || path.contains(pos)) {
            return false ;
        }
        
        path.add(pos) ;
        
        if(board[row][col] == word.charAt(curr)) {
            if(curr == word.length()-1) {
                return true ;
            }
            curr++ ;
        } 
        
        
        if(search(board, row + 1, col, word, curr, path)
        || search(board, row - 1, col, word, curr, path)
        || search(board, row, col + 1, word, curr, path)
        || search(board, row, col - 1, word, curr, path)) {
            return true ;
        }
        
        path.remove(pos) ;
        
        return false ;
    }

    public static void main(String[] args) {
        char[][] board = {  {'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}} ;
        
        System.out.println(exist(board, "ABCCED")); // true
        System.out.println(exist(board, "SEE")); // true
        System.out.println(exist(board, "ABCB")); // false
        
    }


}
