/**
 * Copyright (c) 2016, Xianyi Ye
 *
 * This project includes software developed by Xianyi Ye
 * yexianyi@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.yxy.algorithms.string.isomorphic;

/**
 * 	205. Isomorphic Strings My Submissions Question
	Total Accepted: 41194 Total Submissions: 148377 Difficulty: Easy
	Given two strings s and t, determine if they are isomorphic.
	
	Two strings are isomorphic if the characters in s can be replaced to get t.
	
	All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
	
	For example,
	Given "egg", "add", return true.
	
	Given "foo", "bar", return false.
	
	Given "paper", "title", return true.
	
	Note:
	You may assume both s and t have the same length.
	
 * @author xianyiye
 * 2016/1/7
 */
public class Solution {
	
	public static boolean isIsomorphic(String s, String t) {
		int[] map1 = new int[256] ;
        int[] map2 = new int[256] ;
        
        for(int i=0; i<s.length(); i++){
        	if(map1[s.charAt(i)]!=map2[t.charAt(i)]){
        		return false ;
        	}else{
        		map1[s.charAt(i)] = i+1 ;
        		map2[t.charAt(i)] = i+1 ;
        	}
        }
		
		return true ;
    }

	public static void main(String[] args) {
		System.out.println(isIsomorphic("paperr","titlew"));

	}

}
