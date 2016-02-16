package com.yxy.algorithms.array.product.except.self;
/**
 * 	238. Product of Array Except Self My Submissions Question
	Total Accepted: 34004 Total Submissions: 82492 Difficulty: Medium
	Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
	
	Solve it without division and in O(n).
	
	For example, given [1,2,3,4], return [24,12,8,6].
	
	Follow up:
	Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 * @author xianyiye
 * 2016/2/16
 */

public class Solution {
	
	public static int[] productExceptSelf(int[] nums) {
        int[] array = new int[nums.length] ;
        int p = 1 ;
        array[0] = p ;
        for(int i=1; i<array.length; i++){
        	p = p*nums[i-1] ;
        	array[i] = p ;
        }
        
        
        p = 1 ;
        for(int i=array.length-2; i>=0; i--){
        	p = p*nums[i+1] ;
        	array[i] *= p ;
        }
        
		return array ;
    }

	public static void main(String[] args) {
		int[] array = {9,0,-2} ;
		for(int num : productExceptSelf(array)){
			System.out.print(num + " ") ;
		}

	}

}
