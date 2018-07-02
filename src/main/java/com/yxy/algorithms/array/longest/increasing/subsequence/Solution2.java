package com.yxy.algorithms.array.longest.increasing.subsequence;

/**
 * 300. Longest Increasing Subsequence   My Submissions QuestionEditorial Solution
	Total Accepted: 26531 Total Submissions: 77383 Difficulty: Medium
	Given an unsorted array of integers, find the length of longest increasing subsequence.
	
	For example,
	Given [10, 9, 2, 5, 3, 7, 101, 18],
	The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
	
	Your algorithm should run in O(n2) complexity.
	
	Follow up: Could you improve it to O(n log n) time complexity?
 * @author xianyiye
 * @date 04/29/2016
 *	Reference:
 *	https://segmentfault.com/a/1190000003819886
 */
public class Solution2 {
	
	//O(n^2)
	public static int lengthOfLIS(int[] nums) {
		if(nums.length == 0){
            return 0;
        }
		
        int[] lis = new int[nums.length];
        int max = 0;
        
        for (int i=0; i<nums.length; i++){
            int tempMax = 0;
            //find out the LIS of previous node
            for (int j=0; j<i; j++){
                if (nums[i]>nums[j]){
                    tempMax = Math.max(tempMax, lis[j]);
                }
            }
            // the LIS of current node = tempMax + 1 ;
            lis[i] = tempMax + 1;
            // update global max
            max = Math.max(max, lis[i]);
        }
        return max;

	}
	

	public static void main(String[] args) {
//		System.out.println(new Solution2().lengthOfLIS(new int[]{2,2}));
		System.out.println(new Solution2().lengthOfLIS(new int[]{1,3,5,2,8,4,6}));
//		System.out.println(new Solution2().lengthOfLIS(new int[]{10,9,2,5,3,4}));
//		System.out.println(new Solution2().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

	}

}
