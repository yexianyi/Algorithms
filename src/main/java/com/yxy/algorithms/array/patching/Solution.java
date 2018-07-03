package com.yxy.algorithms.array.patching;

/**
 * 330. Patching Array My Submissions QuestionEditorial Solution
	Total Accepted: 11136 Total Submissions: 37267 Difficulty: Medium
	Given a sorted positive integer array nums and an integer n, 
	add/patch elements to the array such that any number in range [1, n] inclusive 
	can be formed by the sum of some elements in the array. Return the minimum number of patches required.
	
	Example 1:
	nums = [1, 3], n = 6
	Return 1.
	
	Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
	Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
	Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
	So we only need 1 patch.
	
	Example 2:
	nums = [1, 5, 10], n = 20
	Return 2.
	The two patches can be [2, 4].
	
	Example 3:
	nums = [1, 2, 2], n = 5
	Return 0.

 * @author xianyiye
 * @date 06/12/2016
 *	Reference:
 *	http://www.cnblogs.com/grandyang/p/5165821.html
 *	https://blog.csdn.net/yzhang6_10/article/details/51590616
 */
public class Solution {
	
	public static int minPatches(int[] nums, int n) {
		long sum = 1 ;
		int patches = 0 ;
		int i = 0 ;
		
		while(sum<=n){
			if(i<nums.length && sum>=nums[i]){
				sum += nums[i++] ;
			}else{
//				System.out.println("Adding "+sum);
				//The tricky part is to understand that if we have covered range [1 -> num], 
				//then adding num + 1 can extend the range to [1..2*num + 1].
				sum += sum ;
				patches++ ;
			}
		}
		
        return patches ;
    }

	public static void main(String[] args) {
		System.out.println(minPatches(new int[]{1,2,31,33}, 2147483647));
		System.out.println(minPatches(new int[]{}, 7));
		System.out.println(minPatches(new int[]{1, 2, 4, 11, 30}, 50));
	}

}
