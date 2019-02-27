package com.yxy.algorithms.string.buddy.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 859. Buddy Strings
Easy

Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
Example 1:

Input: A = "ab", B = "ba"
Output: true
Example 2:

Input: A = "ab", B = "ab"
Output: false
Example 3:

Input: A = "aa", B = "aa"
Output: true
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false
 

Note:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist only of lowercase letters.

 * @author yexianyi
 * 2019/02/26
 */
public class Solution {

    public static boolean buddyStrings(String A, String B) {
        // If length is not equal with each other, return false ;
        if (A.length() != B.length() || A.length() == 0 || B.length() == 0) {
            return false;
        }

        // remember diff pos in two string
        List<Integer> diffPos = new ArrayList<>(2);
        int j = 0;

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diffPos.add(i);
            }
        }

        // String A != String B
        if (diffPos.size() == 2) {
            if (A.charAt(diffPos.get(0)) == B.charAt(diffPos.get(1))
             && A.charAt(diffPos.get(1)) == B.charAt(diffPos.get(0))) {
                return true;
            } else {
                return false;
            }
        }

        // String A == String B && exists duplicate letters in A and B, then return true;
        if (diffPos.size() == 0) {
            Set<Character> diff = new HashSet<>(A.length());
            for (char ch : A.toCharArray()) {
                diff.add(ch);
            }
            if (diff.size() < A.length()) {
                return true;
            }
        }

        // String A and B constains different letter more than 2
        return false;
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("abcaa", "abcbb")); // false
        System.out.println(buddyStrings("aabc", "aacb")); // true
        System.out.println(buddyStrings("ab", "ab")); // false
        System.out.println(buddyStrings("ab", "ba")); // true
        System.out.println(buddyStrings("aa", "aa")); // true
        System.out.println(buddyStrings("abab", "abab")); // true

    }

}
