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
package com.yxy.algorithms.string.last.word.length;

/**
 * 	58. Length of Last Word My Submissions Question
	Total Accepted: 77433 Total Submissions: 273522 Difficulty: Easy
	Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
	
	If the last word does not exist, return 0.
	
	Note: A word is defined as a character sequence consists of non-space characters only.
	
	For example, 
	Given s = "Hello World",
	return 5.
 * @author xianyiye
 * 2016/1/6
 */

public class Solution2 {
	
	public static int lengthOfLastWord(String s) {
		int count = 0 ;
		if(s!=null){
			s = s.trim() ;
		}
		
		for(int i=s.length()-1; i>=0; i--){
			if(s.charAt(i)==' '){
				break ;
			}
			count++ ;
		}
		
		
		return count;
    }

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("hello world "));

	}

}
