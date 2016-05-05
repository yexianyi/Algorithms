package com.yxy.algorithms.matrix.game.of.life;
/**
 * 289. Game of Life   My Submissions QuestionEditorial Solution
	Total Accepted: 17567 Total Submissions: 51167 Difficulty: Medium
	According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
	
	Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
	
	Any live cell with fewer than two live neighbors dies, as if caused by under-population.
	Any live cell with two or three live neighbors lives on to the next generation.
	Any live cell with more than three live neighbors dies, as if by over-population..
	Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
	Write a function to compute the next state (after one update) of the board given its current state.
	
	Follow up: 
	Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
	In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

 * @author xianyiye
 * @date 05/05/2016
 * Reference:
 * http://www.cnblogs.com/grandyang/p/4854466.html
 */
public class Solution {
	
	private static final int[] row = {-1,-1,-1, 0, 0, 1, 1, 1} ;
	private static final int[] col = {-1, 0, 1,-1, 1, -1, 0, 1} ;
	
	private static enum State{
		DIED_TO_DIED(0), LIVES_TO_LIVES(1), LIVES_TO_DIED(2), DIED_TO_LIVES(3)  ;
		private int value; 

		State(int val) { 
	        this.value = val; 
	    } 
		
		public int getVal(){
			return value ;
		}
	}
	
	//3ms
	public void gameOfLife(int[][] board) {
		
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				int alive = 0;
				for(int k=0; k<8; k++){
					int rowIdx = i+row[k] ;
					int colIdx = j+col[k] ;
					
					if(rowIdx>=0 && colIdx>=0 && rowIdx<board.length && colIdx<board[0].length){
						int val = board[rowIdx][colIdx] ;
						if(val==State.LIVES_TO_DIED.getVal() || val==State.LIVES_TO_LIVES.getVal()){
							alive++ ;
						}
					}
				}//end for
				
				if((alive<2 || alive>3) && board[i][j]==State.LIVES_TO_LIVES.getVal()){
					board[i][j] = State.LIVES_TO_DIED.getVal() ;
				}else if(alive==3 && board[i][j]==State.DIED_TO_DIED.getVal()){
					board[i][j] = State.DIED_TO_LIVES.getVal() ;
				}
			}
		}//end for
		
		
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				board[i][j] = board[i][j]%2 ;
			}
		}
        
    }

	public static void main(String[] args) {
		int[][] board = {{1,1},{1,0}} ;
		
		Solution s = new Solution() ;
		s.gameOfLife(board);
	}

}
