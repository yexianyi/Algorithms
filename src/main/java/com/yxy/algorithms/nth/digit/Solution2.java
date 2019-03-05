package com.yxy.algorithms.nth.digit;

/**
 * 400. Nth Digit
    Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
    
    Note:
    n is positive and will fit within the range of a 32-bit signed integer (n < 231).
    
    Example 1:
    
    Input:
    3
    
    Output:
    3
    Example 2:
    
    Input:
    11
    
    Output:
    0
    
    Explanation:
    The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 * @author yexianyi
 * 2019/03/04
 * 
 *  Copy from:
 *  https://leetcode.com/problems/nth-digit/discuss/170608/Java-Solution-with-Explanation-and-Example
 */

public class Solution2 {

    public static int findNthDigit(int n) {
        long digitAmount = 9;
        int start = 1;
        int length = 1;
        
        while (n > length * digitAmount) {
            n = (int) (n - length * digitAmount);
            digitAmount = digitAmount * 10;
            start = start * 10;
            ++length;
        }
        
        int offset = (n - 1) / length;
        start += offset;
        return ((int) Integer.toString(start).charAt((n - 1) % length) - (int) '0');
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(11)); // 0
        System.out.println(findNthDigit(10)); // 1
        System.out.println(findNthDigit(3)); // 3
        System.out.println(findNthDigit(9)); // 9
    }

}
