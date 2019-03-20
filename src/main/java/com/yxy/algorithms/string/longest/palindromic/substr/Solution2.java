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
 * Reference:
 * https://leetcode.com/problems/longest-palindromic-substring/solution/
 */
public class Solution2 {

    // Expand Around Center
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        int max = 0;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extendingRange(s, i, i); // "aba"
            int len2 = extendingRange(s, i, i + 1); // "bb"

            int len = Math.max(len1, len2);
            // max = Math.max(max, len) ;
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int extendingRange(String str, int i, int j) {
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            i--; // extend range to left
            j++; // extend range to right
        }

        return j - i - 1;

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babadada"));
        System.out.println(longestPalindrome("aba"));
        // System.out.println(longestPalindrome("a"));
        // System.out.println(longestPalindrome("ac"));
        // System.out.println(longestPalindrome("cbbd"));
        // System.out.println(longestPalindrome("babad"));
    }

}
