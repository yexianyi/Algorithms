package com.yxy.algorithms.integer.sqrt;


/**
 * 
 * 69. Sqrt(x)
    Implement int sqrt(int x).
    
    Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
    
    Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
    
    Example 1:
    
    Input: 4
    Output: 2
    Example 2:
    
    Input: 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since 
                 the decimal part is truncated, 2 is returned.
 * 
 * @author yexianyi
 * 2019/03/05
 * 
 * Copy from:
 * https://www.cnblogs.com/qlky/p/7735145.html
 */
public class Solution {

    /**
     * Trick:
     * The sqrt() of an positive integer 'x' will be between [0, x/2+1]
     * 
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int i = 0;
        int j = x / 2 + 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int sq = mid * mid;
            if (sq == x)
                return mid;
            else if (sq < x)
                i = mid + 1;
            else
                j = mid - 1;
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(4));

    }

}
