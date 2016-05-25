package com.yxy.algorithms.array.subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>() ;
		
		for(int len=0; len<=nums.length ; len++){
			List<Integer> subSet = new ArrayList<Integer>() ;
			travelSubsets(nums, len, 0, ret, subSet) ;
		}
		
		return ret ;
    }
	
	
	
	private static List<Integer> travelSubsets(int[] nums, int len, int start, List<List<Integer>> ret, List<Integer> subSet) {
		if(start+len==nums.length+1){
			return subSet;
		}
		
		for(int i=start; i<start+len; i++){
			subSet.add(nums[i]) ;
			travelSubsets(nums, len, start+1, ret, subSet) ;
		}
		
		return subSet ;
	}



	public static void main(String[] args) {
		 List<List<Integer>> subsets = subsets(new int[]{1,2,3}) ;
		 for(List<Integer> subSet : subsets){
			 System.out.print("[") ;
			 for(Integer num:subSet){
				 System.out.print(num+" ");
			 }
			 System.out.print("]") ;
			 System.out.println();
		 }
	}

}
