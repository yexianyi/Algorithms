package com.yxy.algorithms.integer.power.x.n;

/**
 * 50. Pow(x, n)
    Implement pow(x, n), which calculates x raised to the power n (xn).
    
    Example 1:
    
    Input: 2.00000, 10
    Output: 1024.00000
    Example 2:
    
    Input: 2.10000, 3
    Output: 9.26100
    Example 3:
    
    Input: 2.00000, -2
    Output: 0.25000
    Explanation: 2-2 = 1/22 = 1/4 = 0.25
    Note:
    
    -100.0 < x < 100.0
    n is a 32-bit signed integer, within the range [−231, 231 − 1]

 * @author yexianyi
 * 2019/04/15
 * 
 * Copy from:
 * https://leetcode.com/problems/powx-n/discuss/19593/O-(logn)-solution-in-Java
 */
public class Solution {
    public double myPow(double x, int m) {
        double temp = x;
        
        if (m == 0)
            return 1;
        temp = myPow(x, m / 2);
        
        if (m % 2 == 0)
            return temp * temp;
        else {
            if (m > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }

    public static void main(String[] args) {

    }

}
