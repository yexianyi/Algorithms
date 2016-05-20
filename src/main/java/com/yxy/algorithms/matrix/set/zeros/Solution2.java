package com.yxy.algorithms.matrix.set.zeros;
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
 * Copy from:
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class Solution2 {
	public void setZeroes(int[][] matrix) {

		if (matrix == null || matrix.length == 0) {
			return;
		}

		boolean setFirstRowToZeroes = false;
		boolean setFirstColumnToZeroes = false;

		// check if first column needs to be set to zero
		for (int row = 0; row < matrix.length; row++) {
			if (matrix[row][0] == 0) {
				setFirstColumnToZeroes = true;
				break;
			}
		}

		// check if first row needs to be set to zero
		for (int col = 0; col < matrix[0].length; col++) {
			if (matrix[0][col] == 0) {
				setFirstRowToZeroes = true;
				break;
			}
		}

		// mark columns and rows to be set to zero
		for (int row = 1; row < matrix.length; row++) {
			for (int col = 1; col < matrix[0].length; col++) {
				if (matrix[row][col] == 0) {
					matrix[row][0] = 0;
					matrix[0][col] = 0;
				}
			}
		}

		// make rows zero
		for (int row = 1; row < matrix.length; row++) {
			if (matrix[row][0] == 0) {
				for (int col = 1; col < matrix[0].length; col++) {
					matrix[row][col] = 0;
				}
			}
		}

		// make columns zero
		for (int col = 1; col < matrix[0].length; col++) {
			if (matrix[0][col] == 0) {
				for (int row = 1; row < matrix.length; row++) {
					matrix[row][col] = 0;
				}
			}
		}

		// zero out first row (if needed)
		if (setFirstRowToZeroes) {
			for (int col = 0; col < matrix[0].length; col++) {
				matrix[0][col] = 0;
			}
		}

		// zero out first column (if needed)
		if (setFirstColumnToZeroes) {
			for (int row = 0; row < matrix.length; row++) {
				matrix[row][0] = 0;
			}
		}
	}

}