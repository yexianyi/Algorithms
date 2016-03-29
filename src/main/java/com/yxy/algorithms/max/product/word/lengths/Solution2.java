package com.yxy.algorithms.max.product.word.lengths;

/**
 * 	318. Maximum Product of Word Lengths My Submissions QuestionEditorial Solution
	Total Accepted: 16473 Total Submissions: 42058 Difficulty: Medium
	Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
	
	Example 1:
	Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
	Return 16
	The two words can be "abcw", "xtfn".
	
	Example 2:
	Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
	Return 4
	The two words can be "ab", "cd".
	
	Example 3:
	Given ["a", "aa", "aaa", "aaaa"]
	Return 0
	No such pair of words.


 * @author Xianyi Ye
 * @Date 03/29/2016
 * 
 * Reference: 
 * https://leetcode.com/discuss/83227/my-easy-understanding-java-solution-with-explaination
 */
public class Solution2 {
	
	public static int maxProduct(String[] words) {
		int[] bitMap = new int[words.length];
	    for(int i=0; i<words.length; i++) {
	        for(int j=0; j<words[i].length(); j++) {
	            bitMap[i] |= 1 << (words[i].charAt(j) - 'a');
	        }
	        
//	        System.out.println(Integer.toBinaryString(bitMap[i]));
	    }
	    
	    int result = 0;
	    for(int i=0; i<bitMap.length; i++) {
	        for(int j=i+1; j<bitMap.length; j++) {
	            if((bitMap[i] & bitMap[j]) == 0) {
	                result = Math.max(words[i].length() * words[j].length(), result);
	            }
	        }
	    }
	    return result;
    }
	

	public static void main(String[] args) {
		String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"} ;
		System.out.println(maxProduct(words)) ;
		
		String[] words2 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"} ;
		System.out.println(maxProduct(words2)) ;
		
		String[] words3 = {"a", "aa", "aaa", "aaaa"} ;
		System.out.println(maxProduct(words3)) ;
		
	}

}
