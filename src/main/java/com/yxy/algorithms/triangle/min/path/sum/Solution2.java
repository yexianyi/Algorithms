package com.yxy.algorithms.triangle.min.path.sum;

import java.util.ArrayList;
import java.util.List;
/**
 * 120. Triangle My Submissions QuestionEditorial Solution
	Total Accepted: 71619 Total Submissions: 234865 Difficulty: Medium
	Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
	
	For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	
	Note:
	Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * @author xianyiye
 * @date 06/03/2016
 * Reference:
 * http://www.kancloud.cn/kancloud/data-structure-and-algorithm-notes/73066
 */
public class Solution2 {
	

	//DC
	public int minimumTotal(List<List<Integer>> triangle) {
        
		int ret = dfs(0, 0, triangle) ;
		
		return ret ;
    }
	
	
	private int dfs(int rowIdx, int colIdx, List<List<Integer>> triangle){
		int n = triangle.size();
        if (rowIdx == n) {
            return 0;
        }
        
        int left = dfs(rowIdx + 1, colIdx, triangle) ;
        int right = dfs(rowIdx + 1, colIdx + 1, triangle) ;

		int min = Math.min(left, right) ;
		return min + triangle.get(rowIdx).get(colIdx);
		
        //return Math.min(dfs(rowIdx + 1, colIdx, triangle), dfs(rowIdx + 1, colIdx + 1, triangle))  + triangle.get(rowIdx).get(colIdx);
		
	}

	public static void main(String[] args) {
		Solution2 s = new Solution2() ;
		
		List<List<Integer>> triangle = new ArrayList<List<Integer>>() ;
		List<Integer> row1 = new ArrayList<Integer>() ;
		row1.add(2);
		
		List<Integer> row2 = new ArrayList<Integer>() ;
		row2.add(3);row2.add(4);
		
		List<Integer> row3 = new ArrayList<Integer>() ;
		row3.add(6);row3.add(5);row3.add(7);
		
		List<Integer> row4 = new ArrayList<Integer>() ;
		row4.add(4);row4.add(1);row4.add(8);row4.add(3);
		
		triangle.add(row1);
		triangle.add(row2);
		triangle.add(row3);
		triangle.add(row4);
		
		System.out.println(s.minimumTotal(triangle)) ;
		
		
	}

}
