package com.yxy.algorithms.triangle.min.path.sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {
	

	//DC with Hashmap
	public int minimumTotal(List<List<Integer>> triangle) {
		int[][] hashMap = new int[triangle.size()][triangle.get(triangle.size()-1).size()] ;
		for(int i=0; i<hashMap.length; i++){
			for(int j=0; j<hashMap[0].length; j++){
				hashMap[i][j] = Integer.MIN_VALUE ;
			}
		}
		
		int ret = dfs(0, 0, triangle, hashMap) ;
		
		return ret ;
    }
	
	
	private int dfs(int rowIdx, int colIdx, List<List<Integer>> triangle, int[][] hashMap){
		int n = triangle.size();
        if (rowIdx == n) {
            return 0;
        }
        
        if(hashMap[rowIdx][colIdx]!=Integer.MIN_VALUE){
        	return hashMap[rowIdx][colIdx] ;
        }
        
        int left = dfs(rowIdx + 1, colIdx, triangle, hashMap) ;
        int right = dfs(rowIdx + 1, colIdx + 1, triangle, hashMap) ;

		int min = Math.min(left, right) ;
		hashMap[rowIdx][colIdx] = min + triangle.get(rowIdx).get(colIdx);
		
		return hashMap[rowIdx][colIdx] ;
        //return Math.min(dfs(rowIdx + 1, colIdx, triangle), dfs(rowIdx + 1, colIdx + 1, triangle))  + triangle.get(rowIdx).get(colIdx);
		
	}

	public static void main(String[] args) {
		Solution3 s = new Solution3() ;
		
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
