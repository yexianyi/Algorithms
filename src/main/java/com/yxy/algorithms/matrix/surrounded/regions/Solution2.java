package com.yxy.algorithms.matrix.surrounded.regions;

import java.util.HashSet;
import java.util.Set;

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
 * Copy from:
 * https://leetcode.com/problems/surrounded-regions/discuss/355678/Java-solution-1ms-faster-than-100
 */
public class Solution2 {
    static class Point{
        int _x ;
        int _y ;
        
        public Point(int x, int y) {
            _x = x ;
            _y = y ;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + _x;
            result = prime * result + _y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            Point other = (Point) obj ;
            if (this._x == other._x && this._y == other._y) {
                return true;
            }
            return false ;
        }
        
        
    }
    
    // Time Limit Exceeded
    public static void solve(char[][] board) {
        Set<Point> escapedSet = new HashSet<>() ;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                Point point = new Point(i, j) ;
                if(board[i][j] == 'O' && !escapedSet.contains(point)) {
                    boolean isEscaped = escape(i, j, board, new HashSet<Point>(), escapedSet) ;
                    if(!isEscaped) {
                        board[i][j] = 'X' ;
                    }
                }
            }
        }
        
        
        
    }
    
    
    private static boolean escape(int r, int c, char[][] board, Set<Point> path, Set<Point> escapedSet) {
        if(r<0 || r== board.length || c<0 || c==board[0].length || board[r][c]=='X') {
            return false ;
        }
        
        if(path.contains(new Point(r,c))) {
            return false ;
        }
        
        if(board[r][c]=='O' && (r==0 || r == board.length-1 || c==0 || c==board[0].length-1)) {
            return true ;
        }
        
        Point curr = new Point(r, c) ;
        path.add(curr) ;
        boolean isEscaped = escape(r+1, c, board, path, escapedSet)
                           || escape(r-1, c, board, path, escapedSet)
                           || escape(r, c+1, board, path, escapedSet)
                           || escape(r, c-1, board, path, escapedSet) ;
        if(isEscaped) {
            escapedSet.addAll(path) ;
            return true ;
        } else {
            path.remove(curr) ;
        }
        return false ;
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
