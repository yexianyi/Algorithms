package com.yxy.algorithms.range.sum.query.immutable;

/**
 * 
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

	Example:
	
	Given nums = [-2, 0, 3, -5, 2, -1]
	
	sumRange(0, 2) -> 1
	sumRange(2, 5) -> -1
	sumRange(0, 5) -> -3
	
	
	Note:
	
	1.You may assume that the array does not change.
	2.There are many calls to sumRange function.

 * 
 * @author Xianyi Ye
 * 2015/12/17
 */

public class NumArray {
	
	private int[][] tempArray ;

    public NumArray(int[] nums) {
    	tempArray = new int[nums.length][nums.length] ;
    	for(int i=0; i<nums.length; i++){
    		int sum = nums[i] ;
    		for(int j=i+1; j<nums.length; j++){
    			sum = sum + nums[j] ;
    			tempArray[i][j] = sum ;
    		}
    	}
    }

    public int sumRange(int i, int j) {
		return tempArray[i][j];
    }
    
    public static void main(String[] args){
    	int[] nums = {-2,0,3,-5,2,-1} ;
    	NumArray numArray = new NumArray(nums);
    	 System.out.println(numArray.sumRange(0, 2));
    	 System.out.println(numArray.sumRange(2, 5));
    	 System.out.println(numArray.sumRange(0, 5));
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);