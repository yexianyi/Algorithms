package com.yxy.algorithms.matrix.word.search;

/**
 * 79. Word Search
    Given a 2D board and a word, find if the word exists in the grid.
    
    The word can be constructed from letters of sequentially adjacent cell, 
    where "adjacent" cells are those horizontally or vertically neighboring. 
    The same letter cell may not be used more than once.
    
    Example:
    
    board =
    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]
    
    Given word = "ABCCED", return true.
    Given word = "SEE", return true.
    Given word = "ABCB", return false.
 * @author yexianyi
 * 2019/08/12
 *
 */
public class Solution {

    public static boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(search(board, i, j, word, 0)){
                        return true ;
                    }
                }
               
            }
        }
        
        return false ;
            
    }
    
    public static boolean search(char[][] board, int row, int col, String word, int curr) {
        if(row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col]!=word.charAt(curr)) {
            return false ;
        }
        
        char backup = board[row][col] ;
        board[row][col] = ' ' ;
        
        if(curr == word.length()-1) {
            return true ;
        }
        
        
        boolean res = search(board, row + 1, col, word, curr+1)
                    || search(board, row - 1, col, word, curr+1)
                    || search(board, row, col + 1, word, curr+1)
                    || search(board, row, col - 1, word, curr+1) ;
        
        board[row][col] = backup ;
        
        return res ;
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
