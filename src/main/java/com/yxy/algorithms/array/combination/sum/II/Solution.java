package com.yxy.algorithms.array.combination.sum.II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 40. Combination Sum II  QuestionEditorial Solution  My Submissions
	Total Accepted: 74576
	Total Submissions: 261861
	Difficulty: Medium
	Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
	
	Each number in C may only be used once in the combination.
	
	Note:
	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.
	For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
	A solution set is: 
	[
	  [1, 7],
	  [1, 2, 5],
	  [2, 6],
	  [1, 1, 6]
	]

 * @author xianyiye
 * @date 07/13/2016
 * 
 * Reference:
 * https://discuss.leetcode.com/topic/44037/combination-sum-i-ii-and-iii-java-solution-see-the-similarities-yourself
 */
public class Solution {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>() ;
		Arrays.sort(candidates);
		calculate(candidates, target, 0, new ArrayList<Integer>(), ret) ;
		
		return ret ;
    }
	
	
	private static void calculate(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> ret){
		if(target==0){
			ret.add(new ArrayList<Integer>(list)) ;
		}
		
		if(target<0 || start==candidates.length){
			return ;
		}
		
		for(int i=start ; i<candidates.length; i++){
			//This is the magic place!! 
			//When i==start, it means candidates[i] is under consideration. 
			//So, if there any other item whose value is same with the candidates[i], then it should be ignored.
			//Otherwise, same value will be considered again.
			if (i>start && candidates[i] == candidates[i-1]) continue; 
			list.add(candidates[i]) ;
			calculate(candidates, target-candidates[i], i+1, list, ret) ;
			list.remove(list.size()-1) ;
		}
	}

	
	public static void main(String[] args) {
//		List<List<Integer>> ret = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8) ;
		List<List<Integer>> ret = combinationSum2(new int[]{1,1,1,1,2}, 4) ;
		for(List<Integer> list : ret){
			for(int num : list){
				System.out.print(num+" ");
			}
			System.out.println() ;
		}
	}

}
