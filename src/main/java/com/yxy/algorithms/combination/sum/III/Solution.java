package com.yxy.algorithms.combination.sum.III;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	//traversing
	public static List<List<Integer>> combinationSum3(int k, int n) {
        
        int[] occupy = new int[10] ;
        int[] combinations = new int[k] ;
        
        for(int i=0 ; i<k; i++){
        	combinations[i] = i+1 ;
        }
        
        List<List<Integer>> results = new ArrayList<List<Integer>>() ;
        
      
       
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
