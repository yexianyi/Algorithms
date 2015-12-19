package com.yxy.algorithms.contains.duplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public boolean containsDuplicate(int[] nums) {
		if(nums==null || nums.length==0){
			return false ;
		}
		
		Set set = new HashSet() ;
		for(int num : nums){
			if(set.contains(num)){
				return true ;
			}
			set.add(num) ;
		}
		
		return false;

	}


}
