/**
 * Copyright (c) 2016, Xianyi Ye
 *
 * This project includes software developed by Xianyi Ye
 * yexianyi@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.yxy.algorithms.valid.sudoku;

/**
 * 	36. Valid Sudoku My Submissions Question
	Total Accepted: 59356 Total Submissions: 204765 Difficulty: Easy
	Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
	
	The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
	
	
	A partially filled sudoku which is valid.
	
	Note:
	A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * @author Xianyi Ye
 * 	2016/1/5
 */

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public Set<Character> set = new HashSet<Character>();

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			if (validPartial(board, i, i, 0, 8) == false)
				return false;
			if (validPartial(board, 0, 8, i, i) == false)
				return false;
		}
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				if (validPartial(board, i, i + 2, j, j + 2) == false)
					return false;
			}
		}
		return true;
	}

	public boolean validPartial(char[][] board, int row1, int row2, int col1, int col2) {
		set.clear();
		for (int i = row1; i <= row2; i++) {
			for (int j = col1; j <= col2; j++) {
				if (board[i][j] != '.') {
					if (!set.add(board[i][j]))
						return false;
				}
			}
		}
		return true;
	}


	public static void main(String[] args) {
		char[][] board = new char[9][9] ;
		for(int i=0; i<9 ;i++){
			for(int j=0; j<9; j++){
				board[i][j] = '.' ;
			}
		}
		
		

	}

}
