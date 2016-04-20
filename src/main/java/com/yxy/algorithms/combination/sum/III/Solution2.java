package com.yxy.algorithms.combination.sum.III;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III   My Submissions QuestionEditorial Solution
	Total Accepted: 30148 Total Submissions: 84730 Difficulty: Medium
	Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
	
	Ensure that numbers within the set are sorted in ascending order.
	
	
	Example 1:
	
	Input: k = 3, n = 7
	
	Output:
	
	[[1,2,4]]
	
	Example 2:
	
	Input: k = 3, n = 9
	
	Output:
	
	[[1,2,6], [1,3,5], [2,3,4]]

 * @author xianyiye
 * @Date 20/04/2016
 */

public class Solution2 {

	//Recursion
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>() ;
        List<Integer> currList = new ArrayList<Integer>() ;
        
        combination(k, n, 1, results, currList) ;
        
		return results ;
    }
	
	public static void combination(int k, int n, int start, List<List<Integer>> results, List<Integer> currList){
		if (n<0 || currList.size() > k) { //n<0 is very crucial for the performance
            return;
        }
		
		if(currList.size()==k && n==0){
			results.add(new ArrayList<Integer>(currList)) ;
			return ;
		}
		
		
		for(int i=start; i<=9; i++){
			currList.add(i) ;
			combination(k, n-i, i+1, results, currList) ;
			currList.remove(currList.size()-1) ;
		}
		
	}
	
	
	
	public static void showResults(List<List<Integer>> results){
		System.out.println("-----------------") ;
		for(List<Integer> list : results){
			for(Integer num : list){
				System.out.print(num+" ") ;
			}
			System.out.println() ;
		}
	}
	
	public static void main(String[] args) {
		
		List<List<Integer>> results = combinationSum3(3,7) ;
		showResults(results) ;
		
//		results = combinationSum3(3,9) ;
//		showResults(results) ;
		
	}

}
