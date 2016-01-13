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

public class Solution2 {
	
	public static boolean isPalindrome(String s) {
        if(s == null){
        	return false ;
        }
        
        if(s.length()==0){
        	return true ;
        }
        
        s = s.toLowerCase() ;
        char[] array = s.toCharArray() ;
        int start = 0;
        int end = s.length()-1 ;
        
        while(start<=end){
        	char s_ch = array[start];
        	char e_ch = array[end] ;
        	if(!((s_ch>=48 && s_ch<=57) || (s_ch>=97 && s_ch<=122))){
        		start++ ;
        		continue ;
        	}
        	
        	if(!((e_ch>=48 && e_ch<=57) || (e_ch>=97 && e_ch<=122))){
        		end-- ;
        		continue ;
        	}
        	
        	if(s_ch!=e_ch){
        		return false ;
        	}
        	
        	start++ ;
        	end-- ;
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
