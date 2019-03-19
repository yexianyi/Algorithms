package com.yxy.algorithms.string.decode;

/**
 * 394. Decode String
    Given an encoded string, return it's decoded string.
    
    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
    
    You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
    
    Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
    
    Examples:
    
    s = "3[a]2[bc]", return "aaabcbc".
    s = "3[a2[c]]", return "accaccacc".
    s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

 * @author yexianyi
 * 2019/03/19
 * 
 */
public class Solution {

    public static String decodeString(String s) {
        
        for(int i=0; i<s.length(); i++) {
            while(i<s.length()) {
                char ch = s.charAt(i) ;
                if(Character.isDigit(ch)) {
                    break ;
                }
                
                i++ ;
            }
            
            int j=i ;
            
            while(j<s.length()) {
                char ch = s.charAt(j) ;
                if(!Character.isDigit(ch)) {
                    break ;
                }
                
                j++ ;
            }
            
            if(i == s.length()) {
                break ;
            }
            
            int times = Integer.parseInt(s.substring(i, j)) ;
            int k = j ;
            int count = 0;
            while(k<s.length()) {
                if(s.charAt(k) == '[') {
                    count ++ ;
                } else if(s.charAt(k) == ']') {
                    count -- ;
                    if(count == 0) {
                        break ;
                    }
                }
                
                k++ ;
            }
            
            String childStr = s.substring(j+1, k) ;
            StringBuilder temp = new StringBuilder() ;
            for(int t=0; t<times; t++) {
                temp.append(childStr) ;
            }
            
            s = s.replace(s.substring(i,k+1), temp) ;
            i = -1 ;
        }
        
        return s ;
    }
    
    

    public static void main(String[] args) {
        System.out.println(decodeString("2[20[bc]31[xy]]xd4[rt]"));
        System.out.println(decodeString("3[a2[c]]4[b]"));
        System.out.println(decodeString("3[c]"));

    }

}
