package com.yxy.algorithms.array.find.peak.elem;
/**
 * 162. Find Peak Element My Submissions QuestionEditorial Solution
	Total Accepted: 66136 Total Submissions: 200452 Difficulty: Medium
	A peak element is an element that is greater than its neighbors.
	
	Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
	
	The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
	
	You may imagine that num[-1] = num[n] = -∞.
	
	For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
	
	click to show spoilers.
	
	Note:
	Your solution should be in logarithmic complexity.

 * @author xianyiye
 * @date 05/23/2016
 * Copy from:
 * https://leetcode.com/discuss/18107/o-logn-solution-javacode
 */
public class Solution5 {
	/**
	 * This problem is similar to Local Minimum. And according to the given condition, num[i] != num[i+1], there must exist a O(logN) solution. So we use binary search for this problem.

		If num[i-1] < num[i] > num[i+1], then num[i] is peak
		If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
		If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
		If num[i-1] > num[i] < num[i+1], then both sides have peak (n is num.length)
	 * @param num
	 * @return
	 */
	   public int findPeakElement(int[] num) {    
	    return helper(num,0,num.length-1);
	}

	public int helper(int[] num,int start,int end){
	    if(start == end){
	        return start;
	    }else if(start+1 == end){
	        if(num[start] > num[end]) return start;
	        return end;
	    }else{

	        int m = (start+end)/2;

	        if(num[m] > num[m-1] && num[m] > num[m+1]){
	            return m;
	        }else if(num[m-1] > num[m] && num[m] > num[m+1]){
	            return helper(num,start,m-1);
	        }else{
	            return helper(num,m+1,end);
	        }

	    }
	}
	}
