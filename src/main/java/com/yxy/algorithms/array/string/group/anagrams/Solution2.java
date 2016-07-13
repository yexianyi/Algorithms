package com.yxy.algorithms.array.string.group.anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 49. Group Anagrams  QuestionEditorial Solution  My Submissions
	Total Accepted: 82070
	Total Submissions: 286890
	Difficulty: Medium
	Given an array of strings, group anagrams together.
	
	For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
	Return:
	
	[
	  ["ate", "eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	Note: All inputs will be in lower-case.
	
 * @author xianyiye
 * @date 07/13/2016
 * 
 */
public class Solution2 {
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>() ;
		String[] copyArray = new String[strs.length] ;
		
		for(int i=0; i<strs.length; i++){
			char[] chars = strs[i].toCharArray() ;
			Arrays.sort(chars);
			copyArray[i] = String.copyValueOf(chars) ;
		}

		
		for(int i=0; i<copyArray.length; i++){
			if(!map.containsKey(copyArray[i])){
				map.put(copyArray[i], new ArrayList<String>()) ;
			}
			
			map.get(copyArray[i]).add(strs[i]) ;
		}
		
		List<List<String>> ret = new ArrayList<List<String>>() ;
		for(List<String> list : map.values()){
			ret.add(list) ;
		}
		
		return ret ;
    }

	public static void main(String[] args) {
//		System.out.println(groupAnagrams(new String[]{"",""}) );
		System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}) );
	}

}
