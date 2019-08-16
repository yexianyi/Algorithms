package com.yxy.algorithms.matrix.surrounded.regions;

/**
 * 130. Surrounded Regions
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * @author yexianyi
 * 2019/08/16
 * 
 */
class Solution {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];        
       
        for (int i = 0; i < m; i++) {
            char c = board[i][0];
            if (c == 'O') {
                dfs(board, i, 0, visited);
            }
        }
        
        for (int i = 0; i < n; i++) {
            char c = board[0][i];
            if (c == 'O') {
                dfs(board, 0, i, visited);
            }
        }
        
        for (int i = 0; i < m; i++) {
            char c = board[i][n-1];
            if (c == 'O') {
                dfs(board, i, n-1, visited);
            }
        }
        
        for (int i = 0; i < n; i++) {
            char c = board[m-1][i];
            if (c == 'O') {
                dfs(board, m-1, i, visited);
            }
        }
        
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    
    private static void dfs(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        
        if (board[i][j] == 'X' || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        dfs(board, i, j+1, visited);
        dfs(board, i, j-1, visited);
        dfs(board, i - 1, j, visited);
        dfs(board, i + 1, j, visited);
    }   

    public static void main(String[] args) {
//        char[][] matrix = { {'X', 'X', 'X', 'X'},
//                            {'X', 'O', 'O', 'X'},
//                            {'X', 'X', 'O', 'X'},
//                            {'X', 'O', 'X', 'X'}} ;
        
//        char[][] matrix = {     {'X','O','X','X'},
//                                {'O','X','O','X'},
//                                {'X','O','X','O'},
//                                {'O','X','O','X'},
//                                {'X','O','X','O'},
//                                {'O','X','O','X'}} ;
        
//        char[][] matrix = { {'X','O','X','O','X','O'},
//                            {'O','X','O','X','O','X'},
//                            {'X','O','X','O','X','O'},
//                            {'O','X','O','X','O','X'}} ;
        
        char[][] matrix = { {'O','O','O','O','X','X'},
                            {'O','O','O','O','O','O'},
                            {'O','X','O','X','O','O'},
                            {'O','X','O','O','X','O'},
                            {'O','X','O','X','O','O'},
                            {'O','X','O','O','O','O'}} ;
        
        solve(matrix) ;
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ") ;
            }
            System.out.println();
        }

    }

}
