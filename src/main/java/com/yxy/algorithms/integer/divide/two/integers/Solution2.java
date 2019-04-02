package com.yxy.algorithms.integer.divide.two.integers;

/**
 * 29. Divide Two Integers Medium
 * 
 * Share Given two integers dividend and divisor, divide two integers without using multiplication, division and mod
 * operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * 
 * The integer division should truncate toward zero.
 * 
 * Example 1:
 * 
 * Input: dividend = 10, divisor = 3 Output: 3 Example 2:
 * 
 * Input: dividend = 7, divisor = -3 Output: -2 Note:
 * 
 * Both dividend and divisor will be 32-bit signed integers. The divisor will never be 0. Assume we are dealing with an
 * environment which could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For the purpose
 * of this problem, assume that your function returns 231 − 1 when the division result overflows.
 * 
 * @author yexianyi
 * 2019/04/02
 * 
 * Reference:
 * https://www.jianshu.com/p/982d1f0ea98d
 * 
 * Copy from:
 * https://leetcode.com/problems/divide-two-integers/discuss/263891/A-JAVA-BIT-MANIPULATION-SOLUTION
 */
public class Solution2 {

    public static int divide(int dividend, int divisor) {
        if (divisor == Integer.MIN_VALUE)
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long ans = 0;
        if (dividend == Integer.MIN_VALUE && divisor > 0) {
            dividend += divisor;
            ans = 1;
        }
        if (dividend == Integer.MIN_VALUE && divisor < 0) {
            dividend -= divisor;
            ans = 1;
        }

        long dvd = Math.abs(dividend);
        long dvs = Math.abs(divisor);

        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;

        while (dvd >= dvs) {
            long temp = dvs, m = 1;
            while (temp << 1 <= dvd) {
                temp <<= 1;
                m <<= 1;
            }
            dvd -= temp;
            ans += m;
        }
        return (int) (sign * ans);
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 2));
        System.out.println(divide(-2147483648, 1));
        System.out.println(divide(1, 1));
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
    }

}
