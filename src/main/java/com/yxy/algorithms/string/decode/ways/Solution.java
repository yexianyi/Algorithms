package com.yxy.algorithms.string.decode.ways;
/**
 * 91. Decode Ways
Medium

1882

2136

Favorite

Share
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

 * @author Ye Xianyi
 * 2019/12/09
 *
 * Reference:
 * https://www.cnblogs.com/springfor/p/3896162.html
 */
public class Solution {
	
	public static int numDecodings(String s) {  
		int dp[] = new int[s.length()+1] ;
		dp[0] = 1 ;
		
		if(isValid(s.substring(0,1))) { // check s[0]
			dp[1] = 1 ;
		}else {
			dp[1] = 0 ;
		}
		
		for(int i=2; i<=s.length(); i++) {
			if(isValid(s.substring(i-1,i))) { // check s[i]
				dp[i] += dp[i-1] ;
			}
			
			if(isValid(s.substring(i-2,i))) { // check s[i-1:i]
				dp[i] += dp[i-2] ;
			}
			
		}
		return dp[s.length()] ;
    }  
	
	
	public static boolean isValid(String s){  
        if (s.length() == 1 && s.charAt(0) != '0') 
            return true;  
        if(s.length() == 2 && s.charAt(0) == '1' && s.charAt(1) <= '9') {
        	return true ;
        }
        if(s.length() == 2 && s.charAt(0) == '2' && s.charAt(1) <= '6') {
        	return true ;
        }
        return false ; 
    }
      

	public static void main(String[] args) {
//		System.out.println(numDecodings("123")); // 2
//		System.out.println(numDecodings("12")); // 2
		System.out.println(numDecodings("00")); // 2
//		System.out.println(numDecodings("17")); // 2
//		System.out.println(numDecodings("27")); // 1
//		System.out.println(numDecodings("10")); // 1
//		System.out.println(numDecodings("226")); // 3
//		System.out.println(numDecodings("26")); // 2
	}

}
