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
 * https://leetcode.com/problems/basic-calculator-ii/discuss/719575/My-Java-Solution-without-Stack-O(n)-time-and-O(1)-space-complexity.
 */

public class Solution3 {

    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int oper = 1; // 1 -> addition, -1 -> subtraction, 2 -> multiply , -2 -> divide
        int res = 0;
        int prev = 0;
        s = s.trim();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') continue;
            if(Character.isDigit(s.charAt(i))) {
                int index = i;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int curr = Integer.parseInt(s.substring(index, i));
                if(oper == 1) {
                    res += curr;
                    prev = curr;
                } else if(oper == -1) {
                    res -= curr;
                    prev = -curr;
                } else if(oper == 2) {
                    res = res-prev + prev * curr;
                    prev = prev * curr;
                } else if(oper == -2) {
                    res = res-prev + prev / curr;
                    prev = prev / curr;
                }
                i--;
            } else if(s.charAt(i) == '+') {
                oper = 1;
            } else if(s.charAt(i) == '-') {
                oper = -1;
            } else if(s.charAt(i) == '*') {
                oper = 2;
            } else if(s.charAt(i) == '/') {
                oper = -2;
            }
        }
        return res;
    }
}
