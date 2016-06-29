package com.yxy.algorithms.numbers.ugly.num.II;
/**
 * 264. Ugly Number II My Submissions QuestionEditorial Solution
	Total Accepted: 33897 Total Submissions: 116596 Difficulty: Medium
	Write a program to find the n-th ugly number.
	
	Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
	
	Note that 1 is typically treated as an ugly number.
	
	Hint:
	
	The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
	An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
	The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
	Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).


 * @author xianyiye
 * @date 06/29/2016
 * 
 * Copy from:
 * https://leetcode.com/discuss/71549/o-n-java-easy-version-to-understand
 *
 */
public class Solution2 {
	
	static int getMin(int a,int b,int c){
	     int min=Math.min(a,b);
	     min=Math.min(min,c);
	     return min;
	}
	
	public static int nthUglyNumber(int n) {
	    if(n==1)
	      return 1;
	      int[] a=new int[n];
	    int p2=0,p3=0,p5=0,p=1,count=1;
	     a[0]=1;
	    while(count<n){
	        a[p]=getMin(a[p2]*2,a[p3]*3,a[p5]*5);
	        while(a[p2]*2<=a[p])
	           p2++;
	        while(a[p3]*3<=a[p])
	           p3++;
	        while(a[p5]*5<=a[p])
	           p5++;

	          p++;
	          count++;
	    }
	    return a[--p];
	}
	public static void main(String[] args) {
		System.out.println(nthUglyNumber(8)) ;
	}

}
