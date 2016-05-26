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
 * Copy from:
 * https://leetcode.com/discuss/25696/simple-java-solution-with-for-each-loops
 */
public class Solution2 {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>() ;
		ret.add(new ArrayList<Integer>()) ;
		
		Arrays.sort(nums);
		
		for(int i=0; i<nums.length ; i++){
			int currSize = ret.size() ;
			for(int j=0; j<currSize; j++){
				 // NOTE: must create a new tmp object, and add element to it.
				List<Integer> tmp = new ArrayList<Integer>(ret.get(j));
				tmp.add(nums[i]);
	            ret.add(tmp);
			}
		}
		
		return ret ;
		
    }
	
	
	



	public static void main(String[] args) {
		 List<List<Integer>> subsets = subsets(new int[]{1,2,3}) ;
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
