package com.yxy.algorithms.array.jump.game;

public class Solution3 {
	
	//DP2, timeout
	public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;

        for (int i = 1; i < len; i++) {
            boolean can = false;
            for (int j = 0; j < i; j++) {
                // j can arrive and can jump to i.
                if (nums[j] >= i - j) {
                    can = true;
                    break;
                }
            }

            if (!can) {
                return false;
            }
        }
        
		return true;

    }


	public static void main(String[] args) {
		System.out.println(canJump(new int[]{2,3,1,1,4}));
		System.out.println(canJump(new int[]{3,2,1,0,4}));
	}

}
