package com.yxy.algorithms.array.sorted.search.insert.pos;

/**
 * 35. Search Insert Position My Submissions QuestionEditorial Solution
	Total Accepted: 99738 Total Submissions: 268948 Difficulty: Medium
	Given a sorted array and a target value, return the index if the target is found. 
	If not, return the index where it would be if it were inserted in order.
	
	You may assume no duplicates in the array.
	
	Here are few examples.
	[1,3,5,6], 5 → 2
	[1,3,5,6], 2 → 1
	[1,3,5,6], 7 → 4
	[1,3,5,6], 0 → 0


 * @author Xianyi Ye
 * @Date 03/28/2016
 */
public class Solution {
	
	public static int searchInsert(int[] nums, int target) {

		return searchInsert(nums, target, 0, nums.length-1) ;
    }
	
	
	private static int searchInsert(int[] nums, int target, int start, int end) {
		int middle = (start+end)/2 ;
		int intermidate = nums[middle] ;
		
		if(start>=end){
			return target>intermidate ? end+1 : start ;
		}
		
		
		if(target==intermidate){
			return middle ;
		}else if(target<intermidate){
			return searchInsert(nums, target, start, middle-1) ;
		}else{
			return searchInsert(nums, target, middle+1, end) ;
		}
		
    }

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[]{1,3},2)) ; //1
		System.out.println(searchInsert(new int[]{1,3},0)) ; //0
		System.out.println(searchInsert(new int[]{3,5,7,9,10},8)) ; //3
		System.out.println(searchInsert(new int[]{1,3,5,6},5)) ; //2
		System.out.println(searchInsert(new int[]{1,3,5,6},2)) ; //1
		System.out.println(searchInsert(new int[]{1,3,5,6},7)) ; //4
		System.out.println(searchInsert(new int[]{1,3,5,6},0)) ; //0
	}

}
