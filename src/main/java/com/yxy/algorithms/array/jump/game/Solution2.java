package com.yxy.algorithms.array.jump.game;

public class Solution2 {
	
	//DP1,timeout
	public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int len = nums.length;
        boolean[] can = new boolean[len];
        can[0] = true;

        for (int i = 1; i < len; i++) {
            can[i] = false;
            for (int j = 0; j < i; j++) {
                // j can arrive and can jump to i.
                if (can[j] && nums[j] >= i - j) {
                    can[i] = true;
                    break;
                }
            }
        }

        return can[len - 1];
    }


	public static void main(String[] args) {
		System.out.println(canJump(new int[]{2,3,1,1,4}));
		System.out.println(canJump(new int[]{3,2,1,0,4}));
	}

}
