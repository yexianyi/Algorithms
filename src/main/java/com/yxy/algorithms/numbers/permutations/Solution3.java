package com.yxy.algorithms.numbers.permutations;

import java.util.ArrayList;
import java.util.List;
/**
 * 46. Permutations   My Submissions QuestionEditorial Solution
	Total Accepted: 97046 Total Submissions: 272240 Difficulty: Medium
	Given a collection of distinct numbers, return all possible permutations.
	
	For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * @author xianyiye
 * @date 04/21/2016
 * Copy from:
 * https://leetcode.com/discuss/55127/java-solution-easy-to-understand-backtracking
 */
public class Solution3 {
	
	  List<List<Integer>> list;

	  //recursion (3ms)
	  public List<List<Integer>> permute(int[] nums) {
	      list = new ArrayList<>();
	      ArrayList<Integer> perm = new ArrayList<Integer>();
	      backTrack(perm,0,nums);
	      return list;
	  }

	  void backTrack (ArrayList<Integer> perm,int i,int[] nums){

	      //Permutation completes
	      if(i==nums.length){
	          list.add(new ArrayList(perm));
	          return;
	      }

	      ArrayList<Integer> newPerm = new ArrayList<Integer>(perm);

	     //Insert elements in the array by increasing index
	      for(int j=0;j<=i;j++){
	          newPerm.add(j,nums[i]); //This is the magic place. 
	          						  //Instead of removing each of candidates from Nums, 
	          						  //we can inject each of candidate into existing numbers with different positions.
	          backTrack(newPerm,i+1,nums);
	          newPerm.remove(j);
	      }

	  }
	
	

	public static void main(String[] args) {
		Solution3 s = new Solution3() ;
		List<List<Integer>> results = s.permute(new int[]{1,2,3}) ;
		
		for(List<Integer> numList : results){
			for(int num : numList){
				System.out.print(num+" ");
			}
			System.out.println() ;
		}
	}

}
