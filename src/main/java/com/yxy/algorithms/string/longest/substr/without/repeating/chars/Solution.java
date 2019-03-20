package com.yxy.algorithms.string.longest.substr.without.repeating.chars;

import java.util.HashSet;
import java.util.Set;
/**
 * 3. Longest Substring Without Repeating Characters
    Given a string, find the length of the longest substring without repeating characters.
    
    Example 1:
    
    Input: "abcabcbb"
    Output: 3 
    Explanation: The answer is "abc", with the length of 3. 
    Example 2:
    
    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.
    Example 3:
    
    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3. 
                 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * @author yexianyi
 * 2019/03/20
 * 
 */
public class Solution {

    //Brute Force
    public static int lengthOfLongestSubstring(String s) {
        int max = 0 ;
        Set<Character> set = new HashSet<>() ;
        
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                char ch = s.charAt(j) ;
                if(set.contains(ch)) {
                    max = Math.max(max, set.size()) ;
                    set.clear();
                    break ;
                } else {
                    set.add(ch) ;
                }
                
            }
            
        }
        
        
        return Math.max(max, set.size()) ;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

}
