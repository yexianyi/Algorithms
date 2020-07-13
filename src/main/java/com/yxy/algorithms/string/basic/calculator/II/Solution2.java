package com.yxy.algorithms.string.basic.calculator.II;

/**
 * 227. Basic Calculator II
Medium
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.
 * @author Ye Xianyi
 * 2020/07/13
 * 
 * Copy from:
 * https://leetcode.com/problems/basic-calculator-ii/discuss/729230/Java-simple-recursive-solution-with-explanation
 */

public class Solution2 {

    public static int calculate(String s) {
        return eval(s, 0, s.length());
    }

    private static int eval(String s, int from, int to) {
        for (int i = to - 1; i >= from; i--) {
            char c = s.charAt(i);
            if (c == ' ' || c == '*' || c == '/') continue;
            if (c == '+') return eval(s, from, i) + eval(s, i + 1, to);
            if (c == '-') return eval(s, from, i) - eval(s, i + 1, to);
        }
        for (int i = to - 1; i >= from; i--) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '*') return eval(s, from, i) * eval(s, i + 1, to);
            if (c == '/') return eval(s, from, i) / eval(s, i + 1, to);
        }

        return Integer.parseInt(s.substring(from, to).trim());
    }

    public static void main(String[] args) {
        System.out.println(calculate("12-3+15/13*2+7*2-4")) ;
    }

}
