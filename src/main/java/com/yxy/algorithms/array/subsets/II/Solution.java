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
 */
public class Solution {

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Set<List<Integer>> ret = new HashSet<List<Integer>>() ;
		ret.add(new ArrayList<Integer>()) ;
		
		Arrays.sort(nums);
		for(int len=1; len<=nums.length ; len++){
			travelSubsets(nums, len, 0, ret, new ArrayList<Integer>()) ;
		}
		
		return new ArrayList<List<Integer>>(ret) ;
    }
	
	
	
	private static void travelSubsets(int[] nums, int len, int start, Set<List<Integer>> ret, List<Integer> subSet) {
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
