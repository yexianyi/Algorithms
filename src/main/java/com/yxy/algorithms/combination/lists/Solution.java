package com.yxy.algorithms.combination.lists;

import java.util.ArrayList;
import java.util.List;
/**
 * 77. Combinations   My Submissions QuestionEditorial Solution
	Total Accepted: 74375 Total Submissions: 216462 Difficulty: Medium
	Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	
	For example,
	If n = 4 and k = 2, a solution is:
	
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
 * @author xianyiye
 * @date 05/06/2016
 */
public class Solution {

	//2 ms backtracking
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>() ;
		List<Integer> list = new ArrayList<Integer>() ;
		travel(ret, list, 1, n-k+1, k) ;
		
		return ret ;
    }
	
	private void travel(List<List<Integer>> ret, List<Integer> list, int start, int end, int len) {
		if(len==0){
			List<Integer> listCopy = new ArrayList<Integer>(list) ;
			ret.add(listCopy) ;
			return ;
		}
		
		for(int i=start; i<=end; i++){
			list.add(i) ;
			travel(ret, list, i+1, end+1, len-1) ;
			list.remove(list.size()-1) ;
		}
	
		
	}

	public static void main(String[] args) {
		Solution s = new Solution() ;
		s.combine(4, 2) ;
	}

}
