package com.yxy.algorithms.array.k.diff.pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
public class Solution2 {

    public static int findPairs(int[] nums, int k) {
    	if (nums == null || nums.length == 0 || k < 0)   return 0;
    	
    	Set<Integer> set = new HashSet<>(nums.length/2) ;
        Arrays.sort(nums);
        
        for(int n : nums) {
            set.add(n) ;
        }
        
        int count = 0;
        if(k==0) {
        	Map<Integer, Integer> map = new HashMap<>(set.size()) ;
        	for(int n : nums) {
        		if(!map.containsKey(n)) {
        			map.put(n, 1) ;
        		}else {
        			map.put(n, map.get(n) + 1) ;
        		}
        	}
        	
        	return (int) map.values().stream().filter(val -> val >= 2).count() ;
        	
        }
        
        Integer curr = null ;
        for(int i=0; i<nums.length; i++) {
        	if(curr != null && curr == nums[i]) {
        		continue ;
        	} else {
        		curr = nums[i] ;
        	}
        	
        	if(set.contains(nums[i] + k)) {
        		count++ ;
        	} 
        }
        
        return count ;
    }
    
    public static void main(String[] args) {
    	System.out.println(findPairs(new int[] {1, 1, 1, 1, 1}, 0)); // 1
    	System.out.println(findPairs(new int[] {1, 2, 3, 4, 5}, -1)); // 0
    	System.out.println(findPairs(new int[] {3, 1, 4, 1, 5}, 0)); // 1
        System.out.println(findPairs(new int[] {3, 1, 4, 1, 5}, 2)); // 2

    }

}
