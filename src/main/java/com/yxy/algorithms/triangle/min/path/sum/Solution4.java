package com.yxy.algorithms.triangle.min.path.sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution4 {
	

	//DP: from bottom to top
	public int minimumTotal(List<List<Integer>> triangle) {
		int rowNum = triangle.size();
	    int[] dp = new int[rowNum];
	    for (int i = 0; i < triangle.get(rowNum - 1).size(); i++) {
	        dp[i] = triangle.get(rowNum - 1).get(i);
	    }
	    for (int row = rowNum - 2; row >= 0; row--) {// for each layer
	        for (int col = 0; col <= row; col++) {
	            dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
	        }
	    }
	    return dp[0];
    }
	
	
	public static void main(String[] args) {
		Solution4 s = new Solution4() ;
		
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
