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
 */
public class Solution {
	
	//recursion (5ms)
	public List<List<Integer>> permute(int[] nums) {
		List<Integer> numList = new ArrayList<Integer>() ;
		for(int num : nums){
			numList.add(num) ;
		}
		
		List<List<Integer>> results = new ArrayList<List<Integer>>() ;
		findPermute(results, new ArrayList<Integer>(), numList, 0) ;
		
		return results ;
    }
	
	private void findPermute(List<List<Integer>> results, List<Integer> currList, List<Integer> numList, int start){
		if(start==numList.size()+start){
			results.add(new ArrayList<Integer>(currList)) ;
			return ;
		}
		
		for(int i=0; i<numList.size(); i++){
			int num = numList.get(i) ;
			currList.add(num) ;
			
			numList.remove(i) ;
			findPermute(results, currList, numList, start+1) ;
			currList.remove(currList.size()-1) ;
			numList.add(i, num);
		}
		
	}
	
	

	public static void main(String[] args) {
		Solution s = new Solution() ;
		List<List<Integer>> results = s.permute(new int[]{1,2,3}) ;
		
		for(List<Integer> numList : results){
			for(int num : numList){
				System.out.print(num+" ");
			}
			System.out.println() ;
		}
	}

}
