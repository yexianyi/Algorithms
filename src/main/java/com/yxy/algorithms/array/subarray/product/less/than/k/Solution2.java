package com.yxy.algorithms.array.subarray.product.less.than.k;

/**
 * 713. Subarray Product Less Than K
    Medium
    Your are given an array of positive integers nums.
    
    Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
    
    Example 1:
    Input: nums = [10, 5, 2, 6], k = 100
    Output: 8
    Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
    Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
    Note:
    
    0 < nums.length <= 50000.
    0 < nums[i] < 1000.
    0 <= k < 10^6.
 * @author Ye Xianyi
 * 2020/11/19
 * 
 * Reference:
 * https://leetcode.com/problems/subarray-product-less-than-k/
 *
 */
public class Solution2 {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        
        int ans = 0;
        int accuProdcut = 1 ;
        int left = 0 ;
        
        for(int right=0; right<nums.length; right++) {
            accuProdcut *= nums[right] ;
            while(left <= right && accuProdcut >= k) {
                accuProdcut = accuProdcut / nums[left] ;
                left ++ ;
            }
            
            ans += right - left + 1;
        }
        
        
        return ans ;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100)) ;
    }

}
