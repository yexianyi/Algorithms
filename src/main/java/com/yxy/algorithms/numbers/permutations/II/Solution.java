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
public class Solution {
	
	//beats 2.79%
	//Recursion 
	public static List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> ret = new HashSet<List<Integer>>() ;
		List<Integer> candidates = new ArrayList<Integer>() ;
		for(int num : nums){
			candidates.add(num) ;
		}
		
		findPermutations(candidates, nums.length, new ArrayList<Integer>(), ret) ;
		
		return new ArrayList<List<Integer>>(ret) ;
    }

	private static void findPermutations(List<Integer> candidates, int remains, List<Integer> perm, Set<List<Integer>> ret) {
		if(remains==0){
			ret.add(new ArrayList<Integer>(perm)) ;
			return ;
		}
		
		for(int i=0 ; i<candidates.size(); i++){
			int num = candidates.get(i) ;
			perm.add(num) ;
			candidates.remove(i) ;
			
			findPermutations(candidates, remains-1, perm, ret) ;
			
			candidates.add(i, num);
			perm.remove(perm.size()-1) ;
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
