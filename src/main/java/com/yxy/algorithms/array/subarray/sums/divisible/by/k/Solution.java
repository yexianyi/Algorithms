package com.yxy.algorithms.array.subarray.sums.divisible.by.k;

/**
 * 
 * 974. Subarray Sums Divisible by K
    Medium
    
    Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
    
    Example 1:
    
    Input: A = [4,5,0,-2,-3,1], K = 5
    Output: 7
    Explanation: There are 7 subarrays with a sum divisible by K = 5:
    [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
     
    Note:
    
    1 <= A.length <= 30000
    -10000 <= A[i] <= 10000
    2 <= K <= 10000
 * 
 * @author Ye Xianyi
 * 2020/11/20
 *  Reference:
 *  https://blog.csdn.net/tomwillow/article/details/86558665
 */
public class Solution {

    public static int subarraysDivByK(int[] A, int K) {
        // init prefix sum
        int[] prefixSum = new int[A.length + 1] ;
        for(int i=0; i<A.length; i++) {
            prefixSum[i+1] = prefixSum[i] + A[i] ;
        }
        
        // init remainder map
        Integer[] remainderMap = new Integer[K] ; // key: the remainder; value: the times of remainder
        for(int i=0; i<prefixSum.length; i++) {
            int r = (prefixSum[i]%K + K) % K ;
            if(remainderMap[r] == null) {
                remainderMap[r] = 0 ;
            }
            remainderMap[r]++ ;
        }
        
        // calculate possibilities
        int ans = 0 ;
        for(Integer times : remainderMap) {
            if(times == null) {
                continue ;
            }
            
            ans += times*(times-1)/2 ;
        }
        
        return ans ;
    }

    public static void main(String[] args) {
        System.out.println(3%5) ;
        System.out.println(subarraysDivByK(new int[] {4,5,0,-2,-3,1}, 5)) ;
        System.out.println(subarraysDivByK(new int[] {2,-2,2,-4}, 7)) ;
    }

}
