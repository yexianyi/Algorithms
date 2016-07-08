package com.yxy.algorithms.numbers.permutations.II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * @date 07/08/2016
 * 
 * Copy from:
 * https://discuss.leetcode.com/topic/31445/really-easy-java-solution-much-easier-than-the-solutions-with-very-high-vote
 * http://blog.csdn.net/linhuanmars/article/details/21570835
 */
public class Solution4 {
	
	// beats 78%
	// Recursion
	public static List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return res;
		boolean[] visited = new boolean[nums.length]; // indicate whether the value is added to list.
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(nums, visited, list, res);
		return res;
	}

	public static void dfs(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i]){
				continue;
			}
			
			//this is the magic place!!
			//If nums[i-1] is used:
			//	1. When nums[i]==nums[i-1], it means nums[i-1] is already in the list candidate, so nums[i] should be added to the candidate list also.
			//	   Otherwise, the candidate list will not be integrate. In other words, whatever how do we ignore the duplicate num during recursion, 
			//     we have to ensure one of duplicate numbers is stated at the candidate list in finally. In this case, we assume that nums[i-1] is that one.
			//	2. When nums[i]!=nums[i-1], just add it to the candidate list.
			//If nums[i-1] is not used:
			//  1. When nums[i]==nums[i-1], it means there are duplicate numbers. But we should ignore it, because we plan to use this number while the scanner is in position [i-1];
			//	2. When nums[i]!=nums[i-1], just add it to the candidate list.
			if (i>0 && nums[i-1]==nums[i] && !visited[i-1]){ 
				continue;
			}
			
			visited[i] = true;
			list.add(nums[i]);
			
			dfs(nums, visited, list, res);
			
			visited[i] = false;
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> ret = permuteUnique(new int[]{1,1,2}) ;
		for(List<Integer> list : ret){
			for(int num : list){
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}

}
