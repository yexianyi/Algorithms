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
 */
public class Solution2 {

    public static boolean isPerfectSquare(int num) {
        for(int i = 0; i<Integer.MAX_VALUE;) {
            if((i*i) == num) {
                return true ;
            }
            
            if((i*i) > num) {
                return false ;
            }
            
            if(num%2==0) {
                i += 2 ;
            } else {
                i ++ ;
            }
        }
        
        return false  ;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(14)) ;
        System.out.println(isPerfectSquare(16)) ;
    }

}
