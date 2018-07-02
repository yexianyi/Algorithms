package com.yxy.algorithms.array.longest.increasing.subsequence;

import java.util.Arrays;

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
 *	https://leetcode.com/discuss/91624/fast-java-binary-search-solution-with-detailed-explanation
 *	http://blog.csdn.net/yorkcai/article/details/8651895
 */
public class Solution3 {
	
	//O(n(logn))
	public int lengthOfLIS(int[] nums) {
		if(nums.length == 0 || nums == null){
            return 0;
        }
        int []dp = new int[nums.length];
        dp[0] = nums[0] ;
        int len = 0 ;
        
        for(int i=1; i<nums.length; i++){
        	int pos = binarySearch(dp, len, nums[i]) ;
        	if(nums[i]<dp[pos]){
        		dp[pos] = nums[i] ;
        	}
        	if(pos>len){
        		len = pos ;
        		dp[pos] = nums[i] ;
        	}
        }
        
        return len+1;
    
	}
	
	
	public int lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
	

	private int binarySearch(int[] dp, int len, int val) {
        int left = 0;
        int right = len;
        while(left+1 < right) {
            int mid = left + (right-left)/2;
            if (dp[mid] == val) {
                return mid;
            } else {
                if (dp[mid] < val) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (dp[right] < val) return len+1;
        else if (dp[left] >= val) return left;
        else return right;
    }



	public static void main(String[] args) {
		int[] array = new int[] {1,3,5,7} ;
		System.out.println(Arrays.binarySearch(array, 0, array.length, 2));
		
		
//		System.out.println(new Solution2().lengthOfLIS(new int[]{2,2}));
//		System.out.println(new Solution3().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
		System.out.println(new Solution3().lengthOfLIS(new int[]{10,9,2,5,3,4}));
		System.out.println(new Solution3().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

	}

}
