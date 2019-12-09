package com.yxy.algorithms.array.find.duplicate.num;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	public int findDuplicate(int[] nums) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int num : nums) {
			queue.offer(num) ;
		}
		
		int curr = queue.poll() ;
		while(queue.size() > 0) {
			int next = queue.poll() ;
			if(curr == next) {
				return curr ;
			}else {
				curr = next ;
			}
		}
		
		
		return -1 ;
		
	}

	public static void main(String[] args) {

	}

}
