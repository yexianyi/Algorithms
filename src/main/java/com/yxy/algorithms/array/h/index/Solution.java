package com.yxy.algorithms.array.h.index;
/**
 * 274. H-Index My Submissions QuestionEditorial Solution
	Total Accepted: 34518 Total Submissions: 116432 Difficulty: Medium
	Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
	
	According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
	
	For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
	
	Note: If there are several possible values for h, the maximum one is taken as the h-index.
	
	Hint:
	
	An easy approach is to sort the array first.
	What are the possible values of h-index?
	A faster approach is to use extra space.
 * @author xianyiye
 * @date 05/25/2016
 * Reference from:
 * https://leetcode.com/discuss/66656/java-o-n-time-with-easy-explanation
 */
public class Solution {
	
	public static int hIndex(int[] citations) {
		int[] map = new int[citations.length+1] ;
		
		for(int i=0; i<citations.length ; i++){
			if(citations[i]>=citations.length){
				map[citations.length]++ ;
			}else{
				map[citations[i]]++ ;
			}
		}
		
		int maxSum = 0; 
		for(int i=map.length-1; i>=0; i--){
			maxSum += map[i] ;
			if(maxSum>=i){
				return i ;
			}
		}
		
		return 0 ;
    }

	public static void main(String[] args) {
		System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
	}

}
