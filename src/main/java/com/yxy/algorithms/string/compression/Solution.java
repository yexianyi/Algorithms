package com.yxy.algorithms.string.compression;

public class Solution {
    
    public int compress(char[] chars) {
       
        for(int i=0; i<chars.length; i++) {
            int count = 1 ;
            for(int j=i+1; j<chars.length; j++) {
                if(chars[i] == chars[j]) {
                    count++ ;
                    chars[j] = ' ' ;
                } else {
                    
                }
            }
            
        }
            
        
        return -1 ;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
