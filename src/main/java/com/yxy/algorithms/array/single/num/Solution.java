package com.yxy.algorithms.array.single.num;

public class Solution {
	
	public static int singleNumber(int[] nums) {
		
		for(int i=0; i<nums.length; i++){
			boolean isFound = false ;
			int j=0 ;
			for(;j<nums.length; j++){
				if(i!=j && nums[j]==nums[i]){
					isFound = true ;
					break ;
				}
			}
			if(i!=j && !isFound){//not found
				return nums[i] ;
			}
			
		}
        
		return -1 ;
    }

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,1,2}));
		System.out.println(singleNumber(new int[]{1,3,4,5,3,5,1}));
		System.out.println(singleNumber(new int[]{1,3,4,5,3,5,1,4}));

	}

}
