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
public class Solution {

	//traversing
	public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<List<Integer>>() ;
        int[] nums = {1,2,3,4,5,6,7,8,9} ;
        long min = 0;
        long max = 0 ;
        
        for(int i=0; i<k ; i++){
        	min = (long) (min + nums[i]*Math.pow(10, k-i-1)) ;
        	max = (long) (max + nums[9-k+i]*Math.pow(10, k-i-1)) ;
        }
        
//        System.out.println(min);
//        System.out.println(max);
        
        for(long i=min; i<=max; i++){
        	List<Integer> combinations = new ArrayList<Integer>() ;
        	long num = i ;
        	int preNum = -1 ;
        	boolean isValid = true ;
        	
        	while(num>0){
        		int digital = (int) (num%10) ;
        		num /= 10 ;
        		
        		if(digital<preNum || preNum==-1){
        			preNum = digital ;
        			combinations.add(0, digital); ;
        		}else{
        			isValid = false ;
        			break ;
        		}
        	}
        	
        	if(!isValid){
        		continue ;
        	}
        	
        	//calculate sum
        	int sum = 0;
        	for(int number : combinations){
        		sum += number ;
        	}
        	
        	if(sum==n){
        		results.add(combinations) ;
        	}
        	
        }
        
		return results ;
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
		
		results = combinationSum3(3,9) ;
		showResults(results) ;
		
	}

}
