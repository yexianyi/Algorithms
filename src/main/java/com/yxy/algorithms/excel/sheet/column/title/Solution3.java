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
 */
public class Solution3 {
	
	public static String convertToTitle(int n) {
		// 0-25 -> A-Z, so n will dercrease by 1
        n = n-1;
        if(n<=25) 
            return ""+(char)(n+65);
        else
            return convertToTitle(n/26)+""+(char)(n%26+65);
    }

	public static void main(String[] args) {
		System.out.println(convertToTitle(26)) ;
		System.out.println(convertToTitle(27)) ;
		System.out.println(convertToTitle(28)) ;
		System.out.println(convertToTitle(54)) ;
	}

}
