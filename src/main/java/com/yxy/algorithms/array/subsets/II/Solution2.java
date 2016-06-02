package com.yxy.algorithms.array.subsets.II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 90. Subsets II My Submissions QuestionEditorial Solution
	Total Accepted: 68948 Total Submissions: 223269 Difficulty: Medium
	Given a collection of integers that might contain duplicates, nums, return all possible subsets.
	
	Note:
	Elements in a subset must be in non-descending order.
	The solution set must not contain duplicate subsets.
	For example,
	If nums = [1,2,2], a solution is:
	
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]

 * @author xianyiye
 * @date 06/02/2016
 * 
 * Reference:
 * https://leetcode.com/discuss/54544/very-simple-and-fast-java-solution	
 */
public class Solution2 {

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
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
		
		int i=start ;
		while(i<nums.length){
			subSet.add(nums[i]) ;
			travelSubsets(nums, len, i+1, ret, subSet) ;
			subSet.remove(subSet.size()-1) ;
			
			i++;
	        while (i<nums.length && nums[i] == nums[i - 1]) {i++;} //this is the magic how different with Subset I
		}
		
	}



	public static void main(String[] args) {
		 List<List<Integer>> subsets = subsetsWithDup(new int[]{1,2,2}) ;
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
