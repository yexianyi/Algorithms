package com.yxy.algorithms.array.single.num.III;

/**
 * 	260. Single Number III My Submissions Question
	Total Accepted: 22236 Total Submissions: 53008 Difficulty: Medium
	Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
	
	For example:
	
	Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
	
	Note:
	The order of the result is not important. So in the above example, [5, 3] is also correct.
	Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * @author xianyiye
 * Reference:
 * https://leetcode.com/discuss/60408/sharing-explanation-of-the-solution
 * https://leetcode.com/discuss/71567/java-easy-version-to-understand
 */
public class Solution2 {
	
	public static int[] singleNumber(int[] nums) {
		if(nums==null||nums.length==0)
		       return new int[0];
	    int[] a=new int[2];
	    int t1=0,t2=0,n=nums.length,t=0,s=1;
	    for(int i=0;i<n;i++){
	       t^=nums[i];
	    }
	    
	    while((t&s)==0){//
           s=s<<1;
	    }

	    for(int i=0;i<n;i++){
          if((nums[i]&s)==0)
            t1^=nums[i];
          else if((nums[i]&s)!=0)
            t2^=nums[i];
	    }
	    a[0]=t1;
	    a[1]=t2;
	    return a;   
    }

	public static void main(String[] args) {
//		int[] results = singleNumber(new int[]{1,2,3,1,4,2}) ;
//		int[] results = singleNumber(new int[]{1,2,3,1,4,2,5,5,6,6}) ;
		int[] results = singleNumber(new int[]{0,1,1,2}) ;
		for(int result : results){
			System.out.print(result+" ");
		}

	}

}
