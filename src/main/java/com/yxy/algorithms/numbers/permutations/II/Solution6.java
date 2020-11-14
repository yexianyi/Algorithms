package com.yxy.algorithms.numbers.permutations.II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 47. Permutations II  QuestionEditorial Solution  My Submissions
	Total Accepted: 76800
	Total Submissions: 267865
	Difficulty: Medium
	Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	
	For example,
	[1,1,2] have the following unique permutations:
	[
	  [1,1,2],
	  [1,2,1],
	  [2,1,1]
	]

 * @author xianyiye
 * @date 11/14/2020
 * 
 */
public class Solution6 {
	
	public static List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Map<Integer, Integer> groups = new HashMap<>();
		for (int n : num) {
			groups.putIfAbsent(n, 0) ;
			groups.put(n, groups.get(n) + 1);
			
		}
		permutation(num.length, groups, new LinkedList<>(), ans);
		return ans;
	}

	public static void permutation(int maxLen, Map<Integer, Integer> groups, LinkedList<Integer> currList, List<List<Integer>> ans){
		if(currList.size() == maxLen) {
			ans.add(new ArrayList(currList)) ;
			return ;
		}
		
		for(Entry<Integer, Integer> entry : groups.entrySet()) {
			int num = entry.getKey() ;
			int count = entry.getValue() ;
			if(count == 0) {
				continue ;
			}
			
			currList.add(num);
			groups.put(num, count - 1) ;
			permutation(maxLen, groups, currList, ans);
			groups.put(num, count) ;
			currList.removeLast() ;
			
		}
		
	}
	

	public static void main(String[] args) {
		List<List<Integer>> ret = permuteUnique(new int[]{1,1,1,2}) ;
		for(List<Integer> list : ret){
			for(int num : list){
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}

}
