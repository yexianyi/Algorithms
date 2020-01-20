package com.yxy.algorithms.array.largest.num;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;
/**
 * 179. Largest Number
	Given a list of non negative integers, arrange them such that they form the largest number.
	
	Example 1:
	
	Input: [10,2]
	Output: "210"
	Example 2:
	
	Input: [3,30,34,5,9]
	Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
 * @author Ye Xianyi
 * 2020/01/20
 */
public class Solution {

	//Failed
	public static String largestNumber(int[] nums) {
		Map<Integer, Queue<Integer>> sortedMap = new TreeMap<>() ;
		for(int num: nums) {
			int copy = num ;
			while(num/10 != 0) {
				num = num/10 ;
			}
			
			if(sortedMap.containsKey(num)) {
				sortedMap.get(num).offer(copy) ;
			}else {
				Queue<Integer> heap = new PriorityQueue<Integer>() ;
				heap.offer(copy) ;
				sortedMap.put(num, heap) ;
			}
		}
		
		String res = "" ;
		for(int i=9; i>=0; i--) {
			Queue<Integer> heap = sortedMap.get(i) ;
			while(heap!=null && !heap.isEmpty()) {
					res += heap.poll() ;
			}
			
		}
		
		return res ;
	}

	public static void main(String[] args) {
		System.out.println(largestNumber(new int[] {3,30,34,5,9})) ; // 9534330
	}

}
