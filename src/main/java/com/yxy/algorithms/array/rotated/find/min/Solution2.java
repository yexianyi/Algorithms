package com.yxy.algorithms.array.rotated.find.min;
/**
 * 153. Find Minimum in Rotated Sorted Array   My Submissions QuestionEditorial Solution
	Total Accepted: 88402 Total Submissions: 244822 Difficulty: Medium
	Suppose a sorted array is rotated at some pivot unknown to you beforehand.
	
	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	Find the minimum element.
	
	You may assume no duplicate exists in the array.


 * @author xianyiye
 * @Date 04/18/2016
 * 
 */
public class Solution2 {
	
	/**
	 * The minimum element must satisfy one of two conditions: 
	 * 1) If rotate, A[min] < A[min - 1]; 
	 * 2) If not, A[0]. 
	 * Therefore, we can use binary search: 
	 * check the middle element, if it is less than previous one, then it is minimum. 
	 * If not, there are 2 conditions as well: 
	 * 		If it is greater than both left and right element, then minimum element should be on its right, 
	 * 		otherwise on its left.
	 * @param nums
	 * @return
	 */
	
	//O(logN)
	public static int findMin(int[] nums) {
       int start = 0 ;
       int end = nums.length -1 ;
       
       while(start<end){
    	   int mid = (start+end)/2 ;
    	   if(mid>0 && nums[mid]<nums[mid-1]){
    		   return nums[mid] ;
    	   }else{
    		   if(nums[mid]>=nums[start] && nums[mid]>nums[end]){// right
    			   start = mid + 1;
    		   }else{
    			   end = mid - 1 ; 
    		   }
    	   }
       }
       
       return nums[start] ;
    }

	public static void main(String[] args) {
		System.out.println(findMin(new int[]{1}));
		System.out.println(findMin(new int[]{1,2}));
		System.out.println(findMin(new int[]{3,1,2}));
		System.out.println(findMin(new int[]{1,2,3,4,5,6,7,0}));
		System.out.println(findMin(new int[]{4,5,6,7,0,1,2,3}));
	}

}
