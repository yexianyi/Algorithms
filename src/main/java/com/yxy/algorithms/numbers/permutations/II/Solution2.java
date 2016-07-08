package com.yxy.algorithms.numbers.permutations.II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
public class Solution2 {
	
	//beats 15.6%
	//dp 
	public static List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> ret = new HashSet<List<Integer>>() ;
		
		Map<Integer, Set<List<Integer>>> dp = new HashMap<Integer, Set<List<Integer>>>() ;
		List<Integer> initList = new ArrayList<Integer>() ;
		initList.add(nums[0]) ;
		ret.add(initList) ;
		dp.put(0, ret) ;
		
		for(int i=1; i<nums.length; i++){
			Set<List<Integer>> preRet = dp.get(i-1) ;
			Set<List<Integer>> currRs = new HashSet<List<Integer>>() ;
			
			for(List<Integer> list: preRet){
				List<Integer> newList = null ;
				for(int j=0; j<list.size(); j++){
					newList = new ArrayList<Integer>(list) ;
					newList.add(j, nums[i]);
					currRs.add(newList) ;
				}
				
				//add candidate to the tail of the existing array
				newList = new ArrayList<Integer>(list) ;
				newList.add(nums[i]);
				currRs.add(newList) ;
			}
			
			dp.put(i,currRs);
		}
		
		return new ArrayList<List<Integer>> (dp.get(nums.length-1));
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
