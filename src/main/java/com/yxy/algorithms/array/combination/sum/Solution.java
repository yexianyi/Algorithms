package com.yxy.algorithms.array.combination.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>() ;
		
		Arrays.sort(candidates);
		calculateSum(candidates, 0, 0, target, ret, new ArrayList<Integer>()) ;
		
		return ret ;
	}
	
	private static void calculateSum(int[] nums, int start, int sum, int target, List<List<Integer>> ret, List<Integer> subset){
		if(sum==target){
			ret.add(new ArrayList<Integer>(subset)) ;
			return ;
		}else if(sum>target){
			return ;
		}
		
		for(int i=start; i<nums.length; i++){
			sum += nums[i] ;
			if(sum>target){
				break ;
			}
			subset.add(nums[i]) ;
			calculateSum(nums, i, sum, target, ret, subset) ;
			subset.remove(subset.size()-1) ;
			sum -= nums[i] ;
		}
	}
	
	
	public static void main(String[] args) {
		 List<List<Integer>> subsets = combinationSum(new int[]{2,3,6,7}, 7) ;
//		 List<List<Integer>> subsets = subsets(new int[]{4,1,0}) ;
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
