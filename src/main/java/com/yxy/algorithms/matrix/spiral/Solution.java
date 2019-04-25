package com.yxy.algorithms.matrix.spiral;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix 
 * Given a matrix of m x n elements (m rows, n columns), 
 * return all elements of the matrix in spiral
 * order.
 * 
 * Example 1:
 * 
 * Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ] Output: [1,2,3,6,9,8,7,4,5] Example 2:
 * 
 * Input: [ [1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ] Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * @author yexianyi 
 * 2019/04/25
 * 
 * Copy from: https://leetcode.com/problems/spiral-matrix/solution/
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList<>();
        if (matrix.length == 0) {
            return ans;
        }

        int row_len = matrix.length;
        int col_len = matrix[0].length;

        boolean[][] seen = new boolean[row_len][col_len];
        // 4 potential directions(clockwise turn): right, down, left and up
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };

        int r = 0, c = 0, di = 0;
        for (int i = 0; i < row_len * col_len; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            // next step position
            int next_r = r + dr[di];
            int next_c = c + dc[di];

            // not step into boundary
            if (next_r >= 0 && next_r < row_len && next_c >= 0 && next_c < col_len && !seen[next_r][next_c]) {
                r = next_r;
                c = next_c;
            } else { // step into boundary, then turning in clockwise order
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
