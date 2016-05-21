package com.yxy.algorithms.array.kth.largest.elem;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/**
 * 
	215. Kth Largest Element in an Array
	    My Submissions 
	Question Editorial Solution  
	
	Total Accepted: 56474 Total Submissions: 168404 Difficulty: Medium 
	
	
	
	
	Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element. 
	
	For example,
	 Given [3,2,1,5,6,4] and k = 2, return 5. 
	
	Note: 
	 You may assume k is always valid, 1 ≤ k ≤ array's length.

 * @author Xianyi Ye
 * @date 05/21/2016
 */
public class Solution2 {

	public static int findKthLargest(int[] nums, int k) {
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		for(int num : nums){
			if(map.containsKey(num)){
				map.put(num, map.get(num)+1) ;
			}else{
				map.put(num, 1) ;
			}
		}
		
		int count = 0 ;
		NavigableMap<Integer, Integer> descMap = map.descendingMap() ;
		for (Map.Entry<Integer, Integer> entry : descMap.entrySet()) {  
			 count += entry.getValue() ;
			 if(count>=k){
				 return entry.getKey() ;
			 }
			  
		}  
		
		return -1;
    }
	

	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[]{2,1},1));

	}
}
