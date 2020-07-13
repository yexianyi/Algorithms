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
 */

public class Solution {

    // NOT WORKING
    public static int calculate(String s) {
       
        while(s.contains("*") || s.contains("/")) {
            s = handling(s) ;
        }
        
        int sum = 0 ;
        Character op = null ;
        String curr = "";
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i) ;
            if(ch == '+' || ch == '-') {
                op = ch ;
            } 
            
            //number
            if(op == null) {
                sum = Integer.valueOf(curr) ;
            } else {
                if(op == '+') {
                    sum += Integer.valueOf(curr) ;
                }
                
                if(op == '-') {
                    sum -= Integer.valueOf(curr) ;
                }
            }
            
        }
        
        return sum ;
    }
    
    private static String handling(String s) {
        s = s.replaceAll(" ", "") ;
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i) ;
            if(ch == '*' || ch == '/') {
                //find left num
                int j = i-1 ;
                while(s.charAt(j) != '+' && s.charAt(j) != '-') {
                    j-- ;
                }
                String left = s.substring(j+1, i) ;
                //find right num
                int k = i+1 ;
                while(s.charAt(k) >= '0' && s.charAt(k) <= '9' ) {
                    k++ ;
                }
                String right = s.substring(i+1, k) ;
                
                //calculate
                int temp = 0 ;
                if(ch == '*') {
                    temp = Integer.valueOf(left) * Integer.valueOf(right) ;
                } else {
                    temp = Integer.valueOf(left) / Integer.valueOf(right) ;
                }
                
                s = s.replace(left+ch+right, temp + "") ;
             
            }
        }
        
        return s ;
    }
    

    public static void main(String[] args) {
        System.out.println(calculate("12-3+15/13*2+7*2-4")) ;
    }

}
