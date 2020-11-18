package com.yxy.algorithms.array.subarray.product.less.than.k;

public class Solution {

    // Time Limit Exceeded
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        
        for(int i=0; i<nums.length; i++) {
            int product = 1 ;
            for(int j=i; j<nums.length; j++) {
                product = product * nums[j] ;
                if(product < k) {
                    ans ++ ;
                } else {
                    break ;
                }
            }
        }
        return ans ;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100)) ;
    }

}
