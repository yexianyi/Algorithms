package com.yxy.algorithms.array.kth.largest.elem;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
		215. Kth Largest Element in an Array
	    My Submissions 
	Question Editorial Solution  
	
	Total Accepted: 56474 Total Submissions: 168404 Difficulty: Medium 
	
	Find the kth largest element in an unsorted array. 
	Note that it is the kth largest element in the sorted order, not the kth distinct element. 
	
	For example,
	 Given [3,2,1,5,6,4] and k = 2, return 5. 
	
	Note: 
	 You may assume k is always valid, 1 ≤ k ≤ array's length.
	
	Note: 
	 You may assume k is always valid, 1 ≤ k ≤ array's length.

 * @author Xianyi Ye
 * @date 10/13/2020
 */
public class Solution5 {

	 public int findKthLargest(int[] nums, int k) {
	     Queue<Integer> heap = new PriorityQueue<>() ;
	     for(int num : nums) {
	         heap.add(num) ;
	         if(heap.size() > k) {
	             heap.poll() ;
	         }
	         
	     } 
	     
	     return heap.poll() ;
	 }

	    

	public static void main(String[] args) {
		System.out.println(new Solution5().findKthLargest(new int[]{2,1},1));

	}
}
