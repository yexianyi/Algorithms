package com.yxy.algorithms.string.reverse;

/**
 * 344. Reverse String 
 * Write a function that reverses a string. The input string is given as an array of characters
 * char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra
 * memory.
 * 
 * You may assume all the characters consist of printable ascii characters.
 * 
 * 
 * Example 1:
 * 
 * Input: ["h","e","l","l","o"] Output: ["o","l","l","e","h"] Example 2:
 * 
 * Input: ["H","a","n","n","a","h"] Output: ["h","a","n","n","a","H"]
 * 
 * @author yexianyi 2019/03/18
 */
public class Solution {

    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            s[i] = (char) (s[i] ^ s[j]);
            s[j] = (char) (s[i] ^ s[j]);
            s[i] = (char) (s[i] ^ s[j]);

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[] { 'h', 'e', 'l', 'l', 'o', };
        reverseString(s);
        for (char ch : s) {
            System.out.print(ch + " ");
        }

    }

}
