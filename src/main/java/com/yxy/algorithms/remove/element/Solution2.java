package com.yxy.algorithms.remove.element;

/**
 * 	27. Remove Element My Submissions Question
	Total Accepted: 91574 Total Submissions: 281965 Difficulty: Easy
	Given an array and a value, remove all instances of that value in place and return the new length.
	
	The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * @author xianyiye
 * 2015/12/23
 */

public class Solution2 {
	
	public static int removeElement(int[] nums, int val) {
		if(nums==null || nums.length==0){
			return 0 ;
		}
		
		int p1 = 0 ;
		int p2 = nums.length-1 ;
		
		while(p1<=p2){
			if(nums[p1] == val){
				while(p1!=p2 && nums[p2]==val){
					p2-- ;
				}
				
				if(p1==p2){
					break ;
				}
				
				nums[p1] = nums[p1] ^ nums[p2] ;
				nums[p2] = nums[p2] ^ nums[p1] ;
				nums[p1] = nums[p1] ^ nums[p2] ;
				p2-- ;
			}
			p1++ ;
		}
		
		
        return p1 ;
    }

	public static void main(String[] args) {
//		removeElement(new int[]{2,4,3,2,5,2,1},2) ;
//		removeElement(new int[]{2,3,3},3) ;
//		removeElement(new int[]{3,3},3) ;
		System.out.println(removeElement(new int[]{2},3) );
		System.out.println(removeElement(new int[]{4,5},4)) ;

	}

}
