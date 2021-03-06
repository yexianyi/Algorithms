package com.yxy.algorithms.array.k.diff.pairs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 532. K-diff Pairs in an Array

	Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
	
	Example 1:
	Input: [3, 1, 4, 1, 5], k = 2
	Output: 2
	Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
	Although we have two 1s in the input, we should only return the number of unique pairs.
	Example 2:
	Input:[1, 2, 3, 4, 5], k = 1
	Output: 4
	Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
	Example 3:
	Input: [1, 3, 1, 5, 4], k = 0
	Output: 1
	Explanation: There is one 0-diff pair in the array, (1, 1).
	Note:
	The pairs (i, j) and (j, i) count as the same pair.
	The length of the array won't exceed 10,000.
	All the integers in the given input belong to the range: [-1e7, 1e7].
 * @author Ye Xianyi
 * 2019/02/28
 *
 */
public class Solution {

    public static int findPairs(int[] nums, int k) {
        Set<Pair> set = new HashSet<>() ;
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1 ; j<nums.length; j++) {
                if(Math.abs(nums[i] - nums[j]) == k) {
                    set.add(new Pair(nums[i], nums[j])) ;
                }
            }
        }
        
        return set.size() ;
    }
    
    static class Pair{
        int left ;
        int right ;
        
        public Pair(int l, int r) {
            left = l;
            right = r ;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj ;
            if((this.left == p.left && this.right == p.right ) 
                    ||(this.left == p.right && this.right == p.left ) ) {
                return true ;
            }
            return false;
        }
        
        
    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[] {3, 1, 4, 1, 5}, 2));

    }

}
