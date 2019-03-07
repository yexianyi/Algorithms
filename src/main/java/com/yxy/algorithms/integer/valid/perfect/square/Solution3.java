package com.yxy.algorithms.integer.valid.perfect.square;


/**
 * 367. Valid Perfect Square
    Given a positive integer num, write a function which returns True if num is a perfect square else False.
    
    Note: Do not use any built-in library function such as sqrt.
    
    Example 1:
    
    Input: 16
    Output: true
    Example 2:
    
    Input: 14
    Output: false

 * @author yexianyi
 * 2019/03/07
 *
 *  Copy from:
 *  https://leetcode.com/problems/valid-perfect-square/discuss/250194/java-0ms-O(lgn)
 *  
 *  Refrerence:
 *  https://blog.csdn.net/sunbobosun56801/article/details/78088085
 */
public class Solution3 {

    public static boolean isPerfectSquare(int num) {
        long r = num;
        while (r * r > num) {
            r = (r + num / r) / 2;
        }

        return r * r == num;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(14));
        System.out.println(isPerfectSquare(16));
    }

}
