package com.yxy.algorithms.array.single.num.II;

/**
 * 	137. Single Number II My Submissions Question
	Total Accepted: 72923 Total Submissions: 199354 Difficulty: Medium
	Given an array of integers, every element appears three times except for one. Find that single one.
	
	Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @author xianyiye
 * 2016/1/22
 * Reference:
 * http://blog.csdn.net/jiadebin890724/article/details/23306837
 */
public class Solution2 {

	public static int singleNumber(int[] nums) {
		int ones = 0; int twos = 0; int threes = 0;
        for(int i = 0; i < nums.length; i++){
            // if one is nums[i], by ANDing and ORing, two equals to nums[i]
            twos |= ones & nums[i];
            // if one is zero, it stores the nums[i] in it
            // if one is nums[i], it clears the content since a^a = 0
            // if one is other number, it just accumulates
            ones ^= nums[i]; 
            // if one and two has the same value, it means the 
            // number shows 3 times, thus
            threes = ones & twos;
            // if three is the number, clear this number from the one and two
            // a &= ~b => a - b
            // 0100 | 0011 = 3+4 = 7  (0111)
            // 7 &= ~3 => 0111 & 1100 = 0100 = 4 (7 - 3)
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
	}
	
	public static void main(String[] args) {
		System.out.println(singleNumber(new int[]{1,1,1,2}));
		System.out.println(singleNumber(new int[]{1,3,4,1,3,4,5,1,3,4}));
		System.out.println(singleNumber(new int[]{1,1,1}));

	}

}
