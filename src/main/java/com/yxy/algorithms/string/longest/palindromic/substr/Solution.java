package com.yxy.algorithms.string.longest.palindromic.substr;

/**
 * 5. Longest Palindromic Substring
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
    
    Example 1:
    
    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
    Example 2:
    
    Input: "cbbd"
    Output: "bb"
 * @author yexianyi
 * 2019/03/20
 * 
 */
public class Solution {

    //Time Limit Exceeded
    public static String longestPalindrome(String s) {
        return longestPalindrome(s, 0, s.length()-1) ;
    }

    private static String longestPalindrome(String str, int i, int j) {
        int start = i ;
        int end = j;
        while(i<j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++; j--;
            } else {
                break ;
            }
        }
        
        if(i>=j) {
            return str.substring(start, end+1) ;
        } else {
            String right = longestPalindrome(str, start+1, end) ;
            String left = longestPalindrome(str, start, end-1) ;
            
            return left.length() > right.length() ? left : right ;
        }
        
    }
    

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babadada"));
        System.out.println(longestPalindrome("aba"));
//        System.out.println(longestPalindrome("a"));
//        System.out.println(longestPalindrome("ac"));
//        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome("babad"));
    }

}
