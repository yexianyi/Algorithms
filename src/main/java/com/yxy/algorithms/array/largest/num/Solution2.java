package com.yxy.algorithms.array.largest.num;

import java.util.Arrays;

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
 * 
 * Copy from:
 * https://leetcode.com/problems/largest-number/discuss/485294/very-Simple-sort-solution-java
 */
public class Solution2 {

	public static String largestNumber(int[] nums) {
		String[] s_nums = new String[nums.length];
	    StringBuilder sb = new StringBuilder();
	    for(int i=0;i<nums.length;i++) s_nums[i] = String.valueOf(nums[i]); // convert each value to string
	    Arrays.sort(s_nums,(a,b) -> {
//	    	System.out.println((b+a) + " VS " + (a+b) + " = " + (b+a).compareTo(a+b) );
	    	return (b+a).compareTo(a+b) ;}); // sort the values 
	    if(s_nums[0].charAt(0) == '0') return "0"; // to pass the test case with multiple zeros 
	    for(String s: s_nums) sb.append(s); 
	    return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("30".compareTo("3")) ;
		System.out.println(largestNumber(new int[] {3,30,34})) ; // 9534330
	}

}
