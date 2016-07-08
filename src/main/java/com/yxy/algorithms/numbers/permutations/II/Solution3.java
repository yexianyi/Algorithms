package com.yxy.algorithms.numbers.permutations.II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
 */
public class Solution3 {
	
	//beats 6.54%
	//Recursion 
	public static List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> ret = new HashSet<List<Integer>>() ;
		
		findPermutations(nums, 0, new ArrayList<Integer>(), ret) ;
		
		return new ArrayList<List<Integer>>(ret) ;
    }

	private static void findPermutations(int[] nums, int pos, List<Integer> perm, Set<List<Integer>> ret) {
		if(pos==nums.length){
			ret.add(new ArrayList<Integer>(perm)) ;
			return ;
		}
		
		List<Integer> newPerm = new ArrayList<Integer>(perm);
		 
		for(int i=0 ; i<=pos; i++){
			newPerm.add(i, nums[pos]) ;
			findPermutations(nums, pos+1, newPerm, ret) ;
			newPerm.remove(i) ;
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
