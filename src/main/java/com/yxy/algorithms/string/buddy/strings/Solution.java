package com.yxy.algorithms.string.buddy.strings;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    public static boolean buddyStrings(String A, String B) {
        
        if(A.length() != B.length() || A.length() == 0 || B.length() == 0) {
            return false ;
        }
        
        char _chA1 =0 ,_chA2 = 0,_chB1 = 0,_chB2 = 0 ;
        
        for(int i=0; i<A.length() - 1; i++) {
            _chA1 = A.charAt(i) ;
            _chA2 = A.charAt(i+1) ;
            _chB1 = B.charAt(i) ;
            _chB2 = B.charAt(i+1) ;
            
            if(_chA1 == _chB1) {
                continue ;
            }
            
            if(_chA1 != _chB2 || _chA2 != _chB1) {
                return false ;
            }
        }
        
        if(_chA1 != _chB2 || _chA2 != _chB1) {
            return false ;
        }
        return true ;
    }

    public static void main(String[] args) {
        System.out.println(buddyStrings("abab", "abab")) ;
        System.out.println(buddyStrings("ab", "ba")) ;
        System.out.println(buddyStrings("ab", "ab")) ;
        System.out.println(buddyStrings("aa", "aa")) ;
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb")) ;
        
    }

}
