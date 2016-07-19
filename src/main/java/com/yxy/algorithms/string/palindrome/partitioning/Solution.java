package com.yxy.algorithms.string.palindrome.partitioning;

import java.util.ArrayList;
import java.util.List;
/**
 * 131. Palindrome Partitioning  QuestionEditorial Solution  My Submissions
	Total Accepted: 69521
	Total Submissions: 245358
	Difficulty: Medium
	Given a string s, partition s such that every substring of the partition is a palindrome.
	
	Return all possible palindrome partitioning of s.
	
	For example, given s = "aab",
	Return
	
	[
	  ["aa","b"],
	  ["a","a","b"]
	]
 * @author xianyiye
 * @date 07/19/2016
 * 
 * Reference:
 * https://discuss.leetcode.com/topic/6186/java-backtracking-solution/4
 */
public class Solution {
	
	//beats 69.8%
	public static List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<List<String>>() ;
		dfs(s, 0, new ArrayList<String>(), ret ) ;
		return ret ;
	}
	
	 private static void dfs(String str, int start, List<String> list, List<List<String>> res){
        if(start==str.length()) {
        	res.add(new ArrayList<String>(list));
        }else{
            for(int i=start; i<str.length(); i++){
                if(isPal(str,start,i)){ //IMPORTANT!! The embedded recursion calling must be included in this IF condition. 
                    list.add(str.substring(start,i+1));
                    dfs(str,i+1,list,res);
                    list.remove(list.size()-1);
                }
            }
        }
    }
	 
	 private static boolean isPal(String s, int low, int high){
        while(low<high){
        	if(s.charAt(low++)!=s.charAt(high--)){
        		return false;
        	}
        }
        
        return true;
    }
	    

	public static void main(String[] args) {
		List<List<String>> ret = partition("caaab") ;
		System.out.println("================");
		for(List<String> list : ret){
			for(String str : list){
				System.out.print(" "+str);
			}
			System.out.println() ;
		}
	}

}
