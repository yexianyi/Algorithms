package com.yxy.algorithms.array.string.group.anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
 */
public class Solution {
	
	public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> summary = new HashMap<String, List<String>>() ;
		
		for(String str : strs){
			boolean[] map = new boolean[27];
			for(int i=0; i<str.length(); i++){
				map[str.charAt(i)-'a'] = true ;
			}
			
			StringBuilder keyBuilder = new StringBuilder() ;
			for(int i=0; i<map.length; i++){
				if(map[i]){
					keyBuilder.append(i) ;
				}
			}
			
			String key = keyBuilder.toString() ;
			List<String> set = null ;
			if(summary.containsKey(key)){
				set = summary.get(key) ;
			}else{
				set = new ArrayList<String>() ;
			}
			set.add(str) ;
			summary.put(key, set) ;
		}
		
		List<List<String>> ret = new ArrayList<List<String>>() ;
		for(List<String> set : summary.values()){
			ret.add(new ArrayList<String>(set)) ;
		}
		
		return ret ;
    }

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[]{"",""}) );
		System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}) );
	}

}
