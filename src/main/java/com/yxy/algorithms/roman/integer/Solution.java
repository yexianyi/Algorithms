package com.yxy.algorithms.roman.integer;


/**
 * 13. Roman to Integer My Submissions Question
	Total Accepted: 64641 Total Submissions: 176114 Difficulty: Easy
	Given a roman numeral, convert it to an integer.
	
	Input is guaranteed to be within the range from 1 to 3999.
	@author Xianyi Ye
 * 	2015/12/21
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public int romanToInt(String s) {
        if(s==null || s.length()==0){
        	return 0 ;
        }
		
		Map<Character, Integer> map = new HashMap<Character, Integer>() ;
		map.put('I', 1) ;
		map.put('V', 5) ;
		map.put('X', 10) ;
		map.put('L', 50) ;
		map.put('C', 100) ;
		map.put('D', 500) ;
		map.put('M', 1000) ;
		
		int total = 0;
		
		for(int i=0; i<s.length(); i++){
			int a = map.get(s.charAt(i)) ;
			if(i < s.length()-1){
				int b = map.get(s.charAt(i+1)) ;
				if(a<b){
					total -= a ;
				}else{
					total += a ;
				}
			}else{
				total += a ;
			}
			
			
		}
		
		return total ;
    }

	public static void main(String[] args) {
		Solution s = new Solution() ;
//		System.out.println(s.romanToInt("XCIX")) ; //99
		System.out.println(s.romanToInt("MMMCMXCIX")) ; //3999
//		System.out.println(s.romanToInt("MCMXCVI")) ; //1996

	}

}
