package com.yxy.algorithms.combination.sum.III;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	//traversing
	public static List<List<Integer>> combinationSum3(int k, int n) {
        
        int start = 1 ;
        int[] nums = {0,1,2,3,4,5,6,7,8,9} ;
        
        List<List<Integer>> results = new ArrayList<List<Integer>>() ;
        
        while(start<=9){
        	List<Integer> list = new ArrayList<Integer>() ;
        	int sum = 0;
        	
         	for(int count=0, j=start; count<=k && j<=9; j++){
         		sum += nums[j] ;
         		count++ ;
         		if(sum<n){
         			if(count==k){
         				count-- ;
         				sum -= nums[j] ;
         				continue ;
         			}else{
         				list.add(nums[j]) ;
         			}
         		}
         		
         		if(sum==n && count==k){
         			list.add(nums[j]) ;
         			results.add(list) ;
         			break ;
         		}
         		
         	}
         	start++ ;
        }//end while
       
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
