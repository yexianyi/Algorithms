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
package com.yxy.algorithms.string.word.pattern;

/**
 * 	290. Word Pattern My Submissions Question
	Total Accepted: 20676 Total Submissions: 75398 Difficulty: Easy
	Given a pattern and a string str, find if str follows the same pattern.
	
	Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
	
	Examples:
	pattern = "abba", str = "dog cat cat dog" should return true.
	pattern = "abba", str = "dog cat cat fish" should return false.
	pattern = "aaaa", str = "dog cat cat dog" should return false.
	pattern = "abba", str = "dog dog dog dog" should return false.
	Notes:
	You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 *
 * @author xianyiye
 * 2016/1/7
 */

public class Solution2 {
	
	public static boolean wordPattern(String pattern, String str) {
		String[] array = str.split(" ") ;
		if(pattern.length() != array.length){
			return false ;
		}
		
		String[] map = new String[26] ;
		
		for(int i=0; i<array.length; i++){
			if(map[pattern.charAt(i)-96]==null){
				//check if key has already existed
				for(int j=0; j<26; j++){
					if(map[j]!=null && map[j].equals(array[i])){
						return false ;
					}
				}
				map[pattern.charAt(i)-96]=array[i] ;
			}else{
				if(!map[pattern.charAt(i)-96].equals(array[i])){
					return false ;
				}
			}
		}
		
		return true;
        
    }

	public static void main(String[] args) {
		System.out.println(wordPattern("abba","dog cat cat dog"));//true
		System.out.println(wordPattern("abba","dog cat cat fish"));//false
		System.out.println(wordPattern("aaaa","dog cat cat dog"));//false
		System.out.println(wordPattern("abba","dog dog dog dog"));//false

	}

}
