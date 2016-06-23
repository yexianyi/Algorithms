package com.yxy.algorithms.array.search.range;
/**
 * 	34. Search for a Range My Submissions QuestionEditorial Solution
	Total Accepted: 87836 Total Submissions: 297731 Difficulty: Medium
	Given a sorted array of integers, find the starting and ending position of a given target value.
	
	Your algorithm's runtime complexity must be in the order of O(log n).
	
	If the target is not found in the array, return [-1, -1].
	
	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].
 * @author xianyiye
 * @date 06/23/2016
 * 
 * Copy from:
 * https://leetcode.com/discuss/18242/clean-iterative-solution-binary-searches-with-explanation
 */
public class Solution2 {
	
	public static int[] searchRange(int[] nums, int target) {
		int hi = nums.length - 1;
        int low = 0;
        int[] rs = new int[2];
       // base case
        if(nums == null || nums.length == 0)
            return new int[]{-1, -1 };

       //left side
        while(low < hi){
            int mid = low + (hi - low) /2;
            if(target > nums[mid]){
                low = mid + 1;
            }else{
                hi = mid;
            }
        }
        if(target == nums[low]){
            rs[0] = low;
        }else{
            rs[0] = -1;
        }

        //right side
        hi = nums.length - 1;
        while(low < hi){
            int mid = (low + (hi - low) /2 ) + 1;

            if(target < nums[mid]){
                hi = mid - 1;
            }else{
                low = mid;
            }
        }   
        if(target == nums[hi]){
            rs[1] = hi;
        }else{
            rs[1] = -1;
        }

        return rs;
		
    }
	
	

	public static void main(String[] args) {
		int[] range = searchRange(new int[]{5, 7, 7, 8, 8, 10},8) ;
		System.out.println(range[0]+","+range[1]);

	}

}
