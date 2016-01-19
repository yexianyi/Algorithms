package com.yxy.algorithms.excel.sheet.column.title;

/**
 * 	168. Excel Sheet Column Title My Submissions Question
	Total Accepted: 49052 Total Submissions: 240758 Difficulty: Easy
	Given a positive integer, return its corresponding column title as appear in an Excel sheet.
	
	For example:
	
	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 
 * @author xianyiye
 * 2016/1/19
**/

public class Solution2 {
	
	public static String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
        while(n--!=0){
            sb.append((char)(n%26+'A'));
            n/=26;
        }
        return sb.length()==0?"A":sb.reverse().toString();
        
    }

	public static void main(String[] args) {
		System.out.println(convertToTitle(26)) ;
		System.out.println(convertToTitle(27)) ;
		System.out.println(convertToTitle(28)) ;
		System.out.println(convertToTitle(54)) ;
	}

}
