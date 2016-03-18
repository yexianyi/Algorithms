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
package com.yxy.algorithms.string.valid.palindrome;

/**
 * 	125. Valid Palindrome My Submissions Question
	Total Accepted: 83306 Total Submissions: 362503 Difficulty: Easy
	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	
	For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.
	
	Note:
	Have you consider that the string might be empty? This is a good question to ask during an interview.
	
	For the purpose of this problem, we define empty string as valid palindrome.
 * @author xianyiye
 * 2016/1/13
 */

public class Solution3 {
	
	private static final char[] map = new char[256] ;
	
	static{
		for(int i=0; i<10; i++){
			map[i+'0'] = (char) ('0'+i) ;
		}
		
		for(int i=0; i<26; i++){
			map[i+'a'] = (char) ('a'+i) ;
			map[i+'A'] = (char) ('a'+i) ;
		}
	}
	
	public static boolean isPalindrome(String s) {
        if(s == null){
        	return false ;
        }
        
        if(s.length()==0){
        	return true ;
        }
        
//        s = s.toLowerCase() ; //Do not try to lower case the sting, because of low performance.
        char[] array = s.toCharArray() ;
        int start = 0;
        int end = s.length()-1 ;
        
        while(start<=end){
        	char s_ch = array[start];
        	char e_ch = array[end] ;
        	
        	if(map[s_ch] != 0 && map[e_ch] != 0){
        		if(map[s_ch]!=map[e_ch]){
        			return false ;
        		}
        		start++ ;
        		end-- ;
        	}else{
        		if(map[s_ch] == 0){
            		start++ ;
            		continue ;
            	}
            	
            	if(map[e_ch] == 0){
            		end-- ;
            		continue ;
            	}
        	}
        }
        
        return true ;
        
    }

	public static void main(String[] args) {
		System.out.println(isPalindrome("0P"));
		System.out.println(isPalindrome("aa"));
		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("race a car"));

	}

}
