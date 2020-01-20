package com.yxy.algorithms.string.find.repeated.dna.seq;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static List<String> findRepeatedDnaSequences(String s) {
		Set<String> set = new HashSet<>() ;
		List<String> res = new ArrayList<>() ;
		
		int len = s.length() ;
		for(int i=0; i+10<len; i++) {
			String subStr = s.substring(i, i+10) ;
			if(set.contains(subStr)) {
				res.add(subStr) ;
			} else {
				set.add(subStr) ;
			}
		}
		
		return res ;
	}

	public static void main(String[] args) {
		List<String> res = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT") ;
		for(String str:res) {
			System.out.println(str);
		}

	}

}
