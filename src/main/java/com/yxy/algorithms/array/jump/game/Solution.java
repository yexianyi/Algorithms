package com.yxy.algorithms.array.jump.game;

public class Solution {
	
	//timeout
	public static boolean canJump(int[] nums) {
       return jump(nums, 0) ;
		
    }

	private static boolean jump(int[] nums, int start) {
		if(start>=nums.length-1){
			return true ;
		}
		
		for(int i=1; i<=nums[start]; i++){
			if(jump(nums, start+i)){
				return true ;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		System.out.println(canJump(new int[]{2,3,1,1,4}));
		System.out.println(canJump(new int[]{3,2,1,0,4}));
	}

}
