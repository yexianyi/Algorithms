package com.yxy.algorithms.string.repeat.match;

/**
 * 686. Repeated String Match 
 * Given two strings A and B, find the minimum number of times A has to be repeated such that
 * B is a substring of it. If no such solution, return -1.
 * 
 * For example, with A = "abcd" and B = "cdabcdab".
 * 
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A
 * repeated two times ("abcdabcd").
 * 
 * Note: The length of A and B will be between 1 and 10000.
 * 
 * @author yexianyi
 * 2019/03/06
 */
public class Solution {

    public static int repeatedStringMatch(String A, String B) {
        int count = 1;
        String copy = A;
        while (!A.contains(B) && A.length() < B.length() + copy.length()) {
            A += copy;
            count++;
        }

        return A.contains(B) ? count : -1;
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abc", "cabcabca"));
        System.out.println(repeatedStringMatch("a", "aa"));
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
    }

}
