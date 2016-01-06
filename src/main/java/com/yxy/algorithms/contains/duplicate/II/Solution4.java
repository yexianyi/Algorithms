package com.yxy.algorithms.contains.duplicate.II;

import java.util.HashSet;
import java.util.Set;

/**
 * 	219. Contains Duplicate II My Submissions Question
	Total Accepted: 40044 Total Submissions: 141195 Difficulty: Easy
	Given an array of integers and an integer k, find out whether there 
	are two distinct indices i and j in the array such that nums[i] = nums[j] and 
	the difference between i and j is at most k.
	
 * @author xianyiye
 * 2016/1/6
 */

public class Solution4 {
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++) {
            if(set.size()<=k) {
                if (set.add(nums[i])==false){//already exist
                	return true;
                }
            } else{
                set.remove(nums[i-k-1]);
                if (set.add(nums[i])==false) {
                	return true;
                }
            }
        }
		
		return false;
    }

	public static void main(String[] args) {
		System.out.println(containsNearbyDuplicate(new int[]{-1,-1}, 1));
		System.out.println(containsNearbyDuplicate(new int[]{1,2,1}, 0));
		System.out.println(containsNearbyDuplicate(new int[]{1,2,1}, 1));
	}

}
