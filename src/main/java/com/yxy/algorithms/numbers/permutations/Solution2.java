package com.yxy.algorithms.numbers.permutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 46. Permutations   My Submissions QuestionEditorial Solution
	Total Accepted: 97046 Total Submissions: 272240 Difficulty: Medium
	Given a collection of distinct numbers, return all possible permutations.
	
	For example,
	[1,2,3] have the following permutations:
	[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * @author xianyiye
 * @date 04/21/2016
 */
public class Solution2 {
	
	//DP (4ms)
	public List<List<Integer>> permute(int[] nums) {
		Map<Integer, List<List<Integer>>> dp = new HashMap<Integer, List<List<Integer>>>() ;
		
		List<List<Integer>> list = new ArrayList<List<Integer>>() ;
		List<Integer> initList = new ArrayList<Integer>() ;
		initList.add(nums[0]) ;
		list.add(initList) ;
		dp.put(0, list) ;
		
		for(int i=1; i<nums.length; i++){ //push each of num into list
			List<List<Integer>> preResultSet = dp.get(i-1) ;
			List<List<Integer>> currResultSet = new ArrayList<List<Integer>>() ;
			for(List<Integer> preResult : preResultSet){
				List<Integer> newResult = null ;
				for(int j=0; j<preResult.size(); j++){
					newResult = new ArrayList<Integer>(preResult) ;
					newResult.add(j, nums[i]);
					currResultSet.add(newResult) ;
				}
				
				newResult = new ArrayList<Integer>(preResult) ;
				newResult.add(nums[i]);
				currResultSet.add(newResult) ;
			}
			
			dp.put(i,currResultSet);
		}
		
		
		return dp.get(nums.length-1) ;
    }
	
	

	public static void main(String[] args) {
		Solution2 s = new Solution2() ;
		List<List<Integer>> results = s.permute(new int[]{1,2,3}) ;
		
		for(List<Integer> numList : results){
			for(int num : numList){
				System.out.print(num+" ");
			}
			System.out.println() ;
		}
	}

}
