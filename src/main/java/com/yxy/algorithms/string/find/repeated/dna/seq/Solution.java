package com.yxy.algorithms.string.find.repeated.dna.seq;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 187. Repeated DNA Sequences
	Medium
	All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
	
	Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
	
	Example:
	
	Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
	
	Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 * @author Ye Xianyi
 * 2020/01/21
 */
public class Solution {

	public static List<String> findRepeatedDnaSequences(String s) {
		Set<String> set = new HashSet<>() ;
		Set<String> res = new HashSet<>() ;
		
		int len = s.length() ;
		for(int i=0; i+10<=len; i++) {
			String subStr = s.substring(i, i+10) ;
			if(set.contains(subStr)) {
				res.add(subStr) ;
			} else {
				set.add(subStr) ;
			}
		}
		
		return new ArrayList<>(res) ;
	}

	public static void main(String[] args) {
//		List<String> res = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT") ;
		List<String> res = findRepeatedDnaSequences("AAAAAAAAAAA") ;
		for(String str:res) {
			System.out.println(str);
		}

	}

}
