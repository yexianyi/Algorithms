package com.yxy.algorithms.string.longest.substr.with.at.most.two.distinct.characters;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
Medium
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
 * @author Xianyi Ye
 * 2020/10/12
 *
 */
public class Solution {
    
    
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, right = 0;
        int max = 0 ;
        
        Map<Character, Integer> window = new HashMap<>() ;
        
        while(right < s.length()){
            char ch = s.charAt(right) ;
            if(window.size() <= 2){
                window.put(ch, right) ;
            } 

            if(window.size() > 2){
                int del_idx = Collections.min(window.values());
                window.remove(s.charAt(del_idx)) ;
                left = del_idx + 1 ;
            }
            max = Math.max(max, right - left + 1) ;
            right ++ ;
        }
        
        return max ;
    }
    

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("abaccc"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        
    }

}
