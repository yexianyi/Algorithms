package com.yxy.algorithms.array.rotated.sorted.II;

public class Solution {
	
	public static boolean search(int[] nums, int target) {
        
		int head = nums[0] ;
		int end = nums[nums.length-1] ;
		
		if(target>=head){
			for(int i=0; i<nums.length; i++){
				if(nums[i]==target){
					return true ;
				}
			}
		}
		
		if(target<=end){
			for(int i=nums.length-1; i>=0; i--){
				if(nums[i]==target){
					return true ;
				}
			}
		}
		
		return false ;
    }

	public static void main(String[] args) {
		System.out.println(search(new int[]{1}, 0));

	}

}
