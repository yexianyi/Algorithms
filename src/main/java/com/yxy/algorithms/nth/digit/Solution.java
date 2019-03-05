package com.yxy.algorithms.nth.digit;

import java.util.Stack;

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
 */

public class Solution {

    // Time Limit Exceeded
    public static int findNthDigit(int n) {
        Stack<Integer> stack = new Stack<>();
        int counter = 0;

        for (int num = 1; num <= Integer.MAX_VALUE; num++) {
            int copy = num;
            while (copy > 0) {
                int remain = copy % 10;
                copy = copy / 10;
                stack.push(remain);
            }

            while (!stack.isEmpty()) {
                if (++counter == n) {
                    return stack.pop();
                }

                stack.pop();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(11)); // 0
        System.out.println(findNthDigit(10)); // 1
        System.out.println(findNthDigit(3)); // 3
        System.out.println(findNthDigit(9)); // 9
    }

}
