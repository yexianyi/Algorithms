package com.yxy.algorithms.array.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 78. Subsets My Submissions QuestionEditorial Solution
	Total Accepted: 97074 Total Submissions: 306263 Difficulty: Medium
	Given a set of distinct integers, nums, return all possible subsets.
	
	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If nums = [1,2,3], a solution is:
	
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]

 * @author xianyiye
 * @date 05/25/2016
 */
public class Solution {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>() ;
		ret.add(new ArrayList<Integer>()) ;
		
		Arrays.sort(nums);
		for(int len=1; len<=nums.length ; len++){
			travelSubsets(nums, len, 0, ret, new ArrayList<Integer>()) ;
		}
		
		return ret ;
    }
	
	
	
	private static void travelSubsets(int[] nums, int len, int start, List<List<Integer>> ret, List<Integer> subSet) {
		if(subSet.size()==len){
			ret.add(new ArrayList<Integer>(subSet));
			return ;
		}
		
		for(int i=start; i<nums.length; i++){
			subSet.add(nums[i]) ;
			travelSubsets(nums, len, i+1, ret, subSet) ;
			subSet.remove(subSet.size()-1) ;
		}
		
	}



	public static void main(String[] args) {
		 List<List<Integer>> subsets = subsets(new int[]{1,2,2}) ;
//		 List<List<Integer>> subsets = subsets(new int[]{4,1,0}) ;
		 for(List<Integer> subSet : subsets){
			 System.out.print("[") ;
			 for(Integer num:subSet){
				 System.out.print(num+" ");
			 }
			 System.out.print("]") ;
			 System.out.println();
		 }
	}

}
