package com.yxy.algorithms.array.h.index.II;
/**
 * 
 * @author xianyiye
 * @date 05/24/2016
 * Copy from:
 * https://leetcode.com/discuss/56122/standard-binary-search
 */
public class Solution {

	public static int hIndex(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;
		
		int l = 0, r = citations.length;
		int n = citations.length;
		
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (citations[mid] == n - mid)
				return n - mid;
			if (citations[mid] < citations.length - mid)
				l = mid + 1;
			else //citations[mid] > len-mid : "citations is bigger", and the paper is not enough, so we should go to the left part to find the little citation
				r = mid;
		}
		return n - l;
    }
	
	public static void main(String[] args) {
		System.out.println(hIndex(new int[]{0,1,4,5,6}));

	}

}
