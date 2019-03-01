package com.yxy.algorithms.string.num.segement;

/**
 * 434. Number of Segments in a String
    Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
    
    Please note that the string does not contain any non-printable characters.
    
    Example:
    
    Input: "Hello, my name is John"
    Output: 5
 * @author yexianyi
 * 2019/03/01
 * 
 */
public class Solution {
    
    public static int countSegments(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(i==0 && s.charAt(0) != ' ') {
                count ++ ;
                continue ;
            }
            
            if(s.charAt(i) != ' ' && s.charAt(i-1) == ' ') {
                count ++ ;
            }
        }
        
        return count ;
    }

    public static void main(String[] args) {
        System.out.println(countSegments(" abc  d ef g ")) ; // 4
        System.out.println(countSegments("abc  d ef g ")) ; // 4
        System.out.println(countSegments(" abc  d ef g")) ; // 4
        System.out.println(countSegments("  abc  d ef g ")) ; // 4
    }

}
