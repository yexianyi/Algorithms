package com.yxy.algorithms.array.subsets;

import java.util.ArrayList;
import java.util.Collections;
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
 * https://leetcode.com/discuss/55492/simple-java-solution-using-bit-operations
 * https://leetcode.com/problems/subsets/discuss/143671/JAVA-Simple-Bit-Map-Solution.-Runtime-(2-ms)-beats-100-solutions
 */
public class Solution3 {

	public static List<List<Integer>> subsets(int[] nums) {
		 int n = nums.length;
		    List<List<Integer>> subsets = new ArrayList<>();
		    for (int i = 0; i < Math.pow(2, n); i++)
		    {
		        List<Integer> subset = new ArrayList<>();
		        for (int j = 0; j < n; j++)
		        {
		            if (((1 << j) & i) != 0)
		                subset.add(nums[j]);
		        }
		        Collections.sort(subset);
		        subsets.add(subset);
		    }
		    return subsets;
		
    }
	
	
	



	public static void main(String[] args) {
		 List<List<Integer>> subsets = subsets(new int[]{1,2,3,4,5,6,7,8,9,10,
														 11,12,13,14,15,16,17,18,19,20,
														 21,22,23,24,25,26,27,28,29,30,
														 31,32,33,34,35,36,37,38,39,40,
														 41,42,43,44,45,46,47,48,49,50,
														 51,52,53,54,55,56,57,58,59,60,
														 61,62,63,64,65,66}) ;
		 
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
